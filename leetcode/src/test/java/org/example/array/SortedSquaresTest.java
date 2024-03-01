package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class SortedSquaresTest {

    @Test
    public void testSortedSquares_NormalCase() {
        SortedSquares sortedSquares = new SortedSquares();
        int[] nums = {-4, -1, 0, 3, 10};
        int[] expected = {0, 1, 9, 16, 100}; // 平方后按非递减顺序排列的数组
        int[] result = sortedSquares.sortedSquares(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortedSquares_AllPositiveNumbers() {
        SortedSquares sortedSquares = new SortedSquares();
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 4, 9, 16, 25}; // 平方后按非递减顺序排列的数组
        int[] result = sortedSquares.sortedSquares(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortedSquares_AllNegativeNumbers() {
        SortedSquares sortedSquares = new SortedSquares();
        int[] nums = {-5, -4, -3, -2, -1};
        int[] expected = {1, 4, 9, 16, 25}; // 平方后按非递减顺序排列的数组
        int[] result = sortedSquares.sortedSquares(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortedSquares_MixedNumbers() {
        SortedSquares sortedSquares = new SortedSquares();
        int[] nums = {-7, -3, 1, 5};
        int[] expected = {1, 9, 25, 49}; // 平方后按非递减顺序排列的数组
        int[] result = sortedSquares.sortedSquares(nums);
        assertArrayEquals(expected, result);
    }
}

