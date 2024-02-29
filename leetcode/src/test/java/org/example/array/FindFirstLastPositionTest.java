package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class FindFirstLastPositionTest {

    @Test
    public void testSearchRange_TargetExists() {
        FindFirstLastPosition findFirstLastPosition = new FindFirstLastPosition();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expected = {3, 4}; // 目标值8的起始位置为3，结束位置为4
        int[] result = findFirstLastPosition.searchRange(nums, target);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchRange_TargetDoesNotExist() {
        FindFirstLastPosition findFirstLastPosition = new FindFirstLastPosition();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] expected = {-1, -1}; // 目标值6不存在于数组中
        int[] result = findFirstLastPosition.searchRange(nums, target);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchRange_EmptyArray() {
        FindFirstLastPosition findFirstLastPosition = new FindFirstLastPosition();
        int[] nums = {};
        int target = 8;
        int[] expected = {-1, -1}; // 数组为空
        int[] result = findFirstLastPosition.searchRange(nums, target);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchRange_SingleElementArray_TargetExists() {
        FindFirstLastPosition findFirstLastPosition = new FindFirstLastPosition();
        int[] nums = {1};
        int target = 1;
        int[] expected = {0, 0}; // 数组中只有一个元素，且与目标值相等
        int[] result = findFirstLastPosition.searchRange(nums, target);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchRange_SingleElementArray_TargetDoesNotExist() {
        FindFirstLastPosition findFirstLastPosition = new FindFirstLastPosition();
        int[] nums = {2};
        int target = 1;
        int[] expected = {-1, -1}; // 数组中只有一个元素，且与目标值不相等
        int[] result = findFirstLastPosition.searchRange(nums, target);
        assertArrayEquals(expected, result);
    }
}

