package org.example.dp;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumPathSumTest {
    @Test
    public void testExample1() {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        assertEquals(7, solution.minPathSum(grid));
    }

    @Test
    public void testExample2() {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        assertEquals(12, solution.minPathSum(grid));
    }

    @Test
    public void testSingleElement() {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] grid = {{1}};
        assertEquals(1, solution.minPathSum(grid));
    }

    @Test
    public void testSmallGrid() {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] grid = {{1, 2}, {1, 1}};
        assertEquals(3, solution.minPathSum(grid));
    }

    @Test
    public void testAnotherCase() {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] grid = {{1, 2, 5}, {3, 2, 1}};
        assertEquals(6, solution.minPathSum(grid));
    }
}

