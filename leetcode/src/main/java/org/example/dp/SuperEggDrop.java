package org.example.dp;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop {
    public static Object superEggDrop(int K, int N) {
        Map<String, Integer> memo = new HashMap<>();
        return dp(K, N, memo);
    }
    public static int dp(int K, int N, Map<String, Integer> memo) {
        // base case
        if (K == 1) return N;
        if (N == 0) return 0;
        // 避免重复计算
        String key = K + "," + N;
        if (memo.containsKey(key)) return memo.get(key);

        int res = Integer.MAX_VALUE;
        // 穷举所有可能的选择
        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(dp(K, N - i, memo), dp(K - 1, i - 1, memo)) + 1);
        }
        // 记入备忘录
        memo.put(key, res);
        return res;
    }
}
