package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlattenBinaryTreeToLinkedListTest2 {
    @Test
    public void testFlatten_Sample1() {
        // 构建示例1的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // 调用 FlattenBinaryTreeToLinkedList 中的 flatten 方法
        FlattenBinaryTreeToLinkedList2.flatten(root);

        // 验证展开后的结果是否符合预期
        assertEquals(null, root.left);
        assertEquals(2, root.right.val);
        assertEquals(null, root.right.left);
        assertEquals(3, root.right.right.val);
        assertEquals(null, root.right.right.left);
        assertEquals(4, root.right.right.right.val);
        assertEquals(null, root.right.right.right.left);
        assertEquals(5, root.right.right.right.right.val);
        assertEquals(null, root.right.right.right.right.left);
        assertEquals(6, root.right.right.right.right.right.val);
        assertEquals(null, root.right.right.right.right.right.left);
        assertEquals(null, root.right.right.right.right.right.right);
    }

    @Test
    public void testFlatten_EmptyTree() {
        // 构建空二叉树
        TreeNode root = null;

        // 调用 FlattenBinaryTreeToLinkedList 中的 flatten 方法
        FlattenBinaryTreeToLinkedList.flatten(root);

        // 验证空树时是否正确处理
        assertEquals(null, root);
    }

    @Test
    public void testFlatten_SingleNodeTree() {
        // 构建只有一个节点的二叉树
        TreeNode root = new TreeNode(0);

        // 调用 FlattenBinaryTreeToLinkedList 中的 flatten 方法
        FlattenBinaryTreeToLinkedList.flatten(root);

        // 验证只有一个节点的树是否正确处理
        assertEquals(null, root.left);
        assertEquals(0, root.val);
        assertEquals(null, root.right);
    }
}
