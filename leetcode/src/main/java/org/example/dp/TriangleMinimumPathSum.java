package org.example.dp;

import java.util.List;

public class TriangleMinimumPathSum {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n-1).get(i);
        }
        // 从倒数第二层开始向上计算
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 对每个节点，选择其下方和右下方中较小的路径和，加上当前节点的值
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        // 返回顶层的最小路径和
        return dp[0];
    }
}
