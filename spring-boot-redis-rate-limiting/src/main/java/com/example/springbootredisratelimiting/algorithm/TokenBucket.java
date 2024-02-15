package com.example.springbootredisratelimiting.algorithm;

import java.time.Instant;

public class TokenBucket {
    private final int capacity;
    private final int refillRate; // 令牌补充速率，单位：毫秒
    private int tokens;
    private long lastRefillTime;

    public TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = Instant.now().toEpochMilli();
    }

    public synchronized boolean allowRequest() {
        refillTokens();
        if (tokens > 0) {
            tokens--;
            return true;
        } else {
            return false;
        }
    }

    private synchronized void refillTokens() {
        long currentTime = Instant.now().toEpochMilli();
        long elapsedTime = currentTime - lastRefillTime;
        int tokensToAdd = (int) (elapsedTime / refillRate);
        tokens = Math.min(capacity, tokens + tokensToAdd);
        lastRefillTime = currentTime;
    }
}

