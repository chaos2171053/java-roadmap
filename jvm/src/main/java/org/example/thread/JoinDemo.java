package org.example.thread;

class MyThread3 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running...");
        try {
            Thread.sleep(2000); // 模拟线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is finished.");
    }
}

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建两个线程
        MyThread3 thread1 = new MyThread3();
        MyThread3 thread2 = new MyThread3();

        // 启动两个线程
        thread1.start();
        thread2.start();

        // 等待两个线程执行完毕
        System.out.println("Waiting for threads to finish...");
        thread1.join();
        thread2.join();
        System.out.println("All threads have finished.");
    }
}

