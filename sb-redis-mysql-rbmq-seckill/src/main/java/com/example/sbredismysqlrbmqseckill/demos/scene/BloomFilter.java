package com.example.sbredismysqlrbmqseckill.demos.scene;

import java.util.BitSet;

public class BloomFilter {
    private final int size; // 布隆过滤器的大小
    private final int[] seeds; // 哈希函数种子数组
    private final BitSet bitSet; // 位数组

    public BloomFilter(int size, int numHashFunctions) {
        this.size = size;
        this.seeds = new int[numHashFunctions];
        for (int i = 0; i < numHashFunctions; i++) {
            seeds[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }
        this.bitSet = new BitSet(size);
    }

    // 添加元素
    public void add(String element) {
        for (int seed : seeds) {
            int hash = hash(element, seed);
            bitSet.set(hash % size);
        }
    }

    // 判断元素是否存在
    public boolean contains(String element) {
        for (int seed : seeds) {
            int hash = hash(element, seed);
            if (!bitSet.get(hash % size)) {
                return false;
            }
        }
        return true;
    }

    // 哈希函数
    private int hash(String element, int seed) {
        int hash = 0;
        for (char c : element.toCharArray()) {
            hash = hash * seed + c;
        }
        return Math.abs(hash);
    }

    public static void main(String[] args) {
        BloomFilter filter = new BloomFilter(1000000, 3); // 创建布隆过滤器，大小为100万，使用3个哈希函数
        filter.add("hello");
        filter.add("world");

        System.out.println(filter.contains("hello")); // 输出 true
        System.out.println(filter.contains("world")); // 输出 true
        System.out.println(filter.contains("foo"));   // 输出 false
    }
}
