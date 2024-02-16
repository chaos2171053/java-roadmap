package com.example.sbredismysqlrbmqseckill.mapper;

import com.example.sbredismysqlrbmqseckill.bean.Stock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StockMapperTest {
    @Autowired
    private StockMapper stockMapper;

    @Test
    void selectList() {
        Stock stock = new Stock();
        stock.setStock(10);
        stock.setName("Q弹豆干");
        List<Stock> list = stockMapper.selectList("Q弹豆干");
        assert !list.isEmpty();
    }

    @Test
    void updateByPrimaryKey() {
        Stock stock = new Stock();
        stock.setId(2);
        stock.setName("修改Q弹豆干");
        stock.setStock(11);
        Integer result = stockMapper.updateByPrimaryKey(stock);
        assert result == 1;
    }

    @Test
    void insert() {
        Stock stock = new Stock();
        stock.setStock(10);
        stock.setName("Q弹豆干");
        Integer result = stockMapper.insert(stock);
        assert result == 1;
    }
}