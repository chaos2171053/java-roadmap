package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathMaxSumTest {
    @Test
    public void testMaxPathSum_Sample1() {
        // 构建示例1的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 调用 PathMaxSum 中的 maxPathSum 方法
        int result = PathMaxSum.maxPathSum(root);

        // 验证结果是否符合预期
        assertEquals(6, result);
    }

    @Test
    public void testMaxPathSum_Sample2() {
        // 构建示例2的二叉树
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 调用 PathMaxSum 中的 maxPathSum 方法
        int result = PathMaxSum.maxPathSum(root);

        // 验证结果是否符合预期
        assertEquals(42, result);
    }
}
