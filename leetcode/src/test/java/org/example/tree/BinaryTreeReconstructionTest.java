package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeReconstructionTest {


    @Test
    public void testReconstructBinaryTree() {
        // 给定一个二叉树的先序和后序遍历结果
        int[] preorder = {1, 2, 4, 5, 3};
        int[] postorder = {4, 5, 2, 3, 1};

        // 还原二叉树结构
        TreeNode root = ReconstructBinaryTree.reconstructBinaryTree(preorder, postorder);

        // 验证还原结果是否正确
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
        assertEquals(4, root.left.left.val);
        assertEquals(5, root.left.right.val);
    }
}

