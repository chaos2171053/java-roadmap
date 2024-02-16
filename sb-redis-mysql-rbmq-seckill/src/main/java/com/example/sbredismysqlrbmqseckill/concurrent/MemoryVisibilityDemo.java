package com.example.sbredismysqlrbmqseckill.concurrent;

//          __________________________________________________________
//         |                        Main Memory (主内存)                |
//         |__________________________________________________________|
//         |                                                           |
//         |                      Shared Variables                      |
//         |___________________________________________________________|
//         |                                                           |
//         |                      Thread 1                            |
//         |___________________________________________________________|
//         |                     |                                     |
//         |                     |          Worker Thread 1            |
//         |    Worker Thread    |_____________________________________|
//         |    (工作线程)       |                                     |
//         |_____________________|          Worker Thread 2            |
//         |                                                           |
//         |                      Thread 2                            |
//         |___________________________________________________________|

//主内存（Main Memory）：存储所有的共享变量。所有线程都可以访问主内存中的共享变量，但不能直接操作主内存，必须先将共享变量从主内存加载到各自的工作内存中进行操作。
//
//工作内存（Worker Thread）：每个线程都拥有自己的工作内存，用于存储线程独享的变量副本。线程对共享变量的操作都是在工作内存中进行的。当一个线程需要读取共享变量时，首先从主内存中将共享变量加载到工作内存中，然后对其进行操作。当线程写入共享变量时，也是先在工作内存中修改副本的值，然后再将修改后的值写回主内存。这样的设计提高了线程的运行效率，因为线程可以直接操作工作内存，而无需频繁地访问主内存。
//
//共享变量（Shared Variables）：存储在主内存中的共享数据，可以被多个线程同时访问和修改。
//
//由于每个线程都拥有自己的工作内存，所以可能会出现线程之间对共享变量的修改不可见的情况，这就是内存可见性问题。为了解决内存可见性问题，需要使用同步机制（如锁、volatile关键字）来确保线程对共享变量的修改能够及时被其他线程看到。

public class MemoryVisibilityDemo {
//    private static volatile boolean flag = false;
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread(() -> {
//            while (!flag) {
//                // do nothing
//            }
//            System.out.println("Thread 1: Flag is now true.");
//        });
//
//        Thread thread2 = new Thread(() -> {
//            flag = true;
//            System.out.println("Thread 2: Flag is now true.");
//        });
//
//        thread1.start();
//        Thread.sleep(100); // 确保 thread1 先启动
//        thread2.start();
//    }

    private static boolean flag = false;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                while (!flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread 1: Flag is now true.");
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                flag = true;
                lock.notifyAll();
                System.out.println("Thread 2: Flag is now true.");
            }
        });

        thread1.start();
        Thread.sleep(100); // 确保 thread1 先启动
        thread2.start();
    }



}

