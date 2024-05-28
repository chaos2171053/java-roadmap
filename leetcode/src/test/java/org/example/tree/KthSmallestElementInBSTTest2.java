package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthSmallestElementInBSTTest2 {
    @Test
    public void testKthSmallest_Sample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElementInBST2 solution = new KthSmallestElementInBST2();
        int result = solution.kthSmallest(root, 1);
        assertEquals(1, result);
    }

    @Test
    public void testKthSmallest_Sample2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthSmallestElementInBST2 solution = new KthSmallestElementInBST2();
        int result = solution.kthSmallest(root, 3);
        assertEquals(3, result);
    }

    @Test
    public void testKthSmallest_CustomCase1() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(12);

        KthSmallestElementInBST2 solution = new KthSmallestElementInBST2();
        int result = solution.kthSmallest(root, 4);
        assertEquals(7, result);
    }

    @Test
    public void testKthSmallest_CustomCase2() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(11);
        root.right.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(15);

        KthSmallestElementInBST2 solution = new KthSmallestElementInBST2();
        int result = solution.kthSmallest(root, 7);
        assertEquals(7, result);
    }
}
