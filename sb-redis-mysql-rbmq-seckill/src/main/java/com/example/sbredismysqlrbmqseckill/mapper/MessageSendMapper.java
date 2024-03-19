package com.example.sbredismysqlrbmqseckill.mapper;

import com.example.sbredismysqlrbmqseckill.bean.MessageSend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageSendMapper {
    void insertMessageSend(MessageSend messageSend);
    void updateMessageSendStatus(MessageSend messageSend);
    List<MessageSend> getAllMessageSends();
}
