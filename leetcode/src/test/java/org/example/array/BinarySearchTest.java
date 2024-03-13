package org.example.array;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void testSearch_TargetExists() {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int expected = 4; // 目标值9的下标为4
        int result = binarySearch.search(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearch_TargetDoesNotExist() {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int expected = -1; // 目标值2不存在于数组中
        int result = binarySearch.search(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearch_EmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {};
        int target = 5;
        int expected = -1; // 数组为空，返回-1
        int result = binarySearch.search(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearch_SingleElementArray_TargetExists() {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {5};
        int target = 5;
        int expected = 0; // 目标值5在数组中的下标为0
        int result = binarySearch.search(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearch_SingleElementArray_TargetDoesNotExist() {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {3};
        int target = 5;
        int expected = -1; // 目标值5不存在于数组中
        int result = binarySearch.search(nums, target);
        assertEquals(expected, result);
    }
    @Test
    public void testSearch_GetLeftIndex() {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {1,2,2,2,3};
        int target = 2;
        int expected = 2; // 目标值5不存在于数组中
        int result = binarySearch.search(nums, target);
        assertEquals(expected, result);
    }
}

