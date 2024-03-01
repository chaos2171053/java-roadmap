package org.example.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesTest {

    @Test
    public void testRemoveDuplicates_NormalCase() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int[] expectedNums = {1, 2, 3, 4, 5}; // 删除重复元素后的数组
        int k = removeDuplicates.removeDuplicates(nums);
        assertEquals(expectedNums.length, k); // 验证返回的长度
        // 验证 nums 数组中的元素是否符合预期
        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    @Test
    public void testRemoveDuplicates_AllElementsUnique() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 2, 3, 4, 5};
        int[] expectedNums = {1, 2, 3, 4, 5}; // 数组中所有元素都是唯一的
        int k = removeDuplicates.removeDuplicates(nums);
        assertEquals(expectedNums.length, k); // 验证返回的长度
        // 验证 nums 数组中的元素是否符合预期
        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    @Test
    public void testRemoveDuplicates_EmptyArray() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {};
        int[] expectedNums = {}; // 空数组
        int k = removeDuplicates.removeDuplicates(nums);
        assertEquals(expectedNums.length, k); // 验证返回的长度
        // 验证 nums 数组中的元素是否符合预期
        assertEquals(Arrays.toString(expectedNums), Arrays.toString(nums));
    }
}

