package org.example.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsack() {
        int[] wt = {1, 2, 3};
        int[] val = {6, 10, 12};
        int W = 5;
        assertEquals(22, Knapsack.knapsack(W, wt, val));

         wt = new int[]{1, 2, 3, 4, 5};
         val = new int[]{10, 40, 30, 50, 60};
        W = 10;
        assertEquals(130, Knapsack.knapsack(W, wt, val));

        wt = new int[]{2, 2, 4, 5};
        val = new int[]{3, 7, 2, 9};
        W = 10;
        assertEquals(19, Knapsack.knapsack(W, wt, val));
    }
}