package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeMaxDepthTest {
    @Test
    public void testMaxDepth_Sample1() {
        // 构建示例1的二叉树并计算最大深度
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 调用 BinaryTreeMaxDepth 中的 maxDepth 方法
        int result = BinaryTreeMaxDepth.maxDepth(root);

        // 断言
        assertEquals(3, result);
    }

    @Test
    public void testMaxDepth_Sample2() {
        // 构建示例2的二叉树并计算最大深度
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        // 调用 BinaryTreeMaxDepth 中的 maxDepth 方法
        int result = BinaryTreeMaxDepth.maxDepth(root);
        System.out.println("result :"+result);

        // 断言
        assertEquals(2, result);
    }
}
