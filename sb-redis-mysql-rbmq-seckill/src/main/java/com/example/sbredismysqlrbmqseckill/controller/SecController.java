package com.example.sbredismysqlrbmqseckill.controller;

import com.example.sbredismysqlrbmqseckill.bean.MessageSend;
import com.example.sbredismysqlrbmqseckill.bean.Order;
import com.example.sbredismysqlrbmqseckill.bean.Stock;
import com.example.sbredismysqlrbmqseckill.config.MyRabbitMQConfig;
import com.example.sbredismysqlrbmqseckill.service.*;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class SecController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StockService stockService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedisDistributedLock redisDistributedLock;
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private final String SEC_REDIS_LUA_SCRIPT_PATH = "scripts/sec_redis.lua";
    @Autowired
    MessageSendService messageSendService;


    /**
     * 使用数据库进行秒杀，不加锁
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secDataBaseNoLock")
    public String secDataBaseNoLock(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        log.info("线程：{}, 参加秒杀的用户是：{}，秒杀的商品是：{}", Thread.currentThread().getId(), username, stockName);
        String message = "";
        Integer stockCount = stockService.selectByName(stockName);
        // get lock

        if (stockCount > 0) {
            // 还有库存
            // 1. 库存减一
            stockService.decrByStock(stockName);
            // 2. 生成订单
            Order order = new Order();
            order.setOrderName(stockName);
            order.setOrderUser(username);
            orderService.createOrder(order);
            log.info("用户：{}.参加秒杀结果是：成功", username);
            message = username + "参加秒杀结果是：成功";
        } else {
            log.info("用户：{}.参加秒杀结果是：秒杀已经结束", username);
            message = username + "参加秒杀活动结果是：秒杀已经结束";
        }
        return message;
    }

    /***
     * 使用数据库进行秒杀，加锁
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secDataBaseLock")
    public String secDataBaseNoLockLock(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        synchronized (this) {
            //log.info("线程：{}, 参加秒杀的用户是：{}，秒杀的商品是：{}", Thread.currentThread().getId(), username, stockName);
            String message = "";
            Integer stockCount = stockService.selectByName(stockName);
            log.info("用户：{}参加秒杀，当前商品库存量是：{}", username, stockCount);
            if (stockCount > 0) {
                // 还有库存
                // 1. 库存减一
                stockService.decrByStock(stockName);
                // 2. 生成订单
                Order order = new Order();
                order.setOrderName(stockName);
                order.setOrderUser(username);
                orderService.createOrder(order);
                log.info("用户：{}.参加秒杀结果是：成功", username);
                message = username + "参加秒杀结果是：成功";
            } else {
                log.info("用户：{}.参加秒杀结果是：秒杀已经结束", username);
                message = username + "参加秒杀活动结果是：秒杀已经结束";
            }
            return message;
        }
    }

    @GetMapping("hello")
    public String hello() {
        log.info("hello");
        return "hello";
    }

    /**
     * 把商品库存预先放在 redis，在redis 中事先扣减库存
     * 这样会存在 redis 中库存为负数的情况
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secRedis")
    public String secRedis(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        synchronized (this) {
            String message = "";
            // 调用redis给相应商品库存量减一
            Long decrByResult = redisService.decrBy(stockName);
            if (decrByResult >= 0) {
                log.info("用户：{}秒杀该商品：{}库存有余 {} 件，可以进行下订单操作", Thread.currentThread().getId(), stockName, decrByResult + 1);
                // 1. 库存减一
                stockService.decrByStock(stockName);
                // 2. 生成订单
                Order order = new Order();
                order.setOrderName(stockName);
                order.setOrderUser(username);
                orderService.createOrder(order);
                log.info("用户：{}.参加秒杀结果是：成功", Thread.currentThread().getId());
                message = username + "参加秒杀结果是：成功";
                // 无支付，订单生成成功，直接更新数据库中的库存到 redis
                Integer currentStock = stockService.selectByName(stockName);
                log.info("用户：{} 秒杀后同步数据库库存到 redis {}", Thread.currentThread().getId(), currentStock);
                redisService.put(stockName, currentStock, 20);
            } else {
                log.info("用户：{}.参加秒杀结果是：秒杀已经结束", username);
                message = username + "参加秒杀活动结果是：秒杀已经结束";
            }

            return message;
        }

    }

    /**
     * 使用 lua 脚本扣减 redis 中的库存
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secRedisLua")
    public String secRedisLua(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        synchronized (this) {
            String message = "";
            // 为了方便没有判断用户已经秒杀成功，避免重复秒杀
            DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
            redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource(SEC_REDIS_LUA_SCRIPT_PATH)));
            redisScript.setResultType(String.class);
            String luaScriptResult = stringRedisTemplate.execute(redisScript, Collections.singletonList(stockName), username.toString(), stockName);
            if ("success".equals(luaScriptResult)) {
                log.info("用户：{} 秒杀该商品：可以进行下订单操作", Thread.currentThread().getId());
                // 1. 库存减一
                stockService.decrByStock(stockName);
                // 2. 生成订单
                Order order = new Order();
                order.setOrderName(stockName);
                order.setOrderUser(username);
                orderService.createOrder(order);
                log.info("用户：{}.参加秒杀结果是：成功", Thread.currentThread().getId());
                message = username + "参加秒杀结果是：成功";
            } else {
                log.info("用户：{}.参加秒杀结果是：秒杀已经结束", username);
                message = username + "参加秒杀活动结果是：秒杀已经结束";
            }
            return message;
        }
    }

    /**
     * 使用 redis watch 秒杀，会造成一个单也没有，秒杀却全部完成，库存还在。
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secRedisWatch")
    public String secRedisWatch(Integer username, String stockName) {
        String message = "";
        String stockKey = stockName; // 这里假设 Redis 中的键就是库存名称

        try {
            redisTemplate.watch(stockKey);

            String currentStockStr = (String) redisTemplate.opsForValue().get(stockKey);

            if (currentStockStr != null) {
                Integer currentStock = Integer.valueOf(currentStockStr);
                if (currentStock > 0) {
                    log.info("用户：{} 秒杀该商品：可以进行下订单操作", Thread.currentThread().getId());
                    redisTemplate.multi();
                    redisTemplate.opsForValue().decrement(stockKey);

                    try {
                        redisTemplate.exec();
                        // 1. 库存减一
                        stockService.decrByStock(stockName);
                        // 2. 生成订单
                        Order order = new Order();
                        order.setOrderName(stockName);
                        order.setOrderUser(username);
                        orderService.createOrder(order);
                        message = username + "参加秒杀结果是：成功";
                        log.info(message);
                    } catch (Exception e) {
                        log.info("========回滚事务====");
                        // 回滚事务
                        redisTemplate.discard();
                        message = username + "参加秒杀活动结果是：回滚事务";
                        log.info(message);
                    }

                } else {
                    message = username + "参加秒杀活动结果是：秒杀已经结束";
                    log.info(message);
                }

            } else {
                message = username + "参加秒杀活动结果是：库存不足";
                log.info(message);
            }
        } catch (Exception e) {
            // 处理异常
            message = "发生异常：" + e.getMessage();
        } finally {
            redisTemplate.unwatch();
        }
        return message;
    }

    /**
     * 使用数据库进行秒杀，使用乐观锁，添加version 字段
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secDataBaseVersionLock")
    public String secDataBaseVersionLock(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        log.info("线程：{}, 参加秒杀的用户是：{}，秒杀的商品是：{}", Thread.currentThread().getId(), username, stockName);
        String message = "";
        // 查询当前库存信息，包括版本号
        Stock stock = stockService.queryStockByName(stockName);

        if (stock != null && stock.getStock() > 0) {
            // 还有库存，准备更新库存
            int affectedRows = stockService.decrByStockWithVersion(stock);
            if (affectedRows > 0) {
                // 还有库存
                // 2. 生成订单
                Order order = new Order();
                order.setOrderName(stockName);
                order.setOrderUser(username);
                orderService.createOrder(order);
                log.info("用户：{}.参加秒杀结果是：成功", username);
                message = username + "参加秒杀结果是：成功";
            } else {
                // 更新失败，可能是版本号不匹配，或库存已经为零
                message = username + "参加秒杀活动结果是：更新失败，可能是版本号不匹配，或库存已经为零";
            }

        } else {
            log.info("用户：{}.参加秒杀结果是：秒杀已经结束", username);
            message = username + "参加秒杀活动结果是：秒杀已经结束";
        }
        return message;
    }

    /**
     * 使用数据库进行秒杀，使用悲观锁
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secDataBaseWithPessimisticLock")
    @Transactional
    public String secDataBaseWithPessimisticLock(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        log.info("线程：{}, 参加秒杀的用户是：{}，秒杀的商品是：{}", Thread.currentThread().getId(), username, stockName);
        String message = "";
        // 查询当前库存信息，包括版本号
        // MySQL 不支持在 UPDATE 语句中使用 FOR UPDATE 关键字。FOR UPDATE 通常用于 SELECT 查询，用于获取被选中的行的锁。
//        下面是一个示例：
//
//        sql
//        Copy code
//        BEGIN;
//        SELECT * FROM seckill.stock WHERE id = #{id} AND stock > 0 FOR UPDATE;
//        UPDATE seckill.stock SET stock = stock - 1 WHERE id = #{id} AND stock > 0;
//        COMMIT;
        // 在事务中使用 SELECT ... FOR UPDATE 来锁定要更新的行，然后再执行 UPDATE 操作，确保了更新的原子性和一致性。
        Stock stock = stockService.selectByNameWithPessimisticLock(stockName);
        if (stock != null) {
            // 直接扣减库存
            int affectedRows = stockService.decrByStockWithPessimisticLock(stock);
            if (affectedRows > 0) {
                // 还有库存
                // 2. 生成订单
                Order order = new Order();
                order.setOrderName(stockName);
                order.setOrderUser(username);
                orderService.createOrder(order);
                log.info("用户：{}.参加秒杀结果是：成功", username);
                message = username + "参加秒杀结果是：成功";
            } else {
                // 更新失败，可能是版本号不匹配，或库存已经为零
                message = username + "参加秒杀活动结果是：库存已经为零";
            }
        } else {
            message = username + "参加秒杀活动结果是：stock不存在";
        }
        return message;
    }

    /**
     * 使用redis 分布式锁进行秒杀
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secRedisDistributedLock")
    public String secRedisDistributedLock(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        log.info("线程：{}, 参加秒杀的用户是：{}，秒杀的商品是：{}", Thread.currentThread().getId(), username, stockName);
        String message = "";
        boolean lockAcquired = redisDistributedLock.acquireLock(stockName, String.valueOf(Thread.currentThread().getId()), 15);
        try {
            if (lockAcquired) {
                Integer stockCount = stockService.selectByName(stockName);
                if (stockCount > 0) {
                    // 还有库存
                    // 1. 库存减一
                    stockService.decrByStock(stockName);
                    // 2. 生成订单
                    Order order = new Order();
                    order.setOrderName(stockName);
                    order.setOrderUser(username);
                    orderService.createOrder(order);
                    log.info("用户：{}.参加秒杀结果是：成功", username);
                    message = username + "参加秒杀结果是：成功";
                } else {
                    log.info("用户：{}.参加秒杀结果是：秒杀已经结束", username);
                    message = username + "参加秒杀活动结果是：秒杀已经结束";
                }

            } else {
                // 获取锁失败，说明其他线程正在进行秒杀操作，返回秒杀失败信息
                log.info("获取锁失败，说明其他线程正在进行秒杀操作，返回秒杀失败信息");
                message = "秒杀失败，请稍后重试";
            }
        } finally {
            redisDistributedLock.releaseLock(stockName, String.valueOf(Thread.currentThread().getId()));
        }
        return message;
    }

    /**
     * 使用redis 分布式锁+lua进行秒杀
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secRedisDistributedLuaLock")
    public String secRedisDistributedLuaLock(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        log.info("线程：{}, 参加秒杀的用户是：{}，秒杀的商品是：{}", Thread.currentThread().getId(), username, stockName);
        String message = "";
        boolean lockAcquired = redisDistributedLock.acquireLock(stockName, String.valueOf(Thread.currentThread().getId()), 15);
        try {
            if (lockAcquired) {
                Integer stockCount = stockService.selectByName(stockName);
                if (stockCount > 0) {
                    // 还有库存
                    // 1. 库存减一
                    stockService.decrByStock(stockName);
                    // 2. 生成订单
                    Order order = new Order();
                    order.setOrderName(stockName);
                    order.setOrderUser(username);
                    orderService.createOrder(order);
                    log.info("用户：{}.参加秒杀结果是：成功", username);
                    message = username + "参加秒杀结果是：成功";
                } else {
                    log.info("用户：{}.参加秒杀结果是：秒杀已经结束", username);
                    message = username + "参加秒杀活动结果是：秒杀已经结束";
                }

            } else {
                // 获取锁失败，说明其他线程正在进行秒杀操作，返回秒杀失败信息
                log.info("获取锁失败，说明其他线程正在进行秒杀操作，返回秒杀失败信息");
                message = "秒杀失败，请稍后重试";
            }
        } finally {
            redisDistributedLock.releaseLockByLua(stockName, String.valueOf(Thread.currentThread().getId()));
        }
        return message;
    }

    /**
     * 使用 redission 秒杀
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secRedisson")
    public String secRedisson(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        log.info("线程：{}, 参加秒杀的用户是：{}，秒杀的商品是：{}", Thread.currentThread().getId(), username, stockName);
        String message = "";
        RLock lock = redissonClient.getLock("stock_" + stockName);
        try {
            // 尝试加锁，等待时间为100秒，锁的过期时间为10秒
            if (lock.tryLock(100, 10, TimeUnit.SECONDS)) {
                Integer stockCount = stockService.selectByName(stockName);
                if (stockCount > 0) {
                    stockService.decrByStock(stockName);
                    Order order = new Order();
                    order.setOrderName(stockName);
                    order.setOrderUser(username);
                    orderService.createOrder(order);
                    message = username + "参加秒杀结果是：成功";
                } else {
                    message = username + "参加秒杀活动结果是：秒杀已经结束";
                }
            } else {
                message = "获取锁超时";
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            message = "秒杀过程中发生异常";
        } finally {
            lock.unlock();
        }
        return message;
    }
    /**
     * 使用 redission + rabbitmq 秒杀
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secRedissonMQ")
    public String secRedissonMQ(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        log.info("线程：{}, 参加秒杀的用户是：{}，秒杀的商品是：{}", Thread.currentThread().getId(), username, stockName);
        String message = "";
        RLock lock = redissonClient.getLock("stock_" + stockName);
        try {
            // 尝试加锁，等待时间为100秒，锁的过期时间为10秒
            if (lock.tryLock(100, 10, TimeUnit.SECONDS)) {
                Integer stockCount = stockService.selectByName(stockName);
                if (stockCount > 0) {
                    // 发消息给库存消息队列，将库存数据减一
                    rabbitTemplate.convertAndSend(MyRabbitMQConfig.STOCK_EXCHANGE, MyRabbitMQConfig.STOCK_ROUTING_KEY, stockName);
                    Order order = new Order();
                    order.setOrderName(stockName);
                    order.setOrderUser(username);
                    //发消息给订单消息队列，创建订单
                    rabbitTemplate.convertAndSend(MyRabbitMQConfig.ORDER_EXCHANGE, MyRabbitMQConfig.ORDER_ROUTING_KEY, order);
                    //orderService.createOrder(order);
                    message = username + "参加秒杀结果是：成功";
                } else {
                    message = username + "参加秒杀活动结果是：秒杀已经结束";
                }
            } else {
                message = "获取锁超时";
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            message = "秒杀过程中发生异常";
        } finally {
            lock.unlock();
        }
        return message;
    }

    /**
     * 使用redis 分布式自旋锁+lua进行秒杀
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secRedisDistributedSpinLuaLock")
    public String secRedisDistributedSpinLuaLock(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        log.info("线程：{}, 参加秒杀的用户是：{}，秒杀的商品是：{}", Thread.currentThread().getId(), username, stockName);
        String message = "";

        // 定义自旋次数
        int spinCount = 10;
        while (spinCount-- > 0) {
            boolean lockAcquired = redisDistributedLock.acquireLock(stockName, String.valueOf(Thread.currentThread().getId()), 15);
            try {
                if (lockAcquired) {
                    Integer stockCount = stockService.selectByName(stockName);
                    if (stockCount > 0) {
                        // 还有库存
                        // 1. 库存减一
                        stockService.decrByStock(stockName);
                        // 2. 生成订单
                        Order order = new Order();
                        order.setOrderName(stockName);
                        order.setOrderUser(username);
                        orderService.createOrder(order);
                        log.info("用户：{}.参加秒杀结果是：成功", username);
                        message = username + "参加秒杀结果是：成功";
                    } else {
                        log.info("用户：{}.参加秒杀结果是：秒杀已经结束", username);
                        message = username + "参加秒杀活动结果是：秒杀已经结束";
                    }
                    break; // 跳出自旋循环
                }
            } finally {
                redisDistributedLock.releaseLockByLua(stockName, String.valueOf(Thread.currentThread().getId()));
            }
            // 自旋等待一段时间后再重试
            try {
                Thread.sleep(100); // 休眠100毫秒
            } catch (InterruptedException e) {
                // 忽略中断异常
            }
        }

        if (spinCount <= 0) {
            // 自旋次数耗尽，未能获取到锁
            log.info("自旋次数耗尽，未能获取到锁");
            message = "秒杀失败，请稍后重试";
        }

        return message;
    }

    /**
     * 使用 redission + rabbitmq + 消息发送表
     *
     * @param username
     * @param stockName
     * @return
     */
    @GetMapping("/secRedissonMQMessageTable")
    public String secRedissonMQMessageTable(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        log.info("线程：{}, 参加秒杀的用户是：{}，秒杀的商品是：{}", Thread.currentThread().getId(), username, stockName);
        String message = "";
        RLock lock = redissonClient.getLock("stock_" + stockName);
        try {
            // 尝试加锁，等待时间为100秒，锁的过期时间为10秒
            if (lock.tryLock(100, 10, TimeUnit.SECONDS)) {
                Integer stockCount = stockService.selectByName(stockName);
                if (stockCount > 0) {

                    MessageSend messageSend = new MessageSend();
                    messageSend.setUsername(username);
                    messageSend.setStockName(stockName);
                    messageSend.setStatus("待处理");
                    messageSendService.insertMessageSend(messageSend);

                    // 发消息给库存消息队列，将库存数据减一
                    rabbitTemplate.convertAndSend(MyRabbitMQConfig.STOCK_EXCHANGE, MyRabbitMQConfig.STOCK_ROUTING_KEY, messageSend);
                    Order order = new Order();
                    order.setOrderName(stockName);
                    order.setOrderUser(username);
                    //发消息给订单消息队列，创建订单
                    // 生成订单也应该更新消息表，这里就不做处理了
                    rabbitTemplate.convertAndSend(MyRabbitMQConfig.ORDER_EXCHANGE, MyRabbitMQConfig.ORDER_ROUTING_KEY, order);
                    message = username + "参加秒杀结果是：成功";
                } else {
                    message = username + "参加秒杀活动结果是：秒杀已经结束";
                }
            } else {
                message = "获取锁超时";
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            message = "秒杀过程中发生异常";
        } finally {
            log.info("线程：{}, 参加秒杀的用户是：{}，秒杀的商品是：{},释放锁", Thread.currentThread().getId(), username, stockName);
            lock.unlock();
        }
        return message;
    }

}
