package org.example.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 创建一个Semaphore，初始许可数为2
        Semaphore semaphore = new Semaphore(2);

        // 创建并启动线程
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new Worker(semaphore, i));
            thread.start();
        }
    }

    static class Worker implements Runnable {
        private final Semaphore semaphore;
        private final int id;

        public Worker(Semaphore semaphore, int id) {
            this.semaphore = semaphore;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                // 获取许可
                semaphore.acquire();
                System.out.println("Worker " + id + " is working...");
                Thread.sleep(2000); // 模拟工作
                System.out.println("Worker " + id + " has finished working.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放许可
                semaphore.release();
            }
        }
    }
}
