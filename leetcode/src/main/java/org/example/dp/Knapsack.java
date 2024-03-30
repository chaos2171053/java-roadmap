package org.example.dp;


//给定一个背包容量 W 和 N 个物品，每个物品有重量 wt[i] 和价值 val[i]。
//现在要将这些物品放入背包中，每个物品只能选择放入一次，求在不超过背包容量的情况下，能够装入背包的物品的最大总价值。
public class Knapsack {
    public static int knapsack(int W, int[] wt, int[] val) {
        int N = wt.length;
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(
                            dp[i - 1][w - wt[i - 1]] + val[i - 1],
                            dp[i - 1][w]
                    );
                }
            }
        }
        return dp[N][W];
    }

}
