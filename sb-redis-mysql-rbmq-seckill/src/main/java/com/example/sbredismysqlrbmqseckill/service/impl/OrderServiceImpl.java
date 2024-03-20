package com.example.sbredismysqlrbmqseckill.service.impl;

import com.example.sbredismysqlrbmqseckill.bean.Order;
import com.example.sbredismysqlrbmqseckill.mapper.OrderMapper;
import com.example.sbredismysqlrbmqseckill.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.sbredismysqlrbmqseckill.config.OrderMQConfig.DELAYED_EXCHANGE_NAME;
import static com.example.sbredismysqlrbmqseckill.config.OrderMQConfig.DELAYED_ROUTING_KEY;


@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private  OrderMapper orderMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Override
    public void createOrder(Order order) {
        log.info("createOrder {}",order);
        orderMapper.insert(order);
    }

    @Override
    // 发送订单消息到延迟订单队列
    public void sendOrderDelayed(Order order) {
//        MessageProperties properties = new MessageProperties();
//        properties.setExpiration("10000"); // TTL为10秒
//        Message message = rabbitTemplate.getMessageConverter().toMessage(order, properties);
        //rabbitTemplate.convertAndSend(MyRabbitMQConfig.DELAY_ORDER_EXCHANGE,MyRabbitMQConfig.DELAY_ORDER_ROUTING_KEY, order);
        rabbitTemplate.convertAndSend(DELAYED_EXCHANGE_NAME, DELAYED_ROUTING_KEY, order, a ->{
            a.getMessageProperties().setDelay(5000);
            return a;
        });
        log.info("订单已发送到延迟订单队列: {}", order);
    }
}
