package org.example.dp;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinPathSumTest {

    @Test
    public void testMinPathSum() {
        int[][] grid1 = {{1,3,1},{1,5,1},{4,2,1}};
        assertEquals(7, MinPathSum.minPathSum(grid1));

        int[][] grid2 = {{1,2,3},{4,5,6}};
        assertEquals(12, MinPathSum.minPathSum(grid2));
    }
}
