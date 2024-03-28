package org.example.dp;

import java.util.Arrays;

//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
//
//        字符串的一个 子序列 是指，通过删除一些字符（也可以不删除）且不干扰剩余字符相对位置形成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
//
//        题目保证数据存在答案。
//
//        示例 1：
//
//        输入：s = "rabbbit", t = "rabbit"
//        输出：3
//        解释：
//        如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//        (上箭头符号 ^ 表示选取的字母)
//        rabbbit
//        ^^^^ ^^
//        rabbbit
//        ^^ ^^^^
//        rabbbit
//        ^^^ ^^^
//
//        示例 2：
//
//        输入：s = "babgbag", t = "bag"
//        输出：5
//        解释：
//        如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
//        (上箭头符号 ^ 表示选取的字母)
//        babgbag
//        ^^ ^
//        babgbag
//        ^^ ^
//        babgbag
//        ^ ^^
//        babgbag
//        ^^^
//        babgbag
//        ^
public class DistinctSubsequences {
    // 备忘录
    int[][] memo;

    int numDistinct(String s, String t) {
        // 初始化备忘录为特殊值 -1
        memo = new int[s.length()][t.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s, 0, t, 0);
    }

    // 定义：s[i..] 的子序列中 t[j..] 出现的次数为 dp(s, i, t, j)
    int dp(String s, int i, String t, int j) {
        // base case 1
        if (j == t.length()) {
            return 1;
        }
        // base case 2
        if (s.length() - i < t.length() - j) {
            return 0;
        }
        // 查备忘录防止冗余计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        // 执行状态转移方程
        // 在 s[i..] 中寻找 k，使得 s[k] == t[j]
        for (int k = i; k < s.length(); k++) {
            if (s.charAt(k) == t.charAt(j)) {
                // 累加结果
                res += dp(s, k + 1, t, j + 1);
            }
        }
        // 存入备忘录
        memo[i][j] = res;
        return res;
    }
}
