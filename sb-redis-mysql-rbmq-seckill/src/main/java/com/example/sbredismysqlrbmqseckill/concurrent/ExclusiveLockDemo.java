package com.example.sbredismysqlrbmqseckill.concurrent;

public class ExclusiveLockDemo {
    public static void main(String[] args) {
        ExclusiveLockSharedResource resource = new ExclusiveLockSharedResource();

        // 创建一个写线程
        Thread writeThread = new Thread(() -> {
            resource.writeData(100);
            System.out.println("Thread " + Thread.currentThread().getId() + " Writing data...");
        });
        writeThread.start();

        // 创建多个读线程，并等待写线程执行完成
        try {
            writeThread.join(); // 主线程等待写线程执行完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 创建多个读线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("Thread " + Thread.currentThread().getId() + " Reading data: " + resource.readData());
            }).start();
        }
    }
}
