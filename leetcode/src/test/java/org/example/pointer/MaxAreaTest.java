package org.example.pointer;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAreaTest {

    private final MaxArea solution = new MaxArea();

    @Test
    public void testMaxArea1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected = 49;
        assertEquals(expected, solution.maxArea(height));
    }

    @Test
    public void testMaxArea2() {
        int[] height = {1, 1};
        int expected = 1;
        assertEquals(expected, solution.maxArea(height));
    }
}