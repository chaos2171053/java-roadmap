package com.example.sbredismysqlrbmqseckill.concurrent;

public class SynchronizedSharedResource {
    private int data = 0;

    public synchronized int readData() {
        return data;
    }

    public synchronized void writeData(int newData) {
        data = newData;
    }

}
