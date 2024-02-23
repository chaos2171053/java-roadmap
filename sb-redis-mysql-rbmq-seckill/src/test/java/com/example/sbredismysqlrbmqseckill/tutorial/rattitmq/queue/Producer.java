package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.queue;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) {
        try {
            Channel channel = ConnectionUtil.getChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            for (int i = 0; i < 10; i++) {
                String msg = "hello ok~ message: " + i;
                channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            }
            System.out.println(QUEUE_NAME + " 消息已经发送完毕");
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
