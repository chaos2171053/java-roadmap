package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MinimumSizeSubarraySumTest {

    @Test
    public void testMinSubArrayLen_Example1() {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int expected = 2; // 子数组 [4, 3] 的长度是 2
        int result = solution.minSubArrayLen(s, nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMinSubArrayLen_Example2() {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        int s = 15;
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 5; // 整个数组的和是15，所以长度最小的子数组是整个数组，长度为5
        int result = solution.minSubArrayLen(s, nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMinSubArrayLen_NoValidSubarray() {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        int s = 20;
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 0; // 不存在满足条件的子数组，返回0
        int result = solution.minSubArrayLen(s, nums);
        assertEquals(expected, result);
    }
}

