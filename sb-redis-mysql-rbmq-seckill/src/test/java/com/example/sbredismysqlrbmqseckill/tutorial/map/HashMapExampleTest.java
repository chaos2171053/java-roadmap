package com.example.sbredismysqlrbmqseckill.tutorial.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapExampleTest {
    @Test
    public void testHashMap(){
        // create hashmap and add element
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("apple",10);
        hashMap.put("banana",10);

        // test get element
        assert hashMap.get("apple") == 10;

        // test remove element
        hashMap.remove("banana");
        assert hashMap.get("banana") == null;

        // test has key
        assert !hashMap.containsKey("chaos");
        assert hashMap.containsKey("apple");




    }
}
