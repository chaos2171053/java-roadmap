package com.example.springbootredisratelimiting.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {
    private final int windowSize;
    private final int threshold;
    private final Deque<Long> timestamps;

    public SlidingWindow(int windowSize, int threshold) {
        this.windowSize = windowSize;
        this.threshold = threshold;
        this.timestamps = new ArrayDeque<>();
    }
    public synchronized boolean allowRequest(){
        long currentTime = System.currentTimeMillis();
        cleanUpOldRequests(currentTime);
        if(timestamps.size()<threshold){
            timestamps.offerLast(currentTime);
            return true;
        }else {
            return false;
        }
    }

    private void cleanUpOldRequests(long currentTime) {
        while(!timestamps.isEmpty() && currentTime- timestamps.peekFirst()>=windowSize){
            timestamps.pollFirst();
        }
    }
}
