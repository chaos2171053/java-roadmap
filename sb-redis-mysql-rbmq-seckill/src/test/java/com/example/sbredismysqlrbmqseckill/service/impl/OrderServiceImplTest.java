package com.example.sbredismysqlrbmqseckill.service.impl;

import com.example.sbredismysqlrbmqseckill.bean.Order;
import com.example.sbredismysqlrbmqseckill.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    private  OrderService orderService;

    @Test
    void createOrder() {
        Order order = new Order();
        order.setOrderName("下单Q弹豆干");
        order.setOrderUser(1);
        orderService.createOrder(order);
    }
}