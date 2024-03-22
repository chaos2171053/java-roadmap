package com.example.sbredismysqlrbmqseckill.demos.scene;

//场景题：1000个任务，分给10个人做，你怎么分配，先在纸上写个最简单的版本，然后优化。
//全局队列，把1000任务放在一个队列里面，然后每个人都是取，完成任务。
//分为10个队列，每个人分别到自己对应的队列中去取务。
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskDistribution {
    // 任务数量
    private static final int TASK_COUNT = 1000;
    // 人数
    private static final int PERSON_COUNT = 10;

    public static void main(String[] args) {
        // 全局任务队列
        BlockingQueue<Integer> globalQueue = new ArrayBlockingQueue<>(TASK_COUNT);
        for (int i = 1; i <= TASK_COUNT; i++) {
            globalQueue.offer(i);
        }

        // 模拟10个人处理任务
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < PERSON_COUNT; i++) {
            Thread thread = new Thread(new Worker(i, globalQueue));
            thread.start();
            threads.add(thread);
        }

        // 等待所有线程结束
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All tasks are completed!");
    }

    // 任务处理者
    static class Worker implements Runnable {
        private final int id;
        private final BlockingQueue<Integer> queue;

        public Worker(int id, BlockingQueue<Integer> queue) {
            this.id = id;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!queue.isEmpty()) {
                try {
                    // 从全局队列中取出任务并处理
                    Integer task = queue.poll();
                    if (task != null) {
                        System.out.println("Worker " + id + " is processing task: " + task);
                        // 模拟处理任务的时间
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

