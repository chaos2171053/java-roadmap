package org.example.tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AverageOfLevelsTest {
    @Test
    public void testAverageOfLevels_Sample1() {
        // 构建示例的二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 计算每层节点的平均值
       List<Double> result = AverageOfLevels.averageOfLevels(root);

        // 验证结果
        assertEquals(3.0, result.get(0), 1e-5);
        assertEquals(14.5, result.get(1), 1e-5);
        assertEquals(11.0, result.get(2), 1e-5);
    }

    @Test
    public void testAverageOfLevels_Sample2() {
        // 构建示例的二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);

        // 计算每层节点的平均值
        List<Double> result = AverageOfLevels.averageOfLevels(root);

        // 验证结果
        assertEquals(3.0, result.get(0), 1e-5);
        assertEquals(14.5, result.get(1), 1e-5);
        assertEquals(11.0, result.get(2), 1e-5);
    }

    @Test
    public void testAverageOfLevels_EmptyTree() {
        // 构建空树
        TreeNode root = null;

        // 计算每层节点的平均值
        List<Double> result = AverageOfLevels.averageOfLevels(root);

        // 验证结果
        assertEquals(0, result.size());
    }

    @Test
    public void testAverageOfLevels_SingleNode() {
        // 构建只有一个节点的二叉树
        TreeNode root = new TreeNode(1);

        // 计算每层节点的平均值
        List<Double> result = AverageOfLevels.averageOfLevels(root);

        // 验证结果
        assertEquals(1.0, result.get(0), 1e-5);
    }
}
