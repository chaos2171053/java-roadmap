package com.example.sbredismysqlrbmqseckill.concurrent;

// synchronized同步锁 https://cloud.tencent.com/developer/article/1698360
//public class SellTickets {
//    public static void main(String[] args) {
//        TicketSeller seller = new TicketSeller();
//
//        Thread t1 = new Thread(seller, "窗口1");
//        Thread t2 = new Thread(seller, "窗口2");
//        Thread t3 = new Thread(seller, "窗口3");
//
//        t1.start();
//        t2.start();
//        t3.start();
//    }
//}
//
//class TicketSeller extends Thread {
//    private static int tickets = 20;
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//
//            }
//            if (tickets > 0) {
//                System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
//            }
//        }
//    }
//}


//public class SellTickets {
//    public static void main(String[] args) {
//        TicketSeller seller = new TicketSeller();
//
//        Thread t1 = new Thread(seller, "窗口1");
//        Thread t2 = new Thread(seller, "窗口2");
//        Thread t3 = new Thread(seller, "窗口3");
//
//        t1.start();
//        t2.start();
//        t3.start();
//    }
//}
//
//class TicketSeller implements Runnable {
//    private static int tickets = 20;
//
//    @Override
//    public void run() {
//        while (true) {
//            // 同步代码块的关键在于锁对象，多个线程必须持有同一把锁，才会实现互斥性。
//            // synchronized (this) 改为 synchronized (new Objcet()) 的话，线程安全将得不到保证，因为两个线程的持锁对象不再是同一个。
//            synchronized (this) {
////            synchronized (new Object()){
//                try {
//                    Thread.sleep(1000);
//                    if (tickets > 0) {
//                        System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}

//public class SellTickets implements Runnable {
//    // 共享资源变量
//    int count = 0;
//
//    @Override
//    public void run() {
//        synchronized (this) {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(Thread.currentThread().getName() + ":" + count++);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        test1();
//        //test2();
//    }
//
//    public static void test1() {
//        SellTickets syncTest1 = new SellTickets();
//        Thread thread1 = new Thread(syncTest1, "thread-1");
//        Thread thread2 = new Thread(syncTest1, "thread-2");
//        thread1.start();
//        thread2.start();
//    }
//
//    public static void test2() {
//        SellTickets syncTest1 = new SellTickets();
//        SellTickets syncTest2 = new SellTickets();
//
//        Thread thread1 = new Thread(syncTest1, "thread-1");
//        Thread thread2 = new Thread(syncTest2, "thread-2");
//        thread1.start();
//        thread2.start();
//    }
//}


//public class SyncTest {
//    public static void main(String[] args) {
//        Counter counter = new Counter();
//        Thread thread1 = new Thread(counter, "线程-1");
//        Thread thread2 = new Thread(counter, "线程-2");
//        thread1.start();
//        thread2.start();
//    }
//}
//
//class Counter implements Runnable {
//    private int count = 0;
//
//    public void countAdd() {
//        synchronized (this) {
//            for (int i = 0; i < 5; i++) {
//                try {
//                    System.out.println(Thread.currentThread().getName() + " 同步计数:" + (count++));
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public void printCount() {
//        for (int i = 0; i < 5; i++) {
//            try {
//                System.out.println(Thread.currentThread().getName() + " 非同步输出：" + count);
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void run() {
//        String threadName = Thread.currentThread().getName();
//        if (threadName.equals("线程-1")) {
//            countAdd();
//        } else if (threadName.equals("线程-2")) {
//            printCount();
//        }
//    }
//}

//public class SyncTest {
//    public static void main(String args[]) {
//        Account account = new Account("zhang san", 10000.0f);
//        AccountOperator accountOperator = new AccountOperator(account);
//
//        final int THREAD_NUM = 5;
//        Thread threads[] = new Thread[THREAD_NUM];
//        for (int i = 0; i < THREAD_NUM; i++) {
//            threads[i] = new Thread(accountOperator, "Thread-" + i);
//            threads[i].start();
//        }
//    }
//}

//class Account {
//    String name;
//    double amount;
//
//    public Account(String name, double amount) {
//        this.name = name;
//        this.amount = amount;
//    }
//
//    //存钱
//    public void deposit(double amt) {
//        amount += amt;
//        try {
//            Thread.sleep(0);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //取钱
//    public void withdraw(double amt) {
//        amount -= amt;
//        try {
//            Thread.sleep(0);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public double getBalance() {
//        return amount;
//    }
//}
//
//class AccountOperator implements Runnable {
//    private Account account;
//
//    public AccountOperator(Account account) {
//        this.account = account;
//    }
//
//    public void run() {
//        synchronized (account) {
//            String name = Thread.currentThread().getName();
//            account.deposit(500);
//            System.out.println(name + "存入500，最新余额：" + account.getBalance());
//            account.withdraw(400);
//            System.out.println(name + "取出400，最新余额：" + account.getBalance());
//            System.out.println(name + "最终余额:" + account.getBalance());
//        }
//    }
//}

//public class SellTickets {
//    public static void main(String[] args) {
//        TicketSeller seller = new TicketSeller();
//
//        Thread t1 = new Thread(seller, "窗口1");
//        Thread t2 = new Thread(seller, "窗口2");
//        Thread t3 = new Thread(seller, "窗口3");
//
//        t1.start();
//        t2.start();
//        t3.start();
//    }
//}
//
//class TicketSeller implements Runnable {
//    private static int tickets = 20;
//
//    @Override
//    public void run() {
//        while (true) {
//            sellTickets();
//        }
//    }
//
//    public synchronized void sellTickets() {
//        try {
//            Thread.sleep(100);
//            if (tickets > 0) {
//                System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}

public class SyncTest {
    public static void main(String args[]) {
        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();
        Thread thread1 = new Thread(syncThread1, "Thread-1");
        Thread thread2 = new Thread(syncThread2, "Thread-2");
        thread1.start();
        thread2.start();
    }
}

class SyncThread implements Runnable {
    private static int count = 0;

    public synchronized static void method() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void run() {
        method();
    }
}