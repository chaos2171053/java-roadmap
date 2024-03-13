package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LeftBoundBinarySearchTest {

    @Test
    public void testSearch_LeftBoundExist() {
        LeftBoundBinarySearch solution = new LeftBoundBinarySearch();

        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int expected = 1;
        int result = solution.search(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearch_LeftBoundNotExist() {
        LeftBoundBinarySearch solution = new LeftBoundBinarySearch();

        int[] nums = {1, 2, 3, 4, 5};
        int target = 6;
        int expected = -1;
        int result = solution.search(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearch_LeftBoundEmptyArray() {
        LeftBoundBinarySearch solution = new LeftBoundBinarySearch();

        int[] nums = new int[0];
        int target = 5;
        int expected = -1;
        int result = solution.search(nums, target);
        assertEquals(expected, result);
    }
}

