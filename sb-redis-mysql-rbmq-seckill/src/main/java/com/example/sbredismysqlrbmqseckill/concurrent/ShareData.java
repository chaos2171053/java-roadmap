package com.example.sbredismysqlrbmqseckill.concurrent;

// 学习 java 并发 https://www.cnblogs.com/paddix/p/5374810.html
public class ShareData {
    public static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 在这里可以创建并启动多个线程，对 count 进行操作
            new Thread(new Runnable(){
                @Override
                public void run() {
                    //进入的时候暂停10毫秒，增加并发问题出现的几率
                    try {
                        Thread.sleep(10);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    for (int j = 0; j < 100; j++) {
                        addCount();
                    }

                }
            }).start();
        }
        try {
            //主程序暂停3秒，以保证上面的程序执行完成
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count=" + count);
    }
    public static void addCount(){
        count++;
    }
}
