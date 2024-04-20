package org.example.slidewindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinSubArrayLenTest {

    private final MinSubArrayLen solution = new MinSubArrayLen();

    @Test
    public void testMinSubArrayLen1() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int expected = 2;
        int result = solution.minSubArrayLen(target, nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMinSubArrayLen2() {
        int target = 4;
        int[] nums = {1, 4, 4};
        int expected = 1;
        int result = solution.minSubArrayLen(target, nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMinSubArrayLen3() {
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int expected = 0;
        int result = solution.minSubArrayLen(target, nums);
        assertEquals(expected, result);
    }
}
