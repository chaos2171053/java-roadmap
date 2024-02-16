package com.example.sbredismysqlrbmqseckill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    public void put(String key, long value, long timeout) {
        redisTemplate.opsForValue().set(key, String.valueOf(value), timeout, TimeUnit.MINUTES);
    }

    public void putForHash(String key,Object hashKey,Object value){
        redisTemplate.opsForHash().put(key,hashKey,value);
    }
    
    public Long decrBy(String key){
        return redisTemplate.opsForValue().decrement(key);
    }
}
