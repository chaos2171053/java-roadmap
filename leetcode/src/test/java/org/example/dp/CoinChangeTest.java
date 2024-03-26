package org.example.dp;

import org.junit.Test;
import static org.junit.Assert.*;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
//计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
//你可以认为每种硬币的数量是无限的。
public class CoinChangeTest {

    @Test
    public void testCoinChange() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(coins, amount);
        assertEquals(3, result);
    }
}
