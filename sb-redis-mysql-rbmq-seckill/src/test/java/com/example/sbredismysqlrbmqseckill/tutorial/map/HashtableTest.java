package com.example.sbredismysqlrbmqseckill.tutorial.map;

import org.junit.jupiter.api.Test;

import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashtableTest {

    @Test
    public void testHashtableOperations() {
        // 创建一个 Hashtable 实例
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // 添加键值对
        hashtable.put("apple", 10);
        hashtable.put("banana", 20);
        hashtable.put("orange", 30);

        // 断言 Hashtable 中的键值对
        assertEquals(3, hashtable.size());
        assertEquals(10, hashtable.get("apple"));
        assertEquals(20, hashtable.get("banana"));
        assertEquals(30, hashtable.get("orange"));

        // 移除键值对
        hashtable.remove("banana");

        // 断言移除键值对后 Hashtable 的大小
        assertEquals(2, hashtable.size());

        // 断言移除键值对后 Hashtable 中的键值对
        assertEquals(null, hashtable.get("banana"));
    }
}
