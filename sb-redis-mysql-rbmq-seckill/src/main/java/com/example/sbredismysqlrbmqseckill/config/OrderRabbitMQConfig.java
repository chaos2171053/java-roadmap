package com.example.sbredismysqlrbmqseckill.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * RabbitMQ 的配置类
 * 作用：声明交换机、队列以及绑定关系
 */
@Configuration
public class OrderRabbitMQConfig {
    //创建普通队列
    @Bean
    public Queue normalQueue() {
        Map<String, Object> arguments = new HashMap<>(2);
        /**
         * 设置死信相关参数
         * x-dead-letter-exchange和x-dead-letter-exchange是固定写法
         */
        // 绑定死信交换机
        arguments.put("x-dead-letter-exchange", "deadExchange");
        // 绑定死信的路由key
        arguments.put("x-dead-letter-routing-key", "deadRoutingKey");
        //设置队列长度
        arguments.put("x-max-length", 2);
        return new Queue("normalQueue", true, false,false, arguments);
    }

    //创建普通交换机
    @Bean
    public Exchange normalExchange(){
        return ExchangeBuilder.topicExchange("normalExchange").durable(true).build();
    }

    //绑定普通队列和普通交换机
    @Bean
    public Binding normalBind(){
        return BindingBuilder.bind(normalQueue()).to(normalExchange()).with("normalRoutingKey").noargs();
    }



    /***********************************************************************************
     * 声明：死信队列、死信交换机，以及绑定关系
     ***********************************************************************************/
    //创建死信队列（当普通队列中消息过期后，消息会转发到此队列）
    @Bean
    public Queue deadQueue(){
        return new Queue("deadQueue",true,false,false);
    }

    //创建死信交换机
    @Bean
    public Exchange deadExchange(){
        return ExchangeBuilder.topicExchange("deadExchange").durable(true).build();
    }

    //绑定死信队列和死信交换机
    @Bean
    public Binding deadBind(){
        return BindingBuilder.bind(deadQueue()).to(deadExchange()).with("deadRoutingKey").noargs();
    }

    //初始化RabbitAdmin对象
//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//        // 只有设置为 true，spring 才会加载 RabbitAdmin 这个类
//        rabbitAdmin.setAutoStartup(true);
//
//        //下面设置目的：项目启动时，就创建交换机和队列，不用等到生产者发消息时才创建
//        //创建交换机
//        rabbitAdmin.declareExchange(deadExchange());
//        rabbitAdmin.declareExchange(normalExchange());
//        //创建对列
//        rabbitAdmin.declareQueue(deadQueue());
//        rabbitAdmin.declareQueue(normalQueue());
//
//        return rabbitAdmin;
//    }
}
