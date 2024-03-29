package com.example.sbredismysqlrbmqseckill.mapper;

import com.example.sbredismysqlrbmqseckill.bean.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StockMapper {
    List<Stock> selectList(@Param("name") String name);

    Integer updateByPrimaryKey(Stock stock);

    Integer insert(Stock stock);

    int decrByStockWithVersion(Stock stock);

    int decrByStockWithPessimisticLock(Stock stock);

    List<Stock> selectByNameWithPessimisticLock(String stockName);

    List<Stock> queryStock(String stockName);
}
