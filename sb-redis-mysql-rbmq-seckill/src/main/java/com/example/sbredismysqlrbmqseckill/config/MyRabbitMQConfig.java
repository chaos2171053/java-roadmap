package com.example.sbredismysqlrbmqseckill.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 使用 RabbitMQ 创建订单、扣减库存
 */
@Configuration
public class MyRabbitMQConfig {

    //库存交换机
    public static final String STOCK_EXCHANGE = "STOCK_EXCHANGE";

    //订单交换机
    public static final String ORDER_EXCHANGE = "ORDER_EXCHANGE";

    //库存队列
    public static final String STOCK_QUEUE = "STOCK_QUEUE";

    //订单队列
    public static final String ORDER_QUEUE = "ORDER_QUEUE";

    //库存路由键
    public static final String STOCK_ROUTING_KEY = "STOCK_ROUTING_KEY";

    //订单路由键
    public static final String ORDER_ROUTING_KEY = "ORDER_ROUTING_KEY";

    // 用于将消息以JSON格式进行序列化和反序列化。
    // 可以将消息对象转换为JSON格式的消息。
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    //创建库存交换机
    @Bean
    public Exchange getStockExchange() {
        return ExchangeBuilder.directExchange(STOCK_EXCHANGE).durable(true).build();
    }

    //创建库存队列
    @Bean
    public Queue getStockQueue() {
        return new Queue(STOCK_QUEUE);
    }

    //库存交换机和库存队列绑定
    @Bean
    public Binding bindStock() {
        return BindingBuilder.bind(getStockQueue()).to(getStockExchange()).with(STOCK_ROUTING_KEY).noargs();
    }

    //创建订单队列
    @Bean
    public Queue getOrderQueue() {
        return new Queue(ORDER_QUEUE);
    }

    //创建订单交换机
    @Bean
    public Exchange getOrderExchange() {
        return ExchangeBuilder.directExchange(ORDER_EXCHANGE).durable(true).build();
    }

    //订单队列与订单交换机进行绑定
    @Bean
    public Binding bindOrder() {
        return BindingBuilder.bind(getOrderQueue()).to(getOrderExchange()).with(ORDER_ROUTING_KEY).noargs();
    }
}
