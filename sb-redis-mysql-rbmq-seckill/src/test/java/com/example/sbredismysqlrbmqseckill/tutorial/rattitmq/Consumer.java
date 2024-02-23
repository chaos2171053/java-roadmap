package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    private static final String QUEUE_NAME = "hello_queue";

    public static void main(String[] args) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);


            DefaultConsumer consumer =  new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("消息内容 body:"+new String(body,"UTF-8"));
                }
            };

            //监听消息(队列名称，是否自动确认消息，消费对象)

            channel.basicConsume(QUEUE_NAME,true,consumer);

        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }

    }
}
