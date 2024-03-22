package org.example.tree;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void testQuickSortEmptyArray() {
        // 测试空数组的情况
        int[] arr = {};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testQuickSortSingleElementArray() {
        // 测试只有一个元素的数组的情况
        int[] arr = {1};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    public void testQuickSortSortedArray() {
        // 测试已排序数组的情况
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testQuickSortReverseSortedArray() {
        // 测试逆序数组的情况
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testQuickSortRandomArray() {
        // 测试随机数组的情况
        int[] arr = {3, 1, 4, 2, 5};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
}
