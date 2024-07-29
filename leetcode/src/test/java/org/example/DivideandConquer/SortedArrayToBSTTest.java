package org.example.DivideandConquer;

import org.junit.Test;
import static org.junit.Assert.*;

public class SortedArrayToBSTTest {

    @Test
    public void testSortedArrayToBSTWithExample1() {
        SortedArrayToBST converter = new SortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = converter.sortedArrayToBST(nums);
        // 验证树的结构
        assertNotNull(root);
        assertEquals(0, root.val);
        assertEquals(-10, root.left.left.val);
        assertEquals(-3, root.left.val);
        assertEquals(5, root.right.left.val);
        assertEquals(9, root.right.val);
    }

    @Test
    public void testSortedArrayToBSTWithExample2() {
        SortedArrayToBST converter = new SortedArrayToBST();
        int[] nums = {1, 3};
        TreeNode root = converter.sortedArrayToBST(nums);
        // 验证树的结构
        assertNotNull(root);
        assertTrue((root.val == 1 && root.right.val == 3) || (root.val == 3 && root.left.val == 1));
    }

    @Test
    public void testSortedArrayToBSTWithSingleElement() {
        SortedArrayToBST converter = new SortedArrayToBST();
        int[] nums = {1};
        TreeNode root = converter.sortedArrayToBST(nums);
        // 验证树的结构
        assertNotNull(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void testSortedArrayToBSTWithEmptyArray() {
        SortedArrayToBST converter = new SortedArrayToBST();
        int[] nums = {};
        TreeNode root = converter.sortedArrayToBST(nums);
        // 验证树的结构
        assertNull(root);
    }

    @Test
    public void testSortedArrayToBSTWithThreeElements() {
        SortedArrayToBST converter = new SortedArrayToBST();
        int[] nums = {1, 2, 3};
        TreeNode root = converter.sortedArrayToBST(nums);
        // 验证树的结构
        assertNotNull(root);
        assertEquals(2, root.val);
        assertEquals(1, root.left.val);
        assertEquals(3, root.right.val);
    }
}

