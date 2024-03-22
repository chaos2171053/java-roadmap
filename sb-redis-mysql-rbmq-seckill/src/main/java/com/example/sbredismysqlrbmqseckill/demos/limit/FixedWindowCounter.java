package com.example.sbredismysqlrbmqseckill.demos.limit;

import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowCounter {
    private final int windowSize; // 窗口大小（单位：毫秒）
    private final int limit; // 窗口内最大请求数
    private final AtomicInteger counter; // 计数器
    private long windowStart; // 窗口开始时间

    public FixedWindowCounter(int windowSize, int limit) {
        this.windowSize = windowSize;
        this.limit = limit;
        this.counter = new AtomicInteger(0);
        this.windowStart = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - windowStart >= windowSize) {
            // 窗口已经滑动，重置计数器和窗口开始时间
            counter.set(0);
            windowStart = currentTime;
        }
        return counter.incrementAndGet() <= limit;
    }

    public static void main(String[] args) {
        FixedWindowCounter counter = new FixedWindowCounter(1000, 5);

        // 模拟100次请求
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100); // 每隔100毫秒发出一个请求
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (counter.allowRequest()) {
                System.out.println("Allow request " + (i + 1));
            } else {
                System.out.println("Reject request " + (i + 1));
            }
        }
    }
}
