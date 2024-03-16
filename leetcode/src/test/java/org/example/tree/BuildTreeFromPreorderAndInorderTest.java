package org.example.tree;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuildTreeFromPreorderAndInorderTest {

    @Test
    public void testBuildTree() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = org.example.tree.BuildTreeFromPreorderAndInorder.buildTree(preorder, inorder);

        // 根据给定的先序和中序遍历序列，构建的二叉树如下所示：
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7

        // 检查根节点的值
        assertEquals(3, root.val);

        // 检查左子树
        assertEquals(9, root.left.val);
        assertEquals(15, root.right.left.val);

        // 检查右子树
        assertEquals(20, root.right.val);
        assertEquals(7, root.right.right.val);
    }
}


