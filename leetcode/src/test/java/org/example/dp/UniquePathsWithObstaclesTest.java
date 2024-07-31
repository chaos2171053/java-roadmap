package org.example.dp;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniquePathsWithObstaclesTest {
    @Test
    public void testExample1() {
        UniquePathsWithObstacles solution = new UniquePathsWithObstacles();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assertEquals(2, solution.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    public void testExample2() {
        UniquePathsWithObstacles solution = new UniquePathsWithObstacles();
        int[][] obstacleGrid = {{0, 1}, {0, 0}};
        assertEquals(1, solution.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    public void testSingleCellNoObstacle() {
        UniquePathsWithObstacles solution = new UniquePathsWithObstacles();
        int[][] obstacleGrid = {{0}};
        assertEquals(1, solution.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    public void testSingleCellWithObstacle() {
        UniquePathsWithObstacles solution = new UniquePathsWithObstacles();
        int[][] obstacleGrid = {{1}};
        assertEquals(0, solution.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    public void testNoObstacles() {
        UniquePathsWithObstacles solution = new UniquePathsWithObstacles();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertEquals(6, solution.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    public void testObstaclesInFirstRow() {
        UniquePathsWithObstacles solution = new UniquePathsWithObstacles();
        int[][] obstacleGrid = {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        assertEquals(3, solution.uniquePathsWithObstacles(obstacleGrid));
    }
}

