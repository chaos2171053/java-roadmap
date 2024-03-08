package org.example.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ThreeSumTest {

    @Test
    public void testThreeSum_ExistTriplet() {
        ThreeSum solution = new ThreeSum();

        // 测试用例1：存在满足条件的三元组
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testThreeSum_NotExistTriplet() {
        ThreeSum solution = new ThreeSum();

        // 测试用例2：不存在满足条件的三元组
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testThreeSum_EmptyArray() {
        ThreeSum solution = new ThreeSum();

        // 测试用例3：空数组
        int[] nums = {};
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testThreeSum_ShortArray() {
        ThreeSum solution = new ThreeSum();

        // 测试用例4：数组长度小于 3
        int[] nums = {1, 2};
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected, result);
    }
}


