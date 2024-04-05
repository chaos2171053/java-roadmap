package org.example.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // 创建两个HashMap对象
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");

        Map<String, String> map2 = new HashMap<>();
        map2.put("key3", "value3");
        map2.put("key4", "value4");

        // 将map2中的映射复制到map1中
        map1.putAll(map2);

        // 打印合并后的map1
        System.out.println("map1 after putAll(): " + map1);
    }
}
