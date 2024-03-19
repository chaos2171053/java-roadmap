package com.example.sbredismysqlrbmqseckill.service;

import com.example.sbredismysqlrbmqseckill.bean.MessageSend;

import java.util.List;

public interface MessageSendService {
    void insertMessageSend(MessageSend messageSend);
    void updateMessageSendStatus(MessageSend messageSend);


    List<MessageSend> getAllMessageSends();
}
