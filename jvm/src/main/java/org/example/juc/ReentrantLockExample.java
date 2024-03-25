package org.example.juc;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static final Lock lock = new ReentrantLock(); // 创建重入锁实例

    public static void main(String[] args) {
        // 创建两个线程，分别调用同一个方法
        Thread thread1 = new Thread(() -> {
            executeTask();
        });
        Thread thread2 = new Thread(() -> {
            executeTask();
        });

        // 启动线程
        thread1.start();
        thread2.start();
    }

    public static void executeTask() {
        lock.lock(); // 获取锁
        try {
            System.out.println(Thread.currentThread().getName() + " 获取到锁"); // 输出线程名称
            nestedMethod(); // 调用嵌套方法
        } finally {
            lock.unlock(); // 释放锁
            System.out.println(Thread.currentThread().getName() + " 释放了锁");
        }
    }

    public static void nestedMethod() {
        lock.lock(); // 再次获取锁
        try {
            System.out.println(Thread.currentThread().getName() + " 再次获取到锁");
            // 执行一些操作
        } finally {
            lock.unlock(); // 再次释放锁
            System.out.println(Thread.currentThread().getName() + " 释放了锁");
        }
    }
}
