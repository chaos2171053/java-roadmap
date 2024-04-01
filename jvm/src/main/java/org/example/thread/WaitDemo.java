package org.example.thread;

class MyThread extends Thread {
    private final Object lock;

    public MyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                lock.wait(); // 当前线程等待
                System.out.println(Thread.currentThread().getName() + " is notified and resumed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class WaitDemo {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThread thread1 = new MyThread(lock);
        MyThread thread2 = new MyThread(lock);

        thread1.start();
        thread2.start();

        Thread.sleep(1000); // 等待一段时间

        synchronized (lock) {
            System.out.println("Notifying one thread...");
            lock.notify(); // 唤醒一个等待线程
        }

        Thread.sleep(1000); // 等待一段时间
    }
}
