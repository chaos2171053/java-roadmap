package com.example.sbredismysqlrbmqseckill.concurrent;

public class SynchronizedSharedResourceDemo {
    public static void main(String[] args) {
        SynchronizedSharedResource resource =  new SynchronizedSharedResource();
        Thread writeThread = new Thread(()->{
            resource.writeData(100);
            System.out.println("Thread " + Thread.currentThread().getId() + " Writing data...");
        });
        writeThread.start();
        // 创建多个读线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("Thread " + Thread.currentThread().getId() + " Reading data: " + resource.readData());
            }).start();
        }

    }
}
