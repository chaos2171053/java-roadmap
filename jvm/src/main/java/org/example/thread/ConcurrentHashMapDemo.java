package org.example.thread;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        // 添加元素
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");

        // 获取元素
        System.out.println("Key 1: " + map.get(1));
        System.out.println("Key 2: " + map.get(2));
        System.out.println("Key 3: " + map.get(3));

        // 删除元素
        map.remove(2);

        // 判断是否包含指定key
        System.out.println("Contains key 2: " + map.containsKey(2));

        // 获取大小
        System.out.println("Size of map: " + map.size());
    }
}

