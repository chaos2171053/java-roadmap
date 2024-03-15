package org.example.tree;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FlattenBinaryTreeToLinkedListTest {

    @Test
    public void testFlatten() {
        // 创建一个二叉树示例
        //        1
        //       / \
        //      2   5
        //     / \   \
        //    3   4   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // 展开二叉树为单链表
        FlattenBinaryTreeToLinkedList.flatten(root);

        // 检查展开结果
        assertEquals(1, root.val); // 根节点值应该为1
        assertNull(root.left); // 根节点的左子树应该为null
        assertEquals(2, root.right.val); // 根节点的右子树值应该为2
        assertEquals(3, root.right.right.val); // 2的右子树值应该为3
        assertEquals(4, root.right.right.right.val); // 3的右子树值应该为4
        assertEquals(5, root.right.right.right.right.val); // 4的右子树值应该为5
        assertEquals(6, root.right.right.right.right.right.val); // 5的右子树值应该为6
        assertNull(root.right.right.right.right.left); // 6的左子树应该为null
    }
}

