package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String EXCHANGENAME="routing_exchange";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //交换机类型选择direct
        channel.exchangeDeclare(EXCHANGENAME,"direct");
        String msg="hello world";
        //设置路由键（routingkey）
        String routingkey="error";
        channel.basicPublish(EXCHANGENAME,routingkey,null,msg.getBytes());
        channel.close();
        connection.close();
    }
}
