package org.example.range;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertIntervalTest {
    @Test
    public void testInsertInterval_Example1() {
        InsertInterval solution = new InsertInterval();

        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] expected = {{1,5},{6,9}};

        int[][] result = solution.insert(intervals, newInterval);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertInterval_Example2() {
        InsertInterval solution = new InsertInterval();

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] expected = {{1,2},{3,10},{12,16}};

        int[][] result = solution.insert(intervals, newInterval);

        assertArrayEquals(expected, result);
    }
}
