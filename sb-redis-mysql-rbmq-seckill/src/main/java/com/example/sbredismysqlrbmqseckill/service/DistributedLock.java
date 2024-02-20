package com.example.sbredismysqlrbmqseckill.service;

public interface DistributedLock {
    boolean acquireLock(String lockKey, String clientId, long expireTime);
    boolean releaseLock(String lockKey, String clientId);

    boolean releaseLockByLua(String lockKey, String clientId);
}
