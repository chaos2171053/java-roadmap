package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.queue;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer2 {
    private static final String QUEUE_NAME = "ack_work_mode";

    public static void main(String[] args) {
        try {
            Channel channel = ConnectionUtil.getChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            for (int i = 0; i < 10; i++) {
                String msg = "hello ok~ "+i;
                channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            }
            System.out.println("消息发送完毕");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
