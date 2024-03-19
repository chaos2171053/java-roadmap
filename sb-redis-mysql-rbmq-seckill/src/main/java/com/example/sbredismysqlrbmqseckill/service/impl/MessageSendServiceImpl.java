package com.example.sbredismysqlrbmqseckill.service.impl;



import com.example.sbredismysqlrbmqseckill.mapper.MessageSendMapper;
import com.example.sbredismysqlrbmqseckill.bean.MessageSend;
import com.example.sbredismysqlrbmqseckill.service.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageSendServiceImpl implements MessageSendService {

    private final MessageSendMapper messageSendMapper;

    @Autowired
    public MessageSendServiceImpl(MessageSendMapper messageSendMapper) {
        this.messageSendMapper = messageSendMapper;
    }

    @Override
    public void insertMessageSend(MessageSend messageSend) {
        messageSendMapper.insertMessageSend(messageSend);
    }



    @Override
    public void updateMessageSendStatus(MessageSend messageSend) {
        messageSendMapper.updateMessageSendStatus(messageSend);
    }

    @Override
    public List<MessageSend> getAllMessageSends() {
        return messageSendMapper.getAllMessageSends();
    }
}
