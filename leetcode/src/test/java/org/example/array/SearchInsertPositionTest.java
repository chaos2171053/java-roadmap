package org.example.array;

import junit.framework.TestCase;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SearchInsertPositionTest {

    @Test
    public void testSearchInsert_TargetExists() {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int expected = 2; // 目标值5存在于数组中，其索引为2
        int result = searchInsertPosition.searchInsert(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearchInsert_TargetDoesNotExist() {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int expected = 1; // 目标值2不存在于数组中，插入后会在索引1处
        int result = searchInsertPosition.searchInsert(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearchInsert_EmptyArray() {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {};
        int target = 5;
        int expected = 0; // 数组为空，插入后会在索引0处
        int result = searchInsertPosition.searchInsert(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearchInsert_InsertAtEnd() {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int expected = 4; // 目标值7大于数组中的所有元素，插入后会在索引4处
        int result = searchInsertPosition.searchInsert(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearchInsert_InsertAtBeginning() {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int expected = 0; // 目标值0小于数组中的所有元素，插入后会在索引0处
        int result = searchInsertPosition.searchInsert(nums, target);
        assertEquals(expected, result);
    }
}
