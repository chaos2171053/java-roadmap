package org.example.tree;

import org.junit.Test;
import static org.junit.Assert.*;

public class SearchBSTTest {

    @Test
    public void testSearchExistingNode() {
        // 创建一个二叉搜索树
        //        4
        //       / \
        //      2   7
        //     / \
        //    1   3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // 在树中搜索值为3的节点
        TreeNode result = SearchBST.searchBST(root, 3);

        // 验证结果是否正确
        assertEquals(3, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    public void testSearchNonExistingNode() {
        // 创建一个二叉搜索树
        //        4
        //       / \
        //      2   7
        //     / \
        //    1   3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // 在树中搜索值为5的节点
        TreeNode result = SearchBST.searchBST(root, 5);

        // 验证结果是否为null
        assertNull(result);
    }

    @Test
    public void testEmptyTree() {
        // 测试空树
        TreeNode root = null;
        // 在空树中搜索任何值都应该返回null
        TreeNode result = SearchBST.searchBST(root, 10);
        assertNull(result);
    }
}

