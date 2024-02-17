package com.example.sbredismysqlrbmqseckill.service.impl;

import com.example.sbredismysqlrbmqseckill.bean.Stock;
import com.example.sbredismysqlrbmqseckill.mapper.StockMapper;
import com.example.sbredismysqlrbmqseckill.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    //    @Override
//    public synchronized void decrByStock(String stockName) {
//        List<Stock> stockList = stockMapper.selectList(stockName);
//        if(!stockList.isEmpty()){
//            Stock stock = stockList.get(0);
//            // 库存为0时，注释抛出代码或者直接返回，可以模拟超卖/订单数>库存
////            if(stock.getStock()==0){
////                //throw  new RuntimeException("Insufficient stock");
////                return;
////            }
//            stock.setStock(stock.getStock()-1);
//            stockMapper.updateByPrimaryKey(stock);
//        }
//
//    }
    public void decrByStock(String stockName) {
        synchronized (this) {
            List<Stock> stocks = stockMapper.selectList(stockName);
            if (!CollectionUtils.isEmpty(stocks)) {
                Stock stock = stocks.get(0);
                if(stock.getStock()==0){
                    throw  new RuntimeException("Insufficient stock");
                }
                stock.setStock(stock.getStock() - 1);
                stockMapper.updateByPrimaryKey(stock);
            }
        }
    }

    //    @Override
//    public synchronized Integer selectByName(String stockName) {
//        List<Stock> stockList = stockMapper.selectList(stockName);
//        if(!stockList.isEmpty()){
//            return stockList.get(0).getStock();
//        }
//        return -1;
//    }
    @Override
    public Integer selectByName(String stockName) {
        synchronized (this) {
            List<Stock> stocks = stockMapper.selectList(stockName);
            if (!CollectionUtils.isEmpty(stocks)) {
                return stocks.get(0).getStock();
            }
            return 0;
        }
    }
}
