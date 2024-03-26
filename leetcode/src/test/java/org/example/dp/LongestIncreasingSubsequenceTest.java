package org.example.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testLengthOfLIS() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int result = lis.lengthOfLIS(nums);
        assertEquals(4, result);
    }
}
