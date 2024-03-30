package org.example.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSubarrayTest {

    @Test
    public void testMaximumSubarray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, MaximumSubarray.maxSubArray(nums));

        nums = new int[]{1};
        assertEquals(1, MaximumSubarray.maxSubArray(nums));

        nums = new int[]{5, 4, -1, 7, 8};
        assertEquals(23, MaximumSubarray.maxSubArray(nums));
    }
}