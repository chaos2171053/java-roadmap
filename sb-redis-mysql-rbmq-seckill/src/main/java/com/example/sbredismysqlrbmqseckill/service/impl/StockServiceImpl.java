package com.example.sbredismysqlrbmqseckill.service.impl;

import com.example.sbredismysqlrbmqseckill.bean.Stock;
import com.example.sbredismysqlrbmqseckill.mapper.StockMapper;
import com.example.sbredismysqlrbmqseckill.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;
    @Override
    public synchronized void decrByStock(String stockName) {
        List<Stock> stockList = stockMapper.selectList(stockName);
        if(!stockList.isEmpty()){
            Stock stock = stockList.get(0);
            if(stock.getStock()==0){
                throw  new RuntimeException("Insufficient stock");
            }
            stock.setStock(stock.getStock()-1);
            stockMapper.updateByPrimaryKey(stock);
        }

    }

    @Override
    public Integer selectByName(String stockName) {
        List<Stock> stockList = stockMapper.selectList(stockName);
        if(!stockList.isEmpty()){
            return stockList.get(0).getStock();
        }
        return -1;
    }
}
