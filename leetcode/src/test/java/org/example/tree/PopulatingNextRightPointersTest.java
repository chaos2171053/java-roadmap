package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


//给定一个二叉树：
//
//struct Node {
//int val;
//Node *left;
//Node *right;
//Node *next;
//}
//填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
//
//初始状态下，所有 next 指针都被设置为 NULL 。
//
//
//
//示例 1：
//
//
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
//示例 2：
//
//输入：root = []
//输出：[]
//
//
//提示：
//
//树中的节点数在范围 [0, 6000] 内
//-100 <= Node.val <= 100
//进阶：
//
//你只能使用常量级额外空间。
//使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。

public class PopulatingNextRightPointersTest {
    @Test
    public void testPopulateNext_Sample1() {
        // 构建示例1的二叉树
        PopulatingNextRightPointers.Node root = new PopulatingNextRightPointers.Node(1);
        root.left = new PopulatingNextRightPointers.Node(2);
        root.right = new PopulatingNextRightPointers.Node(3);
        root.left.left = new PopulatingNextRightPointers.Node(4);
        root.left.right = new PopulatingNextRightPointers.Node(5);
        root.right.right = new PopulatingNextRightPointers.Node(7);

        // 调用 PopulatingNextRightPointers 中的 populateNext 方法
        PopulatingNextRightPointers.populateNext(root);

        // 验证 next 指针是否设置正确
        assertEquals(null, root.next);
        assertEquals(root.right, root.left.next);
        assertEquals(null, root.right.next);
        assertEquals(root.left.right, root.left.left.next);
        assertEquals(root.right.right, root.left.right.next);
        assertEquals(null, root.left.right.next);
        assertEquals(null, root.right.right.next);
    }

    @Test
    public void testPopulateNext_EmptyTree() {
        // 构建空二叉树
        PopulatingNextRightPointers.Node root = null;

        // 调用 PopulatingNextRightPointers 中的 populateNext 方法
        PopulatingNextRightPointers.populateNext(root);

        // 验证空树时是否正确处理
        assertEquals(null, root);
    }
}
