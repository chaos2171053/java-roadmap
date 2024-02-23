package com.example.sbredismysqlrbmqseckill.mqservice;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OrderConsumer {
    /**
     * 监听订单队列
     */
    @RabbitListener(queues = {"normalQueue"})
    public void handleOrderQueue(Message message, Channel channel) throws IOException {
        System.out.println("订单消费者类，拿到消息：" + new String(message.getBody()));

        try {
            //开始处理消息
            try {
                //模拟处理消息花费时间
                Thread.sleep(3000);
                //int i = 1/0;//模拟：处理消息时发生了某种异常
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("消息处理完毕");
            //消息处理完毕，一定要记得手动ACK
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e){
            //发生异常，进行NACK
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }

    /**
     * 监听死信队列
     */
    @RabbitListener(queues = {"deadQueue"})
    public void handleDeadQueue(Message message, Channel channel) throws IOException {
        System.out.println("拿到死信消息：" + new String(message.getBody()));

        /**
         * 这里取到消息后，根据实际业务规则，进行处理即可
         */
        try {
            //模拟处理消息花费时间
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //最后手动ACK
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
