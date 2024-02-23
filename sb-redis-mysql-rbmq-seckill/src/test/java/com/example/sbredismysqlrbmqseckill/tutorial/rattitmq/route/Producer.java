package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.route;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static String DIRECT_EXCHANGE = "direct_exchange";
    public static String DIRECT_QUEUE_1 = "direct_queue_1";
    public static String DIRECT_QUEUE_2 = "direct_queue_2";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = ConnectionUtil.getChannel();
        //声明交换机(交换机名称，交换机类型)
        channel.exchangeDeclare(DIRECT_EXCHANGE, BuiltinExchangeType.DIRECT);
        //声明队列
        channel.queueDeclare(DIRECT_QUEUE_1,true,false,false,null);
        channel.queueDeclare(DIRECT_QUEUE_2,true,false,false,null);
        //把交换机和队列1进行绑定
        channel.queueBind(DIRECT_QUEUE_1,DIRECT_EXCHANGE,"error");
        //把交换机和队列2进行绑定
        channel.queueBind(DIRECT_QUEUE_2,DIRECT_EXCHANGE,"info");
        channel.queueBind(DIRECT_QUEUE_2,DIRECT_EXCHANGE,"error");
        channel.queueBind(DIRECT_QUEUE_2,DIRECT_EXCHANGE,"warning");

        //发送消息
        String msg="日志信息:调用了xxx方法，日志级别是warning";
        channel.basicPublish(DIRECT_EXCHANGE,"warning",null,msg.getBytes());
        System.out.println("消息发送成功");
    }

}
