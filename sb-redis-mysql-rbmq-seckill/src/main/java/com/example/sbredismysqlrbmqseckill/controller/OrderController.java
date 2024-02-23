package com.example.sbredismysqlrbmqseckill.controller;

import com.example.sbredismysqlrbmqseckill.bean.Order;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujiangbo
 * @desc 订单API接口
 * @date 2022-04-02 09:40
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/addOrder/{userId}")
    public String addOrder(@PathVariable("userId") String userId) {
        System.out.println("开始下单啦.........");

        /***********************************************************************************
         * 1、开始封装订单消息（模拟数据）
         ***********************************************************************************/
        Order dto = new Order();

        dto.setOrderName(userId);//用户ID

        /***********************************************************************************
         * 2、发送带有过期时间的订单消息到RabbitMQ
         ***********************************************************************************/
        rabbitTemplate.convertAndSend(
                "normalExchange", //普通交换机名称
                "normalRoutingKey", //正常路由键
                dto,
                new MessagePostProcessor() { //定义消息属性处理类
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        MessageProperties messageProperties = message.getMessageProperties();
                        /**
                         * 设置过期时间TTL（单位：毫秒）
                         * 模拟：订单5秒内还未被消费，那么就进入死信队列
                         */
                        messageProperties.setExpiration("5000");
                        //设置持久化
                        messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                        return message;
                    }
                });
        return "下单成功";
    }
}
