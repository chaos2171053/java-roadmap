package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LowestCommonAncestorTest {
    @Test
    public void testLowestCommonAncestor_Sample1() {
        // 构建示例的二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // 定义要查找的两个节点
        TreeNode p = root.left;
        TreeNode q = root.right;

        // 计算最近公共祖先
        TreeNode result = LowestCommonAncestor.lowestCommonAncestor(root, p, q);

        // 验证结果
        assertEquals(root, result);
    }

    @Test
    public void testLowestCommonAncestor_Sample2() {
        // 构建示例的二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // 定义要查找的两个节点
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;

        // 计算最近公共祖先
        TreeNode result = LowestCommonAncestor.lowestCommonAncestor(root, p, q);

        // 验证结果
        assertEquals(root.left, result);
    }

    @Test
    public void testLowestCommonAncestor_Sample3() {
        // 构建示例的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        // 定义要查找的两个节点
        TreeNode p = root;
        TreeNode q = root.left;

        // 计算最近公共祖先
        TreeNode result = LowestCommonAncestor.lowestCommonAncestor(root, p, q);

        // 验证结果
        assertEquals(root, result);
    }
}
