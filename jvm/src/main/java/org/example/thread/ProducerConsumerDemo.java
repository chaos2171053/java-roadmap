package org.example.thread;

//public class ProducerConsumerDemo {
//    static class Producer implements Runnable {
//        private final BlockingQueue<Integer> queue;
//
//        public Producer(BlockingQueue<Integer> queue) {
//            this.queue = queue;
//        }
//
//        @Override
//        public void run() {
//            try {
//                for (int i = 0; i < 10; i++) {
//                    Thread.sleep(1000); // 模拟生产过程
//                    System.out.println("Producing: " + i);
//                    queue.put(i); // 将数据放入队列
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//
//    static class Consumer implements Runnable {
//        private final BlockingQueue<Integer> queue;
//
//        public Consumer(BlockingQueue<Integer> queue) {
//            this.queue = queue;
//        }
//
//        @Override
//        public void run() {
//            try {
//                while (true) {
//                    Integer data = queue.take(); // 从队列中取出数据，如果队列为空，则阻塞等待
//                    System.out.println("Consuming: " + data);
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5); // 创建大小为5的阻塞队列
//
//        Thread producerThread = new Thread(new Producer(queue));
//        Thread consumerThread = new Thread(new Consumer(queue));
//
//        producerThread.start();
//        consumerThread.start();
//    }
//}

import java.util.concurrent.Semaphore;

public class ProducerConsumerDemo {
    static class Producer implements Runnable {
        private final Semaphore semaphore;
        private final int[] buffer;

        public Producer(Semaphore semaphore, int[] buffer) {
            this.semaphore = semaphore;
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    semaphore.acquire(); // 获取信号量
                    buffer[i % buffer.length] = i; // 生产数据
                    System.out.println("Producing: " + i);
                    Thread.sleep(1000); // 模拟生产过程
                    semaphore.release(); // 释放信号量
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        private final Semaphore semaphore;
        private final int[] buffer;

        public Consumer(Semaphore semaphore, int[] buffer) {
            this.semaphore = semaphore;
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    semaphore.acquire(); // 获取信号量
                    int data = buffer[0]; // 消费数据
                    System.out.println("Consuming: " + data);
                    Thread.sleep(1000); // 模拟消费过程
                    semaphore.release(); // 释放信号量
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1); // 初始信号量为1
        int[] buffer = new int[1]; // 缓冲区大小为1

        Thread producerThread = new Thread(new Producer(semaphore, buffer));
        Thread consumerThread = new Thread(new Consumer(semaphore, buffer));

        producerThread.start();
        consumerThread.start();
    }
}
