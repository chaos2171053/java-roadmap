package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.publish;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {
    public static void main(String[] args) {
        try {
            Channel channel = ConnectionUtil.getChannel();
            channel.queueDeclare(Producer.FANOUT_QUEUE_2, false, false, false, null);
            channel.exchangeDeclare(Producer.FANOUT_EXCHANGE, BuiltinExchangeType.FANOUT);
            //把队列和交换机绑定 队列名称，交换机名称，路由key
            channel.queueBind(Producer.FANOUT_QUEUE_2, Producer.FANOUT_EXCHANGE, "");
            //接受消息
            DefaultConsumer consumer = new DefaultConsumer(channel) {
                /**
                 * 消费回调函数，当收到消息以后，会自动执行这个方法
                 * @param consumerTag 消费者标识
                 * @param envelope    消息包的内容(比如交换机，路由key,消息id等)
                 * @param properties   属性信息
                 * @param body         消息数据
                 * @throws IOException
                 */
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("消息者2接受到的消息:" + new String(body, "UTF-8"));
                }
            };
            //监听消息(队列名称，是否自动确认消息，消费对象)
            channel.basicConsume(Producer.FANOUT_QUEUE_2, true, consumer);

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}

