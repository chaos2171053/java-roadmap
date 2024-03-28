package org.example.dp;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinFallingPathSumTest {

    @Test
    public void testMinFallingPathSum() {
        MinFallingPathSum solution = new MinFallingPathSum();

        int[][] matrix1 = {{2,1,3},{6,5,4},{7,8,9}};
        assertEquals(13, solution.minFallingPathSum(matrix1));

        int[][] matrix2 = {{-19,57},{-40,-5}};
        assertEquals(-59, solution.minFallingPathSum(matrix2));

        int[][] matrix3 = {{-48}};
        assertEquals(-48, solution.minFallingPathSum(matrix3));
    }
}
