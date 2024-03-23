package org.example.tree;

import org.junit.Test;
import static org.junit.Assert.*;

public class CompleteBinaryTreeCountNodesTest {

    @Test
    public void testCountNodes() {
        // 构建一棵完全二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        // 预期节点个数为 6
        assertEquals(6, CompleteBinaryTreeCountNodes.countNodes(root));
    }
}

