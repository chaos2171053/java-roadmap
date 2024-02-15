package com.example.springbootredisratelimiting.algorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TokenBucketTest {
    @Test
    public void testTokenBucket() {
        TokenBucket bucket = new TokenBucket(5, 1000); // 容量为5，补充速率为1秒/个
        assertTrue(bucket.allowRequest());
        assertTrue(bucket.allowRequest());
        assertTrue(bucket.allowRequest());
        assertTrue(bucket.allowRequest());
        assertTrue(bucket.allowRequest());
        assertFalse(bucket.allowRequest()); // 桶中没有足够的令牌，无法再放入请求
    }
}
