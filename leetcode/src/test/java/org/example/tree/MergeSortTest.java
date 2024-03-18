package org.example.tree;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSort_NormalCase() {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};
        testSort(arr, expected);
    }

    @Test
    public void testMergeSort_EmptyArray() {
        int[] arr = {};
        int[] expected = {};
        testSort(arr, expected);
    }

    @Test
    public void testMergeSort_SingleElementArray() {
        int[] arr = {5};
        int[] expected = {5};
        testSort(arr, expected);
    }

    @Test
    public void testMergeSort_ReverseArray() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        testSort(arr, expected);
    }

    private void testSort(int[] arr, int[] expected) {
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
}


