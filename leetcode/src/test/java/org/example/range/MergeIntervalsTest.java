package org.example.range;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeIntervalsTest {
    @Test
    public void testMergeIntervals_Example1() {
        MergeIntervals solution = new MergeIntervals();

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expected = {{1,6},{8,10},{15,18}};

        int[][] result = solution.merge(intervals);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeIntervals_Example2() {
        MergeIntervals solution = new MergeIntervals();

        int[][] intervals = {{1,4},{4,5}};
        int[][] expected = {{1,5}};

        int[][] result = solution.merge(intervals);

        assertArrayEquals(expected, result);
    }
}
