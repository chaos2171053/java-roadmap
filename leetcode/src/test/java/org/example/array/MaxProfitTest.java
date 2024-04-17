package org.example.array;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxProfitTest {

    @Test
    public void testMaxProfit() {
        MaxProfitSolution solution = new MaxProfitSolution();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        assertEquals(7, solution.maxProfit(prices1));

        int[] prices2 = {1, 2, 3, 4, 5};
        assertEquals(4, solution.maxProfit(prices2));

        int[] prices3 = {7, 6, 4, 3, 1};
        assertEquals(0, solution.maxProfit(prices3));
    }
}
