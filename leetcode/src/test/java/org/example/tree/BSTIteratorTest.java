package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTIteratorTest {
    @Test
    public void testBSTIterator_Sample1() {
        // 构建示例的二叉搜索树
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // 初始化 BSTIterator
        BSTIterator bSTIterator = new BSTIterator(root);

        // 执行操作并验证结果
        assertEquals(3, bSTIterator.next());    // 返回 3
        assertEquals(7, bSTIterator.next());    // 返回 7
        assertTrue(bSTIterator.hasNext());      // 返回 true
        assertEquals(9, bSTIterator.next());    // 返回 9
        assertTrue(bSTIterator.hasNext());      // 返回 true
        assertEquals(15, bSTIterator.next());   // 返回 15
        assertTrue(bSTIterator.hasNext());      // 返回 true
        assertEquals(20, bSTIterator.next());   // 返回 20
        assertFalse(bSTIterator.hasNext());     // 返回 false
    }

    @Test
    public void testBSTIterator_EmptyTree() {
        // 构建空树
        TreeNode root = null;

        // 初始化 BSTIterator
        BSTIterator bSTIterator = new BSTIterator(root);

        // 执行操作并验证结果
        assertFalse(bSTIterator.hasNext());     // 返回 false
    }

    @Test
    public void testBSTIterator_SingleNodeTree() {
        // 构建只有一个节点的二叉搜索树
        TreeNode root = new TreeNode(1);

        // 初始化 BSTIterator
        BSTIterator bSTIterator = new BSTIterator(root);

        // 执行操作并验证结果
        assertTrue(bSTIterator.hasNext());      // 返回 true
        assertEquals(1, bSTIterator.next());    // 返回 1
        assertFalse(bSTIterator.hasNext());     // 返回 false
    }
}
