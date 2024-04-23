package org.example.matrix;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class SetZeroesTest {

    private final SetZeroes setZeroes = new SetZeroes();

    @Test
    public void testSetZeroes1() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes.setZeroes(matrix);
        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testSetZeroes2() {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes.setZeroes(matrix);
        int[][] expected = {
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
        };
        assertArrayEquals(expected, matrix);
    }
}
