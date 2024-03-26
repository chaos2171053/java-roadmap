package org.example.dp;

public class Fibonacci {
    //    public int fib(int n) {
////        if (n == 1 || n == 2) return 1;
////        return fib(n - 1) + fib(n - 2);
//        int[] memo = new int[n+1];
//        return dp(memo,n);
//    }
//
//    private int dp(int[] memo, int n) {
//        if (n == 1 || n == 2) return 1;
//        if(memo[n]!=0){
//            return memo[n];
//        }
//        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
//        return memo[n];
//    }
//    int fib(int N) {
//        if (N == 0) return 0;
//        int[] dp = new int[N + 1];
//        // base case
//        dp[0] = 0;
//        dp[1] = 1;
//        // 状态转移
//        for (int i = 2; i <= N; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//
//        return dp[N];
//    }
    int fib(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = dp_i_1 + dp_i_2;
            // 滚动更新
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }

}
