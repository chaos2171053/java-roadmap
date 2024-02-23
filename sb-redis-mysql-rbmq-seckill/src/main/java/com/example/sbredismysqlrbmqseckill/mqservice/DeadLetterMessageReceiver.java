package com.example.sbredismysqlrbmqseckill.mqservice;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.example.sbredismysqlrbmqseckill.config.RabbitMQConfig.DEAD_LETTER_QUEUE_A_NAME;
import static com.example.sbredismysqlrbmqseckill.config.RabbitMQConfig.DEAD_LETTER_QUEUE_B_NAME;

@Component
public class DeadLetterMessageReceiver {


    @RabbitListener(queues = DEAD_LETTER_QUEUE_A_NAME)
    public void receiveA(Message message, Channel channel) throws IOException {
        System.out.println("收到死信消息A：" + new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(queues = DEAD_LETTER_QUEUE_B_NAME)
    public void receiveB(Message message, Channel channel) throws IOException {
        System.out.println("收到死信消息B：" + new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
