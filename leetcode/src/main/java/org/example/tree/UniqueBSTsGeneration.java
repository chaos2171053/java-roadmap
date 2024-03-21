package org.example.tree;

import java.util.LinkedList;
import java.util.List;
// 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
// 可以按 任意顺序 返回答案。
public class UniqueBSTsGeneration {
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        // 构造闭区间 [1, n] 组成的 BST 
        return build(1, n);

    }

    private static List<TreeNode> build(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (low > high) {
            res.add(null);
            return res;
        }
        for (int i = low; i <= high; i++) {
            // 2、递归构造出左右子树的所有合法 BST。
            List<TreeNode> leftTree = build(low, i - 1);
            List<TreeNode> rightTree = build(i + 1, high);
            // 3、给 root 节点穷举所有左右子树的组合。
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
