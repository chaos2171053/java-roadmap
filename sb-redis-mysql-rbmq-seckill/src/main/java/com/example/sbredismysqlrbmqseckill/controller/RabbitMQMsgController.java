package com.example.sbredismysqlrbmqseckill.controller;

import com.example.sbredismysqlrbmqseckill.constants.DelayTypeEnum;
import com.example.sbredismysqlrbmqseckill.mqservice.BusinessMessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;


@RequestMapping("rabbitmq")
@RestController
@Slf4j
public class RabbitMQMsgController {

    @Autowired
    private BusinessMessageSender sender;

    @RequestMapping("sendmsg")
    public void sendMsg(String msg){
        sender.sendMsg(msg);
    }
    @RequestMapping("sendmsg1")
    public void sendMsg(String msg, Integer delayType){
        log.info("当前时间：{},sendmsg1 接口收到请求，msg:{},delayType:{}", new Date(), msg, delayType);
        sender.sendMsg(msg, Objects.requireNonNull(DelayTypeEnum.getDelayTypeEnumByValue(delayType)));
    }
    @RequestMapping("delayMsg")
    public void delayMsg(String msg, Integer delayTime) {
        log.info("当前时间：{},delayMsg收到请求，msg:{},delayTime:{}", new Date(), msg, delayTime);
        sender.sendMsg(msg, delayTime);
    }

    @RequestMapping("delayMsg2")
    public void delayMsg2(String msg, Integer delayTime) {
        log.info("当前时间：{},收到请求，msg:{},delayTime:{}", new Date(), msg, delayTime);
        sender.sendDelayMsg(msg, delayTime);
    }


}
