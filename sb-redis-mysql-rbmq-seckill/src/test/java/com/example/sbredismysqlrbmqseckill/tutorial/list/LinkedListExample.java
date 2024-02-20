package com.example.sbredismysqlrbmqseckill.tutorial.list;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

// LinkedList 的使用场景包括但不限于：
// 当需要频繁进行插入和删除操作，且不关心随机访问元素时，可以选择使用 LinkedList。
// 当需要在任意位置插入或删除元素，而不会对其他元素的位置造成影响时，LinkedList 是一个更好的选择。
// 当需要实现队列（FIFO）或栈（LIFO）时，LinkedList 提供了相应的方法，使得实现这些数据结构更加简单高效。
public class LinkedListExample {
    @Test
    public void testLinkedListOperations(){
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        assertEquals(3,list.size());

        assertEquals("Apple", list.get(0));
        assertEquals("Banana", list.get(1));
        assertEquals("Orange", list.get(2));

        // 从 LinkedList 中删除元素
        list.remove("Banana");

        // 断言 LinkedList 的大小
        assertEquals(2, list.size());

        // 断言删除元素后 LinkedList 中的元素
        assertEquals("Apple", list.get(0));
        assertEquals("Orange", list.get(1));


    }

}
