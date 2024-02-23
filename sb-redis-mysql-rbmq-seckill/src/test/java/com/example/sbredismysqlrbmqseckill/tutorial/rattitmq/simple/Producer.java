package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.simple;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static final String QUEUE_NAME = "hello_queue";

    public static void main(String[] args) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            Channel channel = connection.createChannel();
            // 队列名称，是否持久化，是否独占连接，是否在不适用队列的时候自动删除，队列其他参数)
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String msg = "hello ok~";
            /**
             * 参数1:交换机名称，不填写交换机名称的话则使用默认的交换机
             * 参数2:队列名称(路由key)
             * 参数3:其他参数
             * 参数4:消息内容
             */
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            System.out.println("已经发送消息到队列 :" + QUEUE_NAME);
            // 关闭资源
            channel.close();
            connection.close();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
