package org.example.other;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountCoveredPointsTests {

    @Test
    public void testExample1() {
        CoverageCounter counter = new CoverageCounter();
        int[][] nums = {{3, 6}, {1, 5}, {4, 7}};
        int expected = 7;
        int result = counter.countCoveredPoints(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testExample2() {
        CoverageCounter counter = new CoverageCounter();
        int[][] nums = {{1, 3}, {5, 8}};
        int expected = 7;
        int result = counter.countCoveredPoints(nums);
        assertEquals(expected, result);
    }

    // Add more test cases as needed

}

