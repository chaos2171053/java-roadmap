package org.example.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfIslandsTest {
    @Test
    public void testNumberOfIslands() {
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        // 创建 NumberOfIslands 实例并进行测试
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        assertEquals(1, numberOfIslands.numIslands(grid1));

        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        // 创建 NumberOfIslands 实例并进行测试
        assertEquals(3, numberOfIslands.numIslands(grid2));
    }
}
