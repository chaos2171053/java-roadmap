package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.queue;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {
    static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) {

        try {
            Channel channel = ConnectionUtil.getChannel();
            //声明队列(队列名称，是否持久化，是否独占连接，是否在不适用队列的时候自动删除，队列其他参数)
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
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

            channel.basicConsume(QUEUE_NAME, true, consumer);


        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }


    }
}

