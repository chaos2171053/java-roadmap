package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SymmetricTreeTest {
    @Test
    public void testIsSymmetric_Recursive_Sample1() {
        // 构建示例1的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // 调用 SymmetricTree 中的 isSymmetric 方法（递归）
        boolean result = SymmetricTree.isSymmetricRecursive(root);

        // 断言
        assertEquals(true, result);
    }

    @Test
    public void testIsSymmetric_Recursive_Sample2() {
        // 构建示例2的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        // 调用 SymmetricTree 中的 isSymmetric 方法（递归）
        boolean result = SymmetricTree.isSymmetricRecursive(root);

        // 断言
        assertEquals(false, result);
    }

    @Test
    public void testIsSymmetric_Iterative_Sample1() {
        // 构建示例1的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // 调用 SymmetricTree 中的 isSymmetric 方法（迭代）
        boolean result = SymmetricTree.isSymmetricIterative(root);

        // 断言
        assertEquals(true, result);
    }

    @Test
    public void testIsSymmetric_Iterative_Sample2() {
        // 构建示例2的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        // 调用 SymmetricTree 中的 isSymmetric 方法（迭代）
        boolean result = SymmetricTree.isSymmetricIterative(root);

        // 断言
        assertEquals(false, result);
    }
}
