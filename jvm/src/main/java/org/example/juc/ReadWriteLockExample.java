package org.example.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private int sharedResource = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void readSharedResource() {
        lock.readLock().lock(); // 获取读锁
        try {
            System.out.println(Thread.currentThread().getName() + " 读取共享资源：" + sharedResource);
        } finally {
            lock.readLock().unlock(); // 释放读锁
        }
    }

    public void writeSharedResource(int value) {
        lock.writeLock().lock(); // 获取写锁
        try {
            sharedResource = value;
            System.out.println(Thread.currentThread().getName() + " 修改共享资源为：" + sharedResource);
        } finally {
            lock.writeLock().unlock(); // 释放写锁
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample example = new ReadWriteLockExample();

        // 创建多个读线程和写线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                example.readSharedResource();
            }).start();
            new Thread(() -> {
                example.writeSharedResource((int) (Math.random() * 100)); // 随机写入一个数值
            }).start();
        }
    }
}
