package org.example.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SpiralOrderTest {

    private final SpiralOrder solution = new SpiralOrder();

    @Test
    public void testSpiralOrder1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), solution.spiralOrder(matrix));
    }

    @Test
    public void testSpiralOrder2() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), solution.spiralOrder(matrix));
    }

    @Test
    public void testSpiralOrder3() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        assertEquals(Arrays.asList(1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8), solution.spiralOrder(matrix));
    }
}
