package org.example.matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RotateImageTest {

    private final RotateImage rotateImage = new RotateImage();

    @Test
    public void testRotate1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateImage.rotate(matrix);
        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotate2() {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotateImage.rotate(matrix);
        int[][] expected = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        assertArrayEquals(expected, matrix);
    }
}
