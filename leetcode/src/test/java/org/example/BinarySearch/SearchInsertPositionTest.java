package org.example.BinarySearch;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SearchInsertPositionTest {

    private final SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

    @Test
    public void testSearchInsertExample1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        assertEquals(2, searchInsertPosition.searchInsert(nums, target));
    }

    @Test
    public void testSearchInsertExample2() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        assertEquals(1, searchInsertPosition.searchInsert(nums, target));
    }

    @Test
    public void testSearchInsertExample3() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        assertEquals(4, searchInsertPosition.searchInsert(nums, target));
    }

    @Test
    public void testSearchInsertExample4() {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        assertEquals(0, searchInsertPosition.searchInsert(nums, target));
    }

    @Test
    public void testSearchInsertExample5() {
        int[] nums = {1, 3, 5, 6};
        int target = 4;
        assertEquals(2, searchInsertPosition.searchInsert(nums, target));
    }

    @Test
    public void testSearchInsertExample6() {
        int[] nums = {1};
        int target = 1;
        assertEquals(0, searchInsertPosition.searchInsert(nums, target));
    }

    @Test
    public void testSearchInsertExample7() {
        int[] nums = {1};
        int target = 2;
        assertEquals(1, searchInsertPosition.searchInsert(nums, target));
    }
}
