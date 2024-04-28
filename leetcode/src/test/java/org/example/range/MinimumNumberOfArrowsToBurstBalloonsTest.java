package org.example.range;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumNumberOfArrowsToBurstBalloonsTest {
    @Test
    public void testFindMinArrowShots_Example1() {
        MinimumNumberOfArrowsToBurstBalloons solution = new MinimumNumberOfArrowsToBurstBalloons();

        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int expected = 2;

        int result = solution.findMinArrowShots(points);

        assertEquals(expected, result);
    }

    @Test
    public void testFindMinArrowShots_Example2() {
        MinimumNumberOfArrowsToBurstBalloons solution = new MinimumNumberOfArrowsToBurstBalloons();

        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int expected = 4;

        int result = solution.findMinArrowShots(points);

        assertEquals(expected, result);
    }

    @Test
    public void testFindMinArrowShots_Example3() {
        MinimumNumberOfArrowsToBurstBalloons solution = new MinimumNumberOfArrowsToBurstBalloons();

        int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int expected = 2;

        int result = solution.findMinArrowShots(points);

        assertEquals(expected, result);
    }
}
