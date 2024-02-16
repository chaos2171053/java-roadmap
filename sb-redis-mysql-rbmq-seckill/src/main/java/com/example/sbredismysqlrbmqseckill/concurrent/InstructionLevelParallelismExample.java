package com.example.sbredismysqlrbmqseckill.concurrent;


public class InstructionLevelParallelismExample {
    private static int x = 0;
    private static int y = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            x = 1;
            System.out.println("y = " + y); // 输出可能为 0
        }).start();

        new Thread(() -> {
            y = 2;
            System.out.println("x = " + x); // 输出可能为 0
        }).start();
    }
}




