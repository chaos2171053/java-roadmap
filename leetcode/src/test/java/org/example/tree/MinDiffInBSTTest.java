package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinDiffInBSTTest {
    @Test
    public void testMinDiffInBST_Sample1() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        MinDiffInBST solution = new MinDiffInBST();
        int result = solution.minDiffInBST(root);

        assertEquals(1, result);
    }

    @Test
    public void testMinDiffInBST_Sample2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(48);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);

        MinDiffInBST solution = new MinDiffInBST();
        int result = solution.minDiffInBST(root);

        assertEquals(1, result);
    }

    @Test
    public void testMinDiffInBST_CustomCase1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        MinDiffInBST solution = new MinDiffInBST();
        int result = solution.minDiffInBST(root);

        assertEquals(1, result);
    }
}
