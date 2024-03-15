package org.example.tree;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class PopulateNextRightPointerTest {

    @Test
    public void testPopulateNextRightPointer() {
        // 创建一个完美二叉树示例
        //          1
        //        /   \
        //       2     3
        //      / \   / \
        //     4   5 6   7
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // 填充每个节点的 next 指针
        PopulateNextRightPointer.populateNextRightPointer(root);

        // 检查填充结果
        assertNull(root.next); // 根节点的 next 指针应该为 null
        assertEquals(root.right, root.left.next); // 2 的 next 指针应该指向 3
        assertNull(root.right.next); // 3 的 next 指针应该为 null
        assertEquals(root.left.right, root.left.left.next); // 4 的 next 指针应该指向 5
        assertEquals(root.right.left, root.left.right.next); // 5 的 next 指针应该指向 6
        assertEquals(root.right.right, root.right.left.next); // 6 的 next 指针应该指向 7
        assertNull(root.right.right.next); // 7 的 next 指针应该为 null
    }
}


