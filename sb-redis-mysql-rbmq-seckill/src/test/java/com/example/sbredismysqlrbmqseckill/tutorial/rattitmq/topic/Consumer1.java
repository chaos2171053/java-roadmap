package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.topic;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer1 {
    public static void main(String[] args) {

        try {
            //获取信道对象
            Channel channel = ConnectionUtil.getChannel();
            //消费消息
            DefaultConsumer consumer=new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("消费者1接收到消息:"+new String(body,"UTF-8"));
                    System.out.println("消费者1把日志信息保存到数据库");
                }
            };
            channel.basicConsume(Producer.TOPIC_QUEUE_1,true,consumer);



        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}


