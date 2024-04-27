package org.example.hashmap;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContainsDuplicateIIUnitTest {
    @Test
    public void testContainsNearbyDuplicate_Example1() {
        ContainsDuplicateII solution = new ContainsDuplicateII();

        int[] nums = {1, 2, 3, 1};
        int k = 3;

        assertTrue(solution.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void testContainsNearbyDuplicate_Example2() {
        ContainsDuplicateII solution = new ContainsDuplicateII();

        int[] nums = {1, 0, 1, 1};
        int k = 1;

        assertTrue(solution.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void testContainsNearbyDuplicate_Example3() {
        ContainsDuplicateII solution = new ContainsDuplicateII();

        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;

        assertFalse(solution.containsNearbyDuplicate(nums, k));
    }
}
