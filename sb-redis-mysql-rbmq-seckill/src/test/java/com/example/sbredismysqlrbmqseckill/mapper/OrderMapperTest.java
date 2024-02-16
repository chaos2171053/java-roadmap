package com.example.sbredismysqlrbmqseckill.mapper;

import com.example.sbredismysqlrbmqseckill.bean.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void testInsert(){
        Order order = new Order();
        order.setOrderName("Test Order");
        order.setOrderUser(1);

        Integer result = orderMapper.insert(order);
        assert result == 1;
    }
}
