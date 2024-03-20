package com.example.sbredismysqlrbmqseckill.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class OrderMQConfig {
    public static final String DELAYED_QUEUE_NAME = "sbredismysqlrbmqseckill.delay.queue";
    public static final String DELAYED_EXCHANGE_NAME = "sbredismysqlrbmqseckill.delay.exchange";
    public static final String DELAYED_ROUTING_KEY = "sbredismysqlrbmqseckill.delay.routingkey";

    public static final String DEAD_LETTER_QUEUE_NAME = "sbredismysqlrbmqseckill.deadletter.queue";
    public static final String DEAD_LETTER_EXCHANGE_NAME = "sbredismysqlrbmqseckill.deadletter.exchange";
    public static final String DEAD_LETTER_ROUTING_KEY = "sbredismysqlrbmqseckill.deadletter.routingkey";

    @Bean
    public Queue orderMQDelayQueue() {
        //return new Queue(DELAYED_QUEUE_NAME);
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE_NAME);
        args.put("x-dead-letter-routing-key", DEAD_LETTER_ROUTING_KEY);
        return QueueBuilder.durable(DELAYED_QUEUE_NAME).withArguments(args).build();
    }

    @Bean
    public CustomExchange orderMQExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }

    @Bean
    public Binding bindingOrderMQDelayQueueMQExchange(@Qualifier("orderMQDelayQueue") Queue orderMQDelayQueue,
                                                      @Qualifier("orderMQExchange") CustomExchange orderMQExchange) {
        return BindingBuilder.bind(orderMQDelayQueue).to(orderMQExchange).with(DELAYED_ROUTING_KEY).noargs();
    }

    @Bean
    public Queue orderMQDeadLetterQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", ""); // 死信队列不再需要这两个参数
        args.put("x-dead-letter-routing-key", "");
        return QueueBuilder.durable(DEAD_LETTER_QUEUE_NAME).withArguments(args).build();
    }


    @Bean
    public CustomExchange orderMQDeadLetterExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct"); // 使用相同的延迟类型
        return new CustomExchange(DEAD_LETTER_EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }

    @Bean
    public Binding bindingDeadLetterQueueDeadLetterExchange(@Qualifier("orderMQDeadLetterQueue") Queue deadLetterQueue,
                                                            @Qualifier("orderMQDeadLetterExchange") CustomExchange deadLetterExchange) {
        return BindingBuilder.bind(deadLetterQueue).to(deadLetterExchange).with(DEAD_LETTER_ROUTING_KEY).noargs();
    }
}

