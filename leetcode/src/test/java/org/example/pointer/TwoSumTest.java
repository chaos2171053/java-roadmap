package org.example.pointer;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {

    private final TwoSum solution = new TwoSum();

    @Test
    public void testTwoSum1() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {1, 2};
        assertArrayEquals(expected, solution.twoSum(numbers, target));
    }

    @Test
    public void testTwoSum2() {
        int[] numbers = {2, 3, 4};
        int target = 6;
        int[] expected = {1, 3};
        assertArrayEquals(expected, solution.twoSum(numbers, target));
    }

    @Test
    public void testTwoSum3() {
        int[] numbers = {-1, 0};
        int target = -1;
        int[] expected = {1, 2};
        assertArrayEquals(expected, solution.twoSum(numbers, target));
    }
}