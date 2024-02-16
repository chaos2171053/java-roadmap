package com.example.sbredismysqlrbmqseckill.service;

public interface StockService {
    public void decrByStock(String stockName);
    public Integer selectByName(String stockName);
}
