package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

// 给你一个二叉树的根节点 root ， 检查它是否轴对称。
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
public class SymmetricTree {
    // 递归
    public static boolean isSymmetricRecursive(TreeNode root) {
        if(root ==null){
            return false;
        }
        return isMirror(root.left,root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if(left==null && right==null){
            return true;
        }
        if(left==null|| right==null){
            return  false;
        }
        return  (left.val==right.val)&& isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    // 迭代
    public static boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }

            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }

        return true;
    }
}
