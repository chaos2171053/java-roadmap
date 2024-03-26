package org.example.dp;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxEnvelopesTest {

    @Test
    public void testMaxEnvelopes() {
        MaxEnvelopes solution = new MaxEnvelopes();

        int[][] envelopes1 = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        assertEquals(3, solution.maxEnvelopes(envelopes1));

        int[][] envelopes2 = {{1, 1}, {1, 1}, {1, 1}};
        assertEquals(1, solution.maxEnvelopes(envelopes2));

        int[][] envelopes3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {5, 5}, {6, 7}, {7, 8}};
        assertEquals(7, solution.maxEnvelopes(envelopes3));
    }
}
