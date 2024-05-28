package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateBinarySearchTreeTest {
    @Test
    public void testValidBST() {
        // 构造一个有效的二叉搜索树
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // 创建 ValidateBinarySearchTree 实例并进行测试
        ValidateBinarySearchTree validator = new ValidateBinarySearchTree();
        assertTrue(validator.isValidBST(root));
    }

    @Test
    public void testInvalidBST() {
        // 构造一个无效的二叉搜索树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        // 创建 ValidateBinarySearchTree 实例并进行测试
        ValidateBinarySearchTree validator = new ValidateBinarySearchTree();
        assertFalse(validator.isValidBST(root));
    }
}
