package com.example.sbredismysqlrbmqseckill.mapper;

import com.example.sbredismysqlrbmqseckill.bean.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Integer insert(Order order);
}
