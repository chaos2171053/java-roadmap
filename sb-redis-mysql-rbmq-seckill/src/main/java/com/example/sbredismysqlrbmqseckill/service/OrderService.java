package com.example.sbredismysqlrbmqseckill.service;

import com.example.sbredismysqlrbmqseckill.bean.Order;

public interface OrderService {
    public void createOrder(Order order);

    // 发送订单消息到延迟订单队列
    public void sendOrderDelayed(Order order);
}
