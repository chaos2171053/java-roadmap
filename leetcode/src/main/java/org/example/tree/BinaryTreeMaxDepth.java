package org.example.tree;


//给定一个二叉树 root ，返回其最大深度。
//
//二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
//
//
//
//示例 1：
//
//
//
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：3
//示例 2：
//
//输入：root = [1,null,2]
//输出：2
public class BinaryTreeMaxDepth {

    // 记录最大深度
    static int res = 0;
    static int depth = 0;

    // 主函数
    static int maxDepth(TreeNode root) {
        res = 0;
        depth =0;
        traverse(root);
        return res;
    }

    // 二叉树遍历框架
    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
