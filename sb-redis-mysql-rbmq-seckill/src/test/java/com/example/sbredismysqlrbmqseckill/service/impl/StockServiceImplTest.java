package com.example.sbredismysqlrbmqseckill.service.impl;

import com.example.sbredismysqlrbmqseckill.bean.Stock;
import com.example.sbredismysqlrbmqseckill.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        Integer result = stockService.selectByName("Q弹豆干");
        System.out.println("result :" + result);
        assert result != -1;
    }

    @Test
    void decrByStockWithVersion() {
        Stock stock = new Stock();
        stock.setStock(10);
        stock.setId(2);
        stock.setName("Q弹豆干");
        stock.setVersion(0);
        int result = stockService.decrByStockWithVersion(stock);
        assert result != -1;
    }
}