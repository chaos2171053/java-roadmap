package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SameTreeTest {
    @Test
    public void testSameTree_Sample1() {
        // 构建示例1的两棵二叉树
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        // 调用 SameTree 中的 isSameTree 方法
        boolean result = SameTree.isSameTree(p, q);

        // 断言
        assertEquals(true, result);
    }

    @Test
    public void testSameTree_Sample2() {
        // 构建示例2的两棵二叉树
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        // 调用 SameTree 中的 isSameTree 方法
        boolean result = SameTree.isSameTree(p, q);

        // 断言
        assertEquals(false, result);
    }

    @Test
    public void testSameTree_Sample3() {
        // 构建示例3的两棵二叉树
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        // 调用 SameTree 中的 isSameTree 方法
        boolean result = SameTree.isSameTree(p, q);

        // 断言
        assertEquals(false, result);
    }
    @Test
    public void testSameTree_Custom() {
        // 构建自定义的两棵二叉树
        TreeNode p = new TreeNode(0);
        p.left = new TreeNode(-5);

        TreeNode q = new TreeNode(0);
        q.left = new TreeNode(-8);

        // 调用 SameTree 中的 isSameTree 方法
        boolean result = SameTree.isSameTree(p, q);

        // 断言
        assertEquals(false, result);
    }
}
