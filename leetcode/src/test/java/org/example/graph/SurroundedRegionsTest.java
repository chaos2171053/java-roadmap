package org.example.graph;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SurroundedRegionsTest {
    @Test
    public void testSolve() {
        SurroundedRegions solution = new SurroundedRegions();

        char[][] board1 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] expected1 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution.solve(board1);
        assertArrayEquals(expected1, board1);

        char[][] board2 = {
                {'X'}
        };
        char[][] expected2 = {
                {'X'}
        };
        solution.solve(board2);
        assertArrayEquals(expected2, board2);

        char[][] board3 = {
                {'X', 'O'},
                {'O', 'X'}
        };
        char[][] expected3 = {
                {'X', 'O'},
                {'O', 'X'}
        };
        solution.solve(board3);
        assertArrayEquals(expected3, board3);

        // 添加更多测试用例以确保算法的正确性
    }
}
