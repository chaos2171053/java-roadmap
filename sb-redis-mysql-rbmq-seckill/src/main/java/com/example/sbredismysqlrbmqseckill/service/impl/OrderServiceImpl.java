package com.example.sbredismysqlrbmqseckill.service.impl;

import com.example.sbredismysqlrbmqseckill.bean.Order;
import com.example.sbredismysqlrbmqseckill.mapper.OrderMapper;
import com.example.sbredismysqlrbmqseckill.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private  OrderMapper orderMapper;
    @Override
    public void createOrder(Order order) {
        log.info("createOrder {}",order);
        orderMapper.insert(order);
    }
}
