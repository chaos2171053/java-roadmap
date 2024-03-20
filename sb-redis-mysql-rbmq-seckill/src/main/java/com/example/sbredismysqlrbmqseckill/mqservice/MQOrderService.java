package com.example.sbredismysqlrbmqseckill.mqservice;

import com.example.sbredismysqlrbmqseckill.bean.Order;
import com.example.sbredismysqlrbmqseckill.config.MyRabbitMQConfig;
import com.example.sbredismysqlrbmqseckill.service.MessageSendService;
import com.example.sbredismysqlrbmqseckill.service.OrderService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

import static com.example.sbredismysqlrbmqseckill.config.OrderMQConfig.DEAD_LETTER_QUEUE_NAME;
import static com.example.sbredismysqlrbmqseckill.config.OrderMQConfig.DELAYED_QUEUE_NAME;

@Service
@Slf4j
public class MQOrderService {

    @Autowired
    private OrderService orderService;
    @Autowired
    private MessageSendService messageSendService;
    @RabbitListener(queues = MyRabbitMQConfig.ORDER_QUEUE)
    public void createOrder(Order order){
        log.info("收到订单消息，订单用户为：{}，商品名称为：{}", order.getOrderUser(), order.getOrderName());
        /**
         * 调用数据库orderService创建订单信息
         */
        orderService.createOrder(order);
    }
    @RabbitListener(queues = DELAYED_QUEUE_NAME)
    public void receiveOrderDelay(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        log.info("当前时间：{}, receiveOrderDelay 订单延时队列收到消息：{}", new Date().toString(), msg);

        // 拒绝消息并将其重新放回队列，触发死信机制
        channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);

        // 手动应答
        // channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(queues = DEAD_LETTER_QUEUE_NAME)
    public void receiveOrderDead(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        log.info("当前时间：{},receiveOrderDead 订单死信列收到消息：{}", new Date().toString(), msg);
        //channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        //
        //channel.basicNack(message.getMessageProperties().getDeliveryTag(),, false, false)
    }

}
