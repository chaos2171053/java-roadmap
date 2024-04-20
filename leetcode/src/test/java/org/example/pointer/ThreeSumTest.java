package org.example.pointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThreeSumTest {
    private final ThreeSum solution = new ThreeSum();

    @Test
    public void testThreeSum1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    public void testThreeSum2() {
        int[] nums = {};
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }
}
