package org.example.dp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest2 {

    @Test
    public void testExample1() {
        LongestIncreasingSubsequence2 lis = new LongestIncreasingSubsequence2();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        assertEquals(4, lis.lengthOfLIS(nums));
    }

    @Test
    public void testExample2() {
        LongestIncreasingSubsequence2 lis = new LongestIncreasingSubsequence2();
        int[] nums = {0, 1, 0, 3, 2, 3};
        assertEquals(4, lis.lengthOfLIS(nums));
    }

    @Test
    public void testExample3() {
        LongestIncreasingSubsequence2 lis = new LongestIncreasingSubsequence2();
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        assertEquals(1, lis.lengthOfLIS(nums));
    }

    @Test
    public void testAdditionalCase1() {
        LongestIncreasingSubsequence2 lis = new LongestIncreasingSubsequence2();
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        assertEquals(6, lis.lengthOfLIS(nums));
    }

    @Test
    public void testAdditionalCase2() {
        LongestIncreasingSubsequence2 lis = new LongestIncreasingSubsequence2();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(9, lis.lengthOfLIS(nums));
    }

    @Test
    public void testAdditionalCase3() {
        LongestIncreasingSubsequence2 lis = new LongestIncreasingSubsequence2();
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertEquals(1, lis.lengthOfLIS(nums));
    }

    @Test
    public void testEmptyArray() {
        LongestIncreasingSubsequence2 lis = new LongestIncreasingSubsequence2();
        int[] nums = {};
        assertEquals(0, lis.lengthOfLIS(nums));
    }

    @Test
    public void testSingleElementArray() {
        LongestIncreasingSubsequence2 lis = new LongestIncreasingSubsequence2();
        int[] nums = {1};
        assertEquals(1, lis.lengthOfLIS(nums));
    }
}

