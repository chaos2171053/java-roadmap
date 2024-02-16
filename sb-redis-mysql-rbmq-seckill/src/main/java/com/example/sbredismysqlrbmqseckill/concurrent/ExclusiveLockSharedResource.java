package com.example.sbredismysqlrbmqseckill.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExclusiveLockSharedResource {
    private int data = 0;
    private final Lock lock = new ReentrantLock();

    public int readData() {
        lock.lock();
        try {
            return data;
        } finally {
            lock.unlock();
        }
    }

    public void writeData(int newData) {
        lock.lock();
        try {
            data = newData;
        } finally {
            lock.unlock();
        }
    }
}
