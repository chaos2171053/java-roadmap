package com.example.sbredismysqlrbmqseckill.tasks;

import com.example.sbredismysqlrbmqseckill.bean.MessageSend;
import com.example.sbredismysqlrbmqseckill.config.MyRabbitMQConfig;
import com.example.sbredismysqlrbmqseckill.service.MessageSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

// 定时任务，用于重试发送消息
@Component
@Slf4j
public class MessageRetryTask {

    @Autowired
    private MessageSendService messageSendService;

    @Autowired

    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 5000) // 每隔5秒执行一次
    public void retrySendingMessages() {
        List<MessageSend> messagesToSend = messageSendService.getAllMessageSends(); // 查询状态为待处理的消息
        for (MessageSend message : messagesToSend) {
            try {
                //log.info("定时任务查询消息表 {}",message.toString());
                if(Objects.equals(message.getStatus(), "待处理")){
                    rabbitTemplate.convertAndSend(MyRabbitMQConfig.STOCK_EXCHANGE, MyRabbitMQConfig.STOCK_ROUTING_KEY, message);
                    messageSendService.updateMessageSendStatus(message); // 更新消息状态为已处理
                }
            } catch (Exception e) {
                // 记录发送失败的消息
                log.error("Failed to resend message: " + message.getId(), e);
            }
        }
    }
}
