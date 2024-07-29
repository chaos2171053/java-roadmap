package org.example.backtracking;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PermutationsTest {

    @Test
    public void testPermuteWithThreeElements() {
        Permutations perm = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        );
        List<List<Integer>> result = perm.permute(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    public void testPermuteWithTwoElements() {
        Permutations perm = new Permutations();
        int[] nums = {0, 1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 0)
        );
        List<List<Integer>> result = perm.permute(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    public void testPermuteWithOneElement() {
        Permutations perm = new Permutations();
        int[] nums = {1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1)
        );
        List<List<Integer>> result = perm.permute(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }
}
