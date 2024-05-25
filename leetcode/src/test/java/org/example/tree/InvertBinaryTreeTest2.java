package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvertBinaryTreeTest2 {
    @Test
    public void testInvertTree_Sample1() {
        // 构建示例1的二叉树
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // 调用 InvertBinaryTree2 中的 invertTree 方法
        TreeNode result = InvertBinaryTree2.invertTree(root);

        // 验证翻转后的树是否正确
        assertEquals(4, result.val);
        assertEquals(7, result.left.val);
        assertEquals(2, result.right.val);
        assertEquals(9, result.left.left.val);
        assertEquals(6, result.left.right.val);
        assertEquals(3, result.right.left.val);
        assertEquals(1, result.right.right.val);
    }

    @Test
    public void testInvertTree_Sample2() {
        // 构建示例2的二叉树
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // 调用 InvertBinaryTree2 中的 invertTree 方法
        TreeNode result = InvertBinaryTree2.invertTree(root);

        // 验证翻转后的树是否正确
        assertEquals(2, result.val);
        assertEquals(3, result.left.val);
        assertEquals(1, result.right.val);
    }

    @Test
    public void testInvertTree_Sample3() {
        // 构建示例3的空二叉树
        TreeNode root = null;

        // 调用 InvertBinaryTree2 中的 invertTree 方法
        TreeNode result = InvertBinaryTree2.invertTree(root);

        // 验证翻转后的树是否正确
        assertEquals(null, result);
    }
}
