package com.example.sbredismysqlrbmqseckill.service.impl;

import com.example.sbredismysqlrbmqseckill.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockServiceImplTest {
    @Autowired
    StockService stockService;

    @Test
    void decrByStock() {
        stockService.decrByStock("Q弹豆干");
    }

    @Test
    void selectByName() {
       Integer result =  stockService.selectByName("Q弹豆干");
       System.out.println("result :"+result);
       assert result !=-1;
    }
}