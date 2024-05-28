package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathSumNumbersTest {
    @Test
    public void testSumNumbers_Sample1() {
        // 构建示例1的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 调用 PathSumNumbers 中的 sumNumbers 方法
        int result = PathSumNumbers.sumNumbers(root);

        // 验证结果是否符合预期
        assertEquals(25, result);
    }

    @Test
    public void testSumNumbers_Sample2() {
        // 构建示例2的二叉树
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        // 调用 PathSumNumbers 中的 sumNumbers 方法
        int result = PathSumNumbers.sumNumbers(root);

        // 验证结果是否符合预期
        assertEquals(1026, result);
    }

    @Test
    public void testSumNumbers_EmptyTree() {
        // 构建空二叉树
        TreeNode root = null;

        // 调用 PathSumNumbers 中的 sumNumbers 方法
        int result = PathSumNumbers.sumNumbers(root);

        // 验证结果是否符合预期
        assertEquals(0, result);
    }

    @Test
    public void testSumNumbers_SingleNodeTree() {
        // 构建只有一个节点的二叉树
        TreeNode root = new TreeNode(0);

        // 调用 PathSumNumbers 中的 sumNumbers 方法
        int result = PathSumNumbers.sumNumbers(root);

        // 验证结果是否符合预期
        assertEquals(0, result);
    }

    @Test
    public void testSumNumbers_ComplexTree() {
        // 构建更复杂的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 调用 PathSumNumbers 中的 sumNumbers 方法
        int result = PathSumNumbers.sumNumbers(root);

        // 验证结果是否符合预期
        // 124 + 125 + 136 + 137 = 522
        assertEquals(522, result);
    }
}
