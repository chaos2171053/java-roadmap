package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsValidBSTTest {

    @Test
    public void testValidBST() {
        // 创建一个有效的二叉搜索树
        //       2
        //      / \
        //     1   3
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        assertTrue(IsValidBST.isValidBST(root));
    }

    @Test
    public void testInvalidBST() {
        // 创建一个无效的二叉搜索树
        //       5
        //      / \
        //     1   4
        //        / \
        //       3   6
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        assertFalse(IsValidBST.isValidBST(root));
    }

    @Test
    public void testEmptyTree() {
        // 测试空树
        TreeNode root = null;
        assertTrue(IsValidBST.isValidBST(root));
    }

    @Test
    public void testSingleRoot() {
        // 测试只有根节点的情况
        TreeNode root = new TreeNode(1);
        assertTrue(IsValidBST.isValidBST(root));
    }

    @Test
    public void testNestedBST() {
        // 创建一个有效的二叉搜索树
        //       5
        //      / \
        //     3   8
        //    / \ / \
        //   1  4 6  9
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        assertTrue(IsValidBST.isValidBST(root));
    }
    @Test
    public void testComplexBST() {
        // 创建一个无效的二叉搜索树
        //        5
        //       / \
        //      4   6
        //     /     \
        //    3       7
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        assertTrue(IsValidBST.isValidBST(root));
    }
}

