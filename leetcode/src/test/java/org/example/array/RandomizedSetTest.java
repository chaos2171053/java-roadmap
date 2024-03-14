package org.example.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class RandomizedSetTest {

    private RandomizedSet randomizedSet;

    @Before
    public void setUp() {
        randomizedSet = new RandomizedSet();
    }

    @Test
    public void testInsert() {
        assertTrue(randomizedSet.insert(1));
        assertFalse(randomizedSet.insert(1)); // 重复插入相同元素，应返回 false
        assertTrue(randomizedSet.insert(2));
        assertTrue(randomizedSet.insert(3));
    }

    @Test
    public void testRemove() {
        assertFalse(randomizedSet.remove(1)); // 集合为空，删除不存在的元素应返回 false
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.insert(3);
        assertTrue(randomizedSet.remove(2));
        assertFalse(randomizedSet.remove(2)); // 删除已经不存在的元素应返回 false
        assertFalse(randomizedSet.remove(4)); // 删除不存在的元素应返回 false
        assertTrue(randomizedSet.remove(1));
    }

    @Test
    public void testGetRandom() {
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.insert(3);
        int randomVal = randomizedSet.getRandom();
        assertTrue(randomVal == 1 || randomVal == 2 || randomVal == 3); // 返回值应为插入的元素之一
    }
}


