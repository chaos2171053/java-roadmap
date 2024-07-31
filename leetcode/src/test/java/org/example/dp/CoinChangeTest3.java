package org.example.dp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CoinChangeTest3 {

    @Test
    public void testCoinChangeExample1() {
        CoinChange3 coinChange = new CoinChange3();
        int[] coins = {1, 2, 5};
        int amount = 11;
        assertEquals(3, coinChange.coinChange(coins, amount));
    }

    @Test
    public void testCoinChangeExample2() {
        CoinChange3 coinChange = new CoinChange3();
        int[] coins = {2};
        int amount = 3;
        assertEquals(-1, coinChange.coinChange(coins, amount));
    }

    @Test
    public void testCoinChangeExample3() {
        CoinChange3 coinChange = new CoinChange3();
        int[] coins = {1};
        int amount = 0;
        assertEquals(0, coinChange.coinChange(coins, amount));
    }

    @Test
    public void testCoinChangeSingleCoin() {
        CoinChange3 coinChange = new CoinChange3();
        int[] coins = {1};
        int amount = 2;
        assertEquals(2, coinChange.coinChange(coins, amount));
    }

    @Test
    public void testCoinChangeLargeAmount() {
        CoinChange3 coinChange = new CoinChange3();
        int[] coins = {1, 2, 5};
        int amount = 100;
        assertEquals(20, coinChange.coinChange(coins, amount));
    }
}
