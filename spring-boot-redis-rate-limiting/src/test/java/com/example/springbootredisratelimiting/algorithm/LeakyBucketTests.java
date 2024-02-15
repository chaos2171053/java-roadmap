package com.example.springbootredisratelimiting.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeakyBucketTests {
    @Test
    public void testLeakyBucket(){
        LeakyBucket bucket = new LeakyBucket(5,1000);
        assertTrue(bucket.allowRequest());
        assertTrue(bucket.allowRequest());
        assertTrue(bucket.allowRequest());
        assertTrue(bucket.allowRequest());
        assertTrue(bucket.allowRequest());
        assertFalse(bucket.allowRequest());
    }
}
