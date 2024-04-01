package org.example.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinChangeTest2 {
    @Test
    public void testCoinChange() {
        int[] coins1 = {1, 2, 5};
        int amount1 = 5;
        assertEquals(4, CoinChange2.coinChange(coins1, amount1));

        int[] coins2 = {2};
        int amount2 = 3;
        assertEquals(0, CoinChange2.coinChange(coins2, amount2));

        int[] coins3 = {10};
        int amount3 = 10;
        assertEquals(1, CoinChange2.coinChange(coins3, amount3));
    }
}
