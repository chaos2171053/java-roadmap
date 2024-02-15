package com.example.springbootredisratelimiting.algorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SlidingWindowTest {
    @Test
    public void testSlidingWindow() {
        SlidingWindow window = new SlidingWindow(1000, 5); // 窗口大小为1秒，阈值为5
        assertTrue(window.allowRequest());
        assertTrue(window.allowRequest());
        assertTrue(window.allowRequest());
        assertTrue(window.allowRequest());
        assertTrue(window.allowRequest());
        assertFalse(window.allowRequest()); // 窗口中没有足够的请求数量，无法再放入请求
    }
}

