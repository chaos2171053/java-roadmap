package org.example.thread;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        // 创建一个Vector对象，初始容量为10
        Vector<String> vector = new Vector<>();

        // 向Vector中添加元素
        vector.add("Java");
        vector.add("Python");
        vector.add("C++");

        // 获取Vector的大小
        int size = vector.size();
        System.out.println("Vector的大小为: " + size);

        // 遍历Vector中的元素
        System.out.println("Vector中的元素:");
        for (String element : vector) {
            System.out.println(element);
        }

        // 在指定位置插入元素
        vector.add(1, "JavaScript");

        // 移除指定位置的元素
        vector.remove(2);

        // 判断Vector是否包含某个元素
        boolean containsPython = vector.contains("Python");
        System.out.println("Vector中是否包含Python: " + containsPython);

        // 获取指定位置的元素
        String elementAtIndexTwo = vector.get(2);
        System.out.println("索引为2的元素是: " + elementAtIndexTwo);

        // 清空Vector
        vector.clear();

        // 判断Vector是否为空
        boolean isEmpty = vector.isEmpty();
        System.out.println("Vector是否为空: " + isEmpty);
    }
}
