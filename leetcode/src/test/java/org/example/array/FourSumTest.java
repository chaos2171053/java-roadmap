package org.example.array;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FourSumTest {

    @Test
    public void testFourSum_NormalCase() {
        FourSum solution = new FourSum();

        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-2, -1, 1, 2),
                Arrays.asList(-2, 0, 0, 2),
                Arrays.asList(-1, 0, 0, 1)
        );
        List<List<Integer>> result = solution.fourSum(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testFourSum_EmptyInput() {
        FourSum solution = new FourSum();

        int[] nums = {};
        int target = 0;
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = solution.fourSum(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testFourSum_FoundQuadruplet() {
        FourSum solution = new FourSum();

        int[] nums = {1, 2, 3, 4};
        int target = 10;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 2, 3, 4));
        List<List<Integer>> result = solution.fourSum(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testFourSum_NoQuadruplet() {
        FourSum solution = new FourSum();

        int[] nums = {1, 2, 3, 4};
        int target = 6;
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = solution.fourSum(nums, target);
        assertEquals(expected, result);
    }

    // 其他测试用例...
}

