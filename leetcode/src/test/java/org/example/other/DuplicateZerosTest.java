package org.example.other;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DuplicateZerosTest {

    @Test
    public void testDuplicateZeros() {
        DuplicateZeros solution = new DuplicateZeros();

        // Test case 1
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(arr1);
        assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, arr1);

        // Test case 2
        int[] arr2 = {1, 2, 3};
        solution.duplicateZeros(arr2);
        assertArrayEquals(new int[]{1, 2, 3}, arr2);

        // Test case 3
        int[] arr3 = {0, 0, 0};
        solution.duplicateZeros(arr3);
        assertArrayEquals(new int[]{0, 0, 0}, arr3);

        // Test case 4
        int[] arr4 = {1, 2, 0, 3, 0, 4};
        solution.duplicateZeros(arr4);
        assertArrayEquals(new int[]{1, 2, 0, 0, 3, 0}, arr4);
    }
}
