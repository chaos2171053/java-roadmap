package com.example.sbredismysqlrbmqseckill.demos.limit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowCounterDemo {
    private final int windowSize; // 窗口大小（单位：毫秒）
    private final int limit; // 窗口内最大请求数
    private final AtomicInteger[] counter; // 计数器数组
    private final long[] windowStart; // 窗口开始时间数组

    public SlidingWindowCounterDemo(int windowSize, int limit, int granularity) {
        this.windowSize = windowSize;
        this.limit = limit;
        this.counter = new AtomicInteger[granularity];
        this.windowStart = new long[granularity];
        for (int i = 0; i < granularity; i++) {
            this.counter[i] = new AtomicInteger(0);
            this.windowStart[i] = System.currentTimeMillis();
        }
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        int index = (int) ((currentTime / windowSize) % counter.length); // 计算当前窗口的索引
        synchronized (counter[index]) {
            if (currentTime - windowStart[index] >= windowSize) {
                // 窗口已经滑动，重置计数器和窗口开始时间
                counter[index].set(0);
                windowStart[index] = currentTime;
            }
            return counter[index].incrementAndGet() <= limit;
        }
    }

    public static void main(String[] args) {
        SlidingWindowCounterDemo counter = new SlidingWindowCounterDemo(10000, 5, 10); // 窗口大小为10秒，最大请求数为5，粒度为10

        // 模拟100次请求
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000); // 每隔1秒发出一个请求
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (counter.allowRequest()) {
                System.out.println("Allow request " + (i + 1) + " at " + System.currentTimeMillis());
            } else {
                System.out.println("Reject request " + (i + 1) + " at " + System.currentTimeMillis());
            }
        }
    }
}

