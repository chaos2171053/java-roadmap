package org.example.other;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubarraySumEqualsKTest {

    @Test
    public void testSubarraySum1() {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] nums = {1, 1, 1};
        int k = 2;
        assertEquals(2, solution.subarraySum(nums, k));
    }

    @Test
    public void testSubarraySum2() {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] nums = {1, 2, 3};
        int k = 3;
        assertEquals(2, solution.subarraySum(nums, k));
    }

    @Test
    public void testSubarraySum3() {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] nums = {1, 2, 1, 2, 1};
        int k = 3;
        assertEquals(4, solution.subarraySum(nums, k));
    }

    @Test
    public void testSubarraySum4() {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        assertEquals(4, solution.subarraySum(nums, k));
    }
}

