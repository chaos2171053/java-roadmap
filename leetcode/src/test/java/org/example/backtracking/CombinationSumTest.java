package org.example.backtracking;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CombinationSumTest {

    @Test
    public void testCombinationSumWithExample1() {
        CombinationSum combSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 3),
                Arrays.asList(7)
        );
        List<List<Integer>> result = combSum.combinationSum(candidates, target);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    public void testCombinationSumWithExample2() {
        CombinationSum combSum = new CombinationSum();
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5)
        );
        List<List<Integer>> result = combSum.combinationSum(candidates, target);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    public void testCombinationSumWithExample3() {
        CombinationSum combSum = new CombinationSum();
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> expected = Arrays.asList();
        List<List<Integer>> result = combSum.combinationSum(candidates, target);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }
}
