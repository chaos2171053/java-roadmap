package org.example.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TwoSumTest {

    @Test
    public void testTwoSum_NormalCase() {
        TwoSum solution = new TwoSum();

        // 测试用例1：正常情况
        int[] nums = {1, 3, 5, 6};
        int target = 9;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(3, 6));
        List<List<Integer>> result = solution.twoSum(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testTwoSum_TargetZero() {
        TwoSum solution = new TwoSum();

        // 测试用例2：目标和为0
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(0, 0));
        List<List<Integer>> result = solution.twoSum(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testTwoSum_TwoElements() {
        TwoSum solution = new TwoSum();

        // 测试用例3：只有两个元素，能够凑出目标和
        int[] nums = {2, 7};
        int target = 9;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(2, 7));
        List<List<Integer>> result = solution.twoSum(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testTwoSum_MultiplePairs() {
        TwoSum solution = new TwoSum();

        // 测试用例4：多对儿元素之和都等于目标和
        int[] nums = {1, 2, 3, 4, 5, 6};
        int target = 7;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 6), Arrays.asList(2, 5), Arrays.asList(3, 4));
        List<List<Integer>> result = solution.twoSum(nums, target);
        assertEquals(expected, result);
    }
}
