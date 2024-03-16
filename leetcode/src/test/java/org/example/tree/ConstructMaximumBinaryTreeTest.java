package org.example.tree;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ConstructMaximumBinaryTreeTest {

    @Test
    public void testConstructMaximumBinaryTree() {
        // 给定一个不重复的整数数组
        int[] nums = {3, 2, 1, 6, 0, 5};

        // 构建最大二叉树
        TreeNode root = ConstructMaximumBinaryTree.constructMaximumBinaryTree(nums);

        // 检查构建结果
        assertEquals(6, root.val); // 根节点值应该为6

        // 根节点的左子树
        assertEquals(3, root.left.val); // 根节点的左子树值应该为3
        assertNull(root.left.left); // 3的左子树应该为null
        assertEquals(2, root.left.right.val); // 3的右子树值应该为2
        assertNull(root.left.right.left); // 2的左子树应该为null
        assertEquals(1,root.left.right.right.val); // 2的右子树应该为 1

        // 根节点的右子树
        assertEquals(5, root.right.val); // 根节点的右子树值应该为5
        assertNull(root.right.right); // 5的左子树应该为null
        assertEquals(0, root.right.left.val); // 5的右子树值应该为0
        assertNull(root.right.left.left); // 0的左子树应该为null
        assertNull(root.right.left.right); // 0的右子树应该为null
    }
}

