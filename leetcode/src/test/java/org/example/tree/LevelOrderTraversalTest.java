package org.example.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LevelOrderTraversalTest {
    @Test
    public void testLevelOrder_Sample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = LevelOrderTraversal.levelOrder(root);

        assertEquals(3, result.size());
        assertEquals(Arrays.asList(3), result.get(0));
        assertEquals(Arrays.asList(9, 20), result.get(1));
        assertEquals(Arrays.asList(15, 7), result.get(2));
    }

    @Test
    public void testLevelOrder_Sample2() {
        TreeNode root = new TreeNode(1);

        List<List<Integer>> result = LevelOrderTraversal.levelOrder(root);

        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1), result.get(0));
    }

    @Test
    public void testLevelOrder_EmptyTree() {
        TreeNode root = null;

        List<List<Integer>> result = LevelOrderTraversal.levelOrder(root);

        assertEquals(0, result.size());
    }
    @Test
    public void testLevelOrder_CustomCase1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<List<Integer>> result = LevelOrderTraversal.levelOrder(root);

        assertEquals(3, result.size());
        assertEquals(Arrays.asList(1), result.get(0));
        assertEquals(Arrays.asList(2, 3), result.get(1));
        assertEquals(Arrays.asList(4, 5), result.get(2));
    }
}
