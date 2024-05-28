package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompleteBinaryTreeCountTest {
    @Test
    public void testCountNodes_Sample1() {
        // 构建示例的完全二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        // 计算节点个数
        int count = CompleteBinaryTreeCount.countNodes(root);

        // 验证结果
        assertEquals(6, count);
    }

    @Test
    public void testCountNodes_EmptyTree() {
        // 构建空树
        TreeNode root = null;

        // 计算节点个数
        int count = CompleteBinaryTreeCount.countNodes(root);

        // 验证结果
        assertEquals(0, count);
    }

    @Test
    public void testCountNodes_SingleNodeTree() {
        // 构建只有一个节点的完全二叉树
        TreeNode root = new TreeNode(1);

        // 计算节点个数
        int count = CompleteBinaryTreeCount.countNodes(root);

        // 验证结果
        assertEquals(1, count);
    }
}
