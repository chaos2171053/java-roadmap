package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtil {
    public static Connection getConnection() throws IOException, TimeoutException {
        //定义一个连接工厂
        ConnectionFactory factory=new ConnectionFactory();
        //设置服务地址
        factory.setHost("127.0.0.1");
        //设置AMQP端口
        factory.setPort(5672);
        //设置VHOSTS
        factory.setVirtualHost("test_virtual_host");
        //设置用户名
        factory.setUsername("chaos");
        factory.setPassword("chaos");
        return factory.newConnection();
    }
    /**
     * 创建信道对象
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    public static Channel getChannel() throws IOException, TimeoutException {
        Connection connection = getConnection();
        Channel channel = connection.createChannel();
        return channel;

    }
}
