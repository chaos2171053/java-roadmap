package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.publish;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer1 {
    public static void main(String[] args) {
        try {
            Channel channel = ConnectionUtil.getChannel();
            // declare queue
            channel.queueDeclare(Producer.FANOUT_EXCHANGE,false,false,false,null);
            // declare exchange
            channel.exchangeDeclare(Producer.FANOUT_EXCHANGE, BuiltinExchangeType.FANOUT);
            // The exchange is bound to the queue.
            channel.queueBind(Producer.FANOUT_QUEUE_1, Producer.FANOUT_EXCHANGE, "");

            DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("消息者1接受到的消息:" + new String(body, "UTF-8"));
                }
            };
            //监听消息(队列名称，是否自动确认消息，消费对象)
            channel.basicConsume(Producer.FANOUT_QUEUE_1, true, defaultConsumer);

        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
