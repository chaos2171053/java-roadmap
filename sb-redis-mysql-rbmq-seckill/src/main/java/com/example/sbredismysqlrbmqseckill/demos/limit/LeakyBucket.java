package com.example.sbredismysqlrbmqseckill.demos.limit;

import java.util.concurrent.TimeUnit;

public class LeakyBucket {
    private int capacity; // 桶的容量
    private int rate; // 漏桶的流出速率（请求处理速度）
    private int water; // 当前桶内水的数量（当前请求数）

    public LeakyBucket(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.water = 0;
    }

    public synchronized boolean allowRequest() {
        // 漏水，根据流出速率减少水的数量
        water = Math.max(0, water - rate);

        // 判断桶内水的数量是否超过了容量，如果超过了则拒绝请求
        if (water < capacity) {
            water++;
            return true; // 允许请求通过
        } else {
            return false; // 拒绝请求
        }
    }

    public static void main(String[] args) {
        LeakyBucket bucket = new LeakyBucket(10, 2); // 桶的容量为10，流出速率为2（每秒处理2个请求）

        // 模拟100次请求
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(200); // 每隔200毫秒发出一个请求
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (bucket.allowRequest()) {
                System.out.println("Allow request " + (i + 1) + " at " + System.currentTimeMillis());
            } else {
                System.out.println("Reject request " + (i + 1) + " at " + System.currentTimeMillis());
            }
        }
    }
}

