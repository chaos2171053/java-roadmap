package com.example.sbredismysqlrbmqseckill.concurrent;

public class LockDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

//        // 创建多个读线程
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                System.out.println("Thread "+Thread.currentThread().getId() + " Reading data: " + resource.readData());
//            }).start();
//        }
//
//        // 创建一个写线程
//        new Thread(() -> {
//            resource.writeData(100);
//            System.out.println("Thread "+Thread.currentThread().getId()+ " Writing data...");
//        }).start();

       // 创建一个写线程
        Thread writeThread = new Thread(() -> {
            resource.writeData(100);
            System.out.println("Thread " + Thread.currentThread().getId() + " Writing data...");
        });
        writeThread.start();

        try {
            // 等待写线程执行完成
            writeThread.join();
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
