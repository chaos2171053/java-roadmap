package org.example.hashmap;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
//你可以按任意顺序返回答案。
//
//
//
//示例 1：
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//示例 2：
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//示例 3：
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
public class TwoSumTest {

    @Test
    public void testTwoSum_Example1() {
        TwoSum solution = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testTwoSum_Example2() {
        TwoSum solution = new TwoSum();

        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testTwoSum_Example3() {
        TwoSum solution = new TwoSum();

        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {0, 1};

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }
}

