package com.example.springbootredisratelimiting.controller;

import com.example.springbootredisratelimiting.algorithm.LeakyBucket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class LeakyBucketController {
    private final int capacity = 10; // 漏桶容量
    private final int leakRate = 1000; // 漏水速率，每秒处理10个请求
    private final LeakyBucket bucket = new LeakyBucket(capacity, leakRate);
    private final AtomicInteger counter = new AtomicInteger(0);

    @GetMapping("/api/endpoint")
    public String handleRequest() {
        if (bucket.allowRequest()) {
            // 处理请求逻辑
            int requestNumber = counter.incrementAndGet();
            return "Request number: " + requestNumber;
        } else {
            return "Too many requests. Please try again later.";
        }
    }
}
