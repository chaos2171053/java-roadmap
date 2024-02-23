package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.queue;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Consumer3 {
    private static final String QUEUE_NAME = "ack_work_mode";

    public static void main(String[] args) {
        try {
            Channel channel = ConnectionUtil.getChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            System.out.println("消费者1-消费消息的时间比较短。");

            DefaultConsumer defaultConsumer= new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    try {
                        TimeUnit.SECONDS.sleep(1); // 休眠 1 秒
                        System.out.println("消息者1接受到的消息:" + new String(body, "UTF-8"));
                        //手动确认
                        //每条消息都有对应的id，表明是第几条消息,false表示不批量
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };

            //监听消息(队列名称，是否自动确认消息，消费对象)

            channel.basicConsume(QUEUE_NAME, false, defaultConsumer);

        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
