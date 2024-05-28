package org.example.tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class RightSideViewTest {

    @Test
    public void testRightSideView_Sample1() {
        // 构建示例的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        // 计算从右侧所能看到的节点值
        List<Integer> result = RightSideView.rightSideView(root);

        // 验证结果
        assertArrayEquals(new Integer[]{1, 2}, result.toArray(new Integer[0]));
    }

    @Test
    public void testRightSideView_Sample2() {
        // 构建示例的二叉树
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);

        // 计算从右侧所能看到的节点值
        List<Integer> result = RightSideView.rightSideView(root);

        // 验证结果
        assertArrayEquals(new Integer[]{1, 3}, result.toArray(new Integer[0]));
    }

    @Test
    public void testRightSideView_EmptyTree() {
        // 构建空树
        TreeNode root = null;

        // 计算从右侧所能看到的节点值
        List<Integer> result = RightSideView.rightSideView(root);

        // 验证结果
        assertArrayEquals(new Integer[]{}, result.toArray(new Integer[0]));
    }

    @Test
    public void testRightSideView_SingleNode() {
        // 构建示例的二叉树
        TreeNode root = new TreeNode(1);

        // 计算从右侧所能看到的节点值
        List<Integer> result = RightSideView.rightSideView(root);

        // 验证结果
        assertArrayEquals(new Integer[]{1}, result.toArray(new Integer[0]));
    }
}

