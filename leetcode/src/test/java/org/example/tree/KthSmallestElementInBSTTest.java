package org.example.tree;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthSmallestElementInBSTTest {

    @Test
    public void testKthSmallest() {
        // 创建一个二叉搜索树示例
        //       3
        //      / \
        //     1   4
        //      \
        //       2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        // 测试查找第 1 个最小元素
        assertEquals(1, KthSmallestElementInBST.kthSmallest(root, 1));

        // 测试查找第 2 个最小元素
        assertEquals(2, KthSmallestElementInBST.kthSmallest(root, 2));

        // 测试查找第 3 个最小元素
        assertEquals(3, KthSmallestElementInBST.kthSmallest(root, 3));

        // 测试查找第 4 个最小元素
        assertEquals(4, KthSmallestElementInBST.kthSmallest(root, 4));
    }
    @Test
    public void testKthSmallest1() {
        // 创建一个二叉搜索树示例
        //       4
        //      / \
        //     2   5
        //      \
        //       3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);

        // 测试查找第 1 个最小元素
        assertEquals(2, KthSmallestElementInBST.kthSmallest(root, 1));
    }
}

