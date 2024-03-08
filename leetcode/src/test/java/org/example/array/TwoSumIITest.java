package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TwoSumIITest {

    @Test
    public void testTwoSumII() {
        TwoSumII twoSum = new TwoSumII();

        // 测试用例1：普通情况，有唯一解
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = {1, 2}; // 2 + 7 = 9
        int[] result1 = twoSum.twoSum(numbers1, target1);
        assertArrayEquals(expected1, result1);

        // 测试用例2：普通情况，有唯一解
        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        int[] expected2 = {1, 3}; // 2 + 4 = 6
        int[] result2 = twoSum.twoSum(numbers2, target2);
        assertArrayEquals(expected2, result2);

        // 测试用例3：负数情况，有唯一解
        int[] numbers3 = {-1, 0};
        int target3 = -1;
        int[] expected3 = {1, 2}; // -1 + 0 = -1
        int[] result3 = twoSum.twoSum(numbers3, target3);
        assertArrayEquals(expected3, result3);
    }
}

