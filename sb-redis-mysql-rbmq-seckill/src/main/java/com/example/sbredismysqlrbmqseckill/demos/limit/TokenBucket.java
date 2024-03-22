package com.example.sbredismysqlrbmqseckill.demos.limit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucket {
    private final int capacity; // 令牌桶容量
    private final int rate; // 令牌产生速率，单位：令牌/秒
    private final BlockingQueue<Object> tokens; // 令牌队列
    private final AtomicInteger count; // 当前令牌数量

    public TokenBucket(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.tokens = new LinkedBlockingQueue<>(capacity);
        this.count = new AtomicInteger(0);
        // 开始生成令牌
        ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(this::generateToken, 0, 1000 / rate, TimeUnit.MILLISECONDS);
    }

    private void generateToken() {
        int newCount = Math.min(capacity, count.incrementAndGet());
        for (int i = 0; i < newCount; i++) {
            tokens.offer(new Object()); // 生成令牌
        }
        count.addAndGet(-newCount); // 更新当前令牌数量
    }

    public boolean allowRequest() {
        return tokens.poll() != null; // 从令牌桶中取出一个令牌，如果令牌桶为空则拒绝请求
    }

    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket(10, 2); // 令牌桶容量为10，令牌产生速率为2个/秒

        // 模拟100次请求
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(200); // 每隔200毫秒发出一个请求
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tokenBucket.allowRequest()) {
                System.out.println("Allow request " + (i + 1) + " at " + System.currentTimeMillis());
            } else {
                System.out.println("Reject request " + (i + 1) + " at " + System.currentTimeMillis());
            }
        }
    }
}

