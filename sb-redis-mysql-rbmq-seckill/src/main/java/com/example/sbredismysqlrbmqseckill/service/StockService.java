package com.example.sbredismysqlrbmqseckill.service;

import com.example.sbredismysqlrbmqseckill.bean.Stock;

public interface StockService {
    public void decrByStock(String stockName);
    public Integer selectByName(String stockName);

    public Stock queryStockByName(String stockName);

    /**
     * 乐观锁 将库存数量减一并更新版本号
     * @param stock
     * @return
     */
    int decrByStockWithVersion(Stock stock);

    /**
     * 悲观锁 将库存数量减一并更新版本号
     * @param stock
     * @return
     */
    int decrByStockWithPessimisticLock(Stock stock);

    /**
     * 悲观锁 查询库存
     * @param stockName
     * @return
     */
    Stock selectByNameWithPessimisticLock(String stockName);

    Stock queryStock(String stockName);
}
