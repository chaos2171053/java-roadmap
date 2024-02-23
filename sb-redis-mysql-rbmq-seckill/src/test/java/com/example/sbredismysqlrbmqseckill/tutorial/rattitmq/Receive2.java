package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class Receive2 {
    private static final String QUEUENAME="routing_queue2";
    private static final String EXCHANGENAME="routing_exchange";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUENAME, false, false, false, null);
        //在队列绑定时设置路由键
        channel.queueBind(QUEUENAME, EXCHANGENAME, "error");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("receive:" + msg);
            }
        };
        //监听队列
        channel.basicConsume(QUEUENAME, true, consumer);
    }
}
