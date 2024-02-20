package com.example.sbredismysqlrbmqseckill.tutorial.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//ArrayList 的使用场景包括但不限于：
//当你需要一个可以动态增长的数组时，可以选择使用 ArrayList。因为 ArrayList 在添加和删除元素时比数组更灵活，无需手动管理容量。
//当你需要一个有序的集合，可以使用 ArrayList，因为它保留了添加元素的顺序。
//当你需要对集合进行频繁的随机访问时，ArrayList 的性能更好，因为它通过索引访问元素的时间复杂度是 O(1)。

public class ArrayListExample {
    @Test
    public void testArrayListOperations(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("orange");

        assertEquals(3,arrayList.size());

        assertEquals("apple",arrayList.get(0));

        arrayList.remove(0);


        assertEquals(2,arrayList.size());

        assertEquals("banana", arrayList.get(0));
        assertEquals("orange", arrayList.get(1));
    }
}
