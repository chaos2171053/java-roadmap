package org.example.tree;
//
//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
//差值是一个正数，其数值等于两值之差的绝对值。
//
//
//
//示例 1：
//
//
//输入：root = [4,2,6,1,3]
//输出：1
//示例 2：
//
//
//输入：root = [1,0,48,null,null,12,49]
//输出：1
//
//
//提示：
//
//树中节点的数目范围是 [2, 104]
//0 <= Node.val <= 105
public class MinDiffInBST {
    private int  prev;
    private int minDiff;
    public int minDiffInBST(TreeNode root) {
        prev = -1;
        minDiff = Integer.MAX_VALUE;
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse left subtree
        inorderTraversal(root.left);

        // Process current node
        if (prev != -1) {
            minDiff = Math.min(minDiff, root.val - prev);
        }
        prev = root.val;

        // Traverse right subtree
        inorderTraversal(root.right);
    }
}
