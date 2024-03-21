package org.example.tree;

// 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
public class UniqueBSTs {
    static int[][] memo;

    public static int numTrees(int high) {
        memo = new int[high + 1][high + 1];

        return count(1, high);
    }

    private static int count(int low, int high) {
        if (low > high) {
            return 1;
        }

        if (memo[low][high] != 0) {
            return memo[low][high];
        }
        int res = 0;
        for (int i = low; i <= high; i++) {
            // i 的值作为根节点 root
            int left = count(low, i - 1);
            int right = count(i + 1, high);
            // 左右子树的组合数乘积是 BST 的总数
            res += left * right;
        }

        memo[low][high] = res;
        return res;
    }
}
