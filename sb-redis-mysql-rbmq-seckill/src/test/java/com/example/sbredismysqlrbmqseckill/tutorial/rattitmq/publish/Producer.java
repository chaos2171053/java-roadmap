package com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.publish;

import com.example.sbredismysqlrbmqseckill.tutorial.rattitmq.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static final String FANOUT_EXCHANGE = "fanout_exchange";
    public static final String FANOUT_QUEUE_1 = "fanout_queue_1";
    public static final String FANOUT_QUEUE_2 = "fanout_queue_2";

    public static void main(String[] args) {
        try {
            Channel channel = ConnectionUtil.getChannel();
            // declare exchange
            channel.exchangeDeclare(FANOUT_EXCHANGE, BuiltinExchangeType.FANOUT);
            // declare queue
            channel.queueDeclare(FANOUT_QUEUE_1,false,false,false,null);
            channel.queueDeclare(FANOUT_QUEUE_2,false,false,false,null);
            // The exchange is bound to the queue.
            channel.queueBind(FANOUT_QUEUE_1,FANOUT_EXCHANGE,"");
            channel.queueBind(FANOUT_QUEUE_2,FANOUT_EXCHANGE,"");

            for (int i = 1; i <=10 ; i++) {
                String msg="hello，ok，publish scribe : "+i;
                channel.basicPublish(FANOUT_EXCHANGE, "", null, msg.getBytes());
            }
            System.out.println("发送完毕");
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
