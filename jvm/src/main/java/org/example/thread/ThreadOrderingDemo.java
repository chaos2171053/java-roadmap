package org.example.thread;

public class ThreadOrderingDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable("T1"));
        Thread t2 = new Thread(new MyRunnable("T2"));
        Thread t3 = new Thread(new MyRunnable("T3"));

        try {
            // 先启动最后一个线程T3
            t3.start();
            // 使用join()方法确保T3执行完成后再启动T2
            t3.join();
            t2.start();
            // 使用join()方法确保T2执行完成后再启动T1
            t2.join();
            t1.start();
            // 使用join()方法确保T1执行完成后再继续main线程
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished execution.");
    }

    static class MyRunnable implements Runnable {
        private final String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " is running.");
        }
    }
}

