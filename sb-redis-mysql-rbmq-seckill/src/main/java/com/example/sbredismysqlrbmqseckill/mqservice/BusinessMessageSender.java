package com.example.sbredismysqlrbmqseckill.mqservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.sbredismysqlrbmqseckill.config.RabbitMQConfig.BUSINESS_EXCHANGE_NAME;

@Component
public class BusinessMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg){
        rabbitTemplate.convertSendAndReceive(BUSINESS_EXCHANGE_NAME, "", msg);
    }
}
