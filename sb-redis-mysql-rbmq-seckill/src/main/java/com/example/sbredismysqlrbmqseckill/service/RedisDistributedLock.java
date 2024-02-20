package com.example.sbredismysqlrbmqseckill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Service
public class RedisDistributedLock implements  DistributedLock{
    private static final String LOCK_PREFIX="distributed_lock:";
    private static final long DEFAULT_EXPIRE_TIME = 15; // 默认锁过期时间（秒）

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public boolean acquireLock(String lockKey, String clientId, long expireTime) {
        String lockName = LOCK_PREFIX+lockKey;
        Boolean result = redisTemplate.opsForValue().setIfAbsent(lockName,clientId,expireTime, TimeUnit.SECONDS);
        return result!=null && result;
    }

    @Override
    public boolean releaseLock(String lockKey, String clientId) {
        String lockName = LOCK_PREFIX + lockKey;
        Object value = redisTemplate.opsForValue().get(lockName);
        // 加上 client 区分是否自己的锁， 防止线程卡顿，锁到期自动释放后，误删其他线程的锁
        // 注意获取锁和删除锁的操作，不是原子性。
        if(value!=null && value.equals(clientId)){
            return Boolean.TRUE.equals(redisTemplate.delete(lockName));
        }
        return false;
    }

    @Override
    public boolean releaseLockByLua(String lockKey, String clientId) {
        // 加载Lua脚本
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setLocation(new ClassPathResource("scripts/release_lock.lua"));
        redisScript.setResultType(Long.class);

        // 执行Lua脚本
        Long result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), clientId);

        // 根据Lua脚本返回值判断是否成功释放锁
        return result != null && result > 0;
    }
}
