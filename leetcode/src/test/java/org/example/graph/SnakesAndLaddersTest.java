package org.example.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SnakesAndLaddersTest {
    private SnakesAndLadders solution = new SnakesAndLadders();

    @Test
    public void testExample1() {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        assertEquals(4, solution.snakesAndLadders(board));
    }

    @Test
    public void testExample2() {
        int[][] board = {
                {-1, -1},
                {-1, 3}
        };
        assertEquals(1, solution.snakesAndLadders(board));
    }

    @Test
    public void testNoSnakesOrLadders() {
        int[][] board = {
                {-1, -1, -1},
                {-1, -1, -1},
                {-1, -1, -1}
        };
        assertEquals(2, solution.snakesAndLadders(board));
    }



}
