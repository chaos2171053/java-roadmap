package com.example.sbredismysqlrbmqseckill.controller;

import com.example.sbredismysqlrbmqseckill.bean.Order;
import com.example.sbredismysqlrbmqseckill.service.OrderService;
import com.example.sbredismysqlrbmqseckill.service.RedisService;
import com.example.sbredismysqlrbmqseckill.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @ResponseBody
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

    @GetMapping("/secDataBaseLock")
    @ResponseBody
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
}
