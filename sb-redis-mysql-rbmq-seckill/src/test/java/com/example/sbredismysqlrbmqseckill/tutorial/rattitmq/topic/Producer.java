package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.topic;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static String TOPIC_EXCHANGE = "topic_exchange";
    public static String TOPIC_QUEUE_1 = "topic_queue_1";
    public static String TOPIC_QUEUE_2 = "topic_queue_2";

    public static void main(String[] args) {
        try {
            Channel channel = ConnectionUtil.getChannel();
            //声明交换机(交换机名称，交换机类型)
            channel.exchangeDeclare(TOPIC_EXCHANGE, BuiltinExchangeType.TOPIC);
            //声明队列
            channel.queueDeclare(TOPIC_QUEUE_1,true,false,false,null);
            channel.queueDeclare(TOPIC_QUEUE_2,true,false,false,null);
            //把交换机和队列1进行绑定
            channel.queueBind(TOPIC_QUEUE_1,TOPIC_EXCHANGE,"#.error");
            //把交换机和队列2进行绑定
            channel.queueBind(TOPIC_QUEUE_2,TOPIC_EXCHANGE,"order.*");
            channel.queueBind(TOPIC_QUEUE_2,TOPIC_EXCHANGE,"*.orange.*");
            channel.queueBind(TOPIC_QUEUE_2,TOPIC_EXCHANGE,"*.*");
            //发送消息
            String msg="日志信息:调用了xxx方法，日志级别是error";
            channel.basicPublish(TOPIC_EXCHANGE,"error",null,msg.getBytes());
            System.out.println("消息发送成功");
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }


    }


}



