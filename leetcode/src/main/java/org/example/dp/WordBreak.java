package org.example.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//
//注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
public class WordBreak {
    // 用哈希集合方便快速判断是否存在
    static HashSet<String> wordDict;
    // 备忘录，-1 代表未计算，0 代表无法凑出，1 代表可以凑出
    static  int[] memo;

    // 主函数
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 转化为哈希集合，快速判断元素是否存在
        wordDict = (List<String>) new HashSet<>(wordDict);
        // 备忘录初始化为 -1
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, 0);
    }

    // 定义：s[i..] 是否能够被拼出
    public static boolean dp(String s, int i) {
        // base case
        if (i == s.length()) {
            return true;
        }
        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] == 0 ? false : true;
        }

        // 遍历 s[i..] 的所有前缀
        for (int len = 1; i + len <= s.length(); len++) {
            // 看看哪些前缀存在 wordDict 中
            String prefix = s.substring(i, i + len);
            if (wordDict.contains(prefix)) {
                // 找到一个单词匹配 s[i..i+len)
                // 只要 s[i+len..] 可以被拼出，s[i..] 就能被拼出
                boolean subProblem = dp(s, i + len);
                if (subProblem == true) {
                    memo[i] = 1;
                    return true;
                }
            }
        }
        // s[i..] 无法被拼出
        memo[i] = 0;
        return false;
    }
}
