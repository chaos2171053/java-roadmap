package com.example.sbredismysqlrbmqseckill.concurrent;

//原子性就是指对数据的操作是一个独立的、不可分割的整体。
// 换句话说，就是一次操作，是一个连续不可中断的过程，数据不会执行的一半的时候被其他线程所修改。
// 保证原子性的最简单方式是操作系统指令，就是说如果一次操作对应一条操作系统指令，这样肯定可以能保证原子性。
// 但是很多操作不能通过一条指令就完成。
// 例如，对long类型的运算，很多系统就需要分成多条指令分别对高位和低位进行操作才能完成。
// 还比如，我们经常使用的整数 i++ 的操作，其实需要分成三个步骤：
// （1）读取整数 i 的值；
// （2）对 i 进行加一操作；
// （3）将结果写回内存
public class NonAtomicDemo {
    private static long counter = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increaseCounter();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increaseCounter();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter);
    }
    private static void  increaseCounter(){
//        long temp = counter;
//        temp++; // 分解为三步：读取counter的值、加一、写回counter
//        counter = temp;
    }
}
