package com.example.sbredismysqlrbmqseckill.mqservice;


import com.example.sbredismysqlrbmqseckill.constants.DelayTypeEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.sbredismysqlrbmqseckill.config.RabbitMQTutorialConfig.*;

@Component
public class DelayMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg, DelayTypeEnum type){
        switch (type){
            case DELAY_10s:
                rabbitTemplate.convertAndSend(DELAY_EXCHANGE_NAME, DELAY_QUEUEA_ROUTING_KEY, msg);
                break;
            case DELAY_60s:
                rabbitTemplate.convertAndSend(DELAY_EXCHANGE_NAME, DELAY_QUEUEB_ROUTING_KEY, msg);
                break;
        }
    }
}
