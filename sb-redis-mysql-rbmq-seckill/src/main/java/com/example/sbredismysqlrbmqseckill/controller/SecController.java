package com.example.sbredismysqlrbmqseckill.controller;

import com.example.sbredismysqlrbmqseckill.bean.Order;
import com.example.sbredismysqlrbmqseckill.service.OrderService;
import com.example.sbredismysqlrbmqseckill.service.RedisService;
import com.example.sbredismysqlrbmqseckill.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SecController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StockService stockService;


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

    @GetMapping("/secRedis")
    public String secRedis(@RequestParam(value = "username") Integer username, @RequestParam(value = "stockName") String stockName) {
        synchronized(this){
            String message = "";
            // 调用redis给相应商品库存量减一
            Long decrByResult = redisService.decrBy(stockName);
            if (decrByResult >= 0) {
                log.info("用户：{}秒杀该商品：{}库存有余 {} 件，可以进行下订单操作", Thread.currentThread().getId(), stockName, decrByResult+1);
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
                log.info("用户：{} 秒杀后同步数据库库存到 redis {}",Thread.currentThread().getId(),currentStock);
                redisService.put(stockName, currentStock, 20);
            } else {
                log.info("用户：{}.参加秒杀结果是：秒杀已经结束", username);
                message = username + "参加秒杀活动结果是：秒杀已经结束";
            }

            return message;
        }

    }

}
