package org.example.tree;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


// 遍历二叉树计算答案的思路
// 二叉树中用遍历思路解题时函数签名一般是 void traverse(...)，
// 没有返回值，靠更新外部变量来计算结果.
public class MaxDepthOfBinaryTreeTest {

    @Test
    public void testMaxDepth() {
        // 创建一个二叉树示例
        //        3
        //       / \
        //      9  20
        //        /  \
        //       15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 期望的最大深度为3，因为最长路径为3->20->15
        int expectedDepth = 3;
        int actualDepth = MaxDepthOfBinaryTree.maxDepth(root);
        assertEquals(expectedDepth, actualDepth);
    }

    @Test
    public void testMaxDepth2(){
        // 创建一个二叉树示例
        //        3
        //       / \
        //      9  20
        //        /  \
        //       15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 期望的最大深度为3，因为最长路径为3->20->15
        int expectedDepth = 3;
        int actualDepth = MaxDepthOfBinaryTree.maxDepth2(root);
        assertEquals(expectedDepth, actualDepth);
    }
    @Test
    public void testTraversePrint(){
        // 创建一个二叉树示例
        //        3
        //       / \
        //      9  20
        //        /  \
        //       15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MaxDepthOfBinaryTree.traversePrint(root,1);
    }
    @Test
    public void testTraversePrint2(){
        // 创建一个二叉树示例
        //        3
        //       / \
        //      9  20
        //        /  \
        //       15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MaxDepthOfBinaryTree.traversePrint2(root);
    }

}

