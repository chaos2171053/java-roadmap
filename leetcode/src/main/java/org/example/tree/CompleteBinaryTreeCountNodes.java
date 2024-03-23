package org.example.tree;

//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
// 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
public class CompleteBinaryTreeCountNodes {
    public static int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        // 沿最左侧和最右侧分别计算高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右侧计算的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int)Math.pow(2, hl) - 1;
        }
        // 如果左右侧的高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
