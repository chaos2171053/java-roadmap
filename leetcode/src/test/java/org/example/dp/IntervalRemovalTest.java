package org.example.dp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IntervalRemovalTest {

    @Test
    public void testIntervalRemoval() {
        // Test case 1
        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        assertEquals(1, IntervalRemoval.minRemoveToMakeNonOverlapping(intervals1));

        // Test case 2
        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        assertEquals(2, IntervalRemoval.minRemoveToMakeNonOverlapping(intervals2));

        // Test case 3
        int[][] intervals3 = {{1, 2}, {2, 3}};
        assertEquals(0, IntervalRemoval.minRemoveToMakeNonOverlapping(intervals3));
    }
}

