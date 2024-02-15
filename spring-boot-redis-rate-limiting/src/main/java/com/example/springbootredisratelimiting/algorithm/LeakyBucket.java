package com.example.springbootredisratelimiting.algorithm;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucket {
    private final int capacity;
    private final int leakRate; // 漏水速率，单位：毫秒
    private  long lastLeakTime;
    private Queue<Long> bucket;

    public LeakyBucket(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.lastLeakTime = Instant.now().toEpochMilli();
        this.bucket = new LinkedList<>();
    }
    public synchronized boolean allowRequest(){
        leak();
        if(bucket.size()<capacity){
            bucket.offer(Instant.now().toEpochMilli());
            return  true;
        }else {
            return  false;
        }
    }
    private synchronized void leak(){
        long currentTime = Instant.now().toEpochMilli();
        long elapsedTime = currentTime - lastLeakTime;
        int leaks = (int) (elapsedTime/leakRate);
        while(leaks>0 && !bucket.isEmpty()){
            bucket.poll();
            leaks--;
        }
        lastLeakTime = currentTime;
    }
}
