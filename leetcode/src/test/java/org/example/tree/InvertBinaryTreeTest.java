package org.example.tree;


import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class InvertBinaryTreeTest {

    @Test
    public void testInvertTree() {
        // 创建一个二叉树示例
        //        4
        //       / \
        //      2   7
        //     / \ / \
        //    1  3 6  9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // 翻转二叉树
        TreeNode invertedRoot = InvertBinaryTree.invertTree(root);

        // 期望的翻转结果
        //        4
        //       / \
        //      7   2
        //     / \ / \
        //    9  6 3  1
        TreeNode expectedRoot = new TreeNode(4);
        expectedRoot.left = new TreeNode(7);
        expectedRoot.right = new TreeNode(2);
        expectedRoot.left.left = new TreeNode(9);
        expectedRoot.left.right = new TreeNode(6);
        expectedRoot.right.left = new TreeNode(3);
        expectedRoot.right.right = new TreeNode(1);

        // 检查翻转后的树是否与预期结果相同
        assertTrue(isSameTree(expectedRoot, invertedRoot));
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    @Test
    public void testInvertTree2() {
        // 创建一个二叉树示例
        //        4
        //       / \
        //      2   7
        //     / \ / \
        //    1  3 6  9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // 翻转二叉树
        TreeNode invertedRoot = InvertBinaryTree.invertTree2(root);

        // 期望的翻转结果
        //        4
        //       / \
        //      7   2
        //     / \ / \
        //    9  6 3  1
        TreeNode expectedRoot = new TreeNode(4);
        expectedRoot.left = new TreeNode(7);
        expectedRoot.right = new TreeNode(2);
        expectedRoot.left.left = new TreeNode(9);
        expectedRoot.left.right = new TreeNode(6);
        expectedRoot.right.left = new TreeNode(3);
        expectedRoot.right.right = new TreeNode(1);

        // 检查翻转后的树是否与预期结果相同
        assertTrue(isSameTree(expectedRoot, invertedRoot));
    }
}


