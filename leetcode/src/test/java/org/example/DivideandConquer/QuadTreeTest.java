package org.example.DivideandConquer;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuadTreeTest {
    @Test
    public void testExample1() {
        int[][] grid = {
                {0, 1},
                {1, 0}
        };
        QuadTree qt = new QuadTree();
        Node root = qt.construct(grid);

        assertNotNull(root);
        assertFalse(root.isLeaf);
        assertTrue(root.topLeft.isLeaf);
        assertTrue(root.topRight.isLeaf);
        assertTrue(root.bottomLeft.isLeaf);
        assertTrue(root.bottomRight.isLeaf);
        assertFalse(root.topLeft.val);
        assertTrue(root.topRight.val);
        assertTrue(root.bottomLeft.val);
        assertFalse(root.bottomRight.val);
    }

    @Test
    public void testExample2() {
        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };
        QuadTree qt = new QuadTree();
        Node root = qt.construct(grid);

        assertNotNull(root);
        assertFalse(root.isLeaf);
        assertTrue(root.topLeft.isLeaf);
        assertFalse(root.topRight.isLeaf);
        assertTrue(root.bottomLeft.isLeaf);
        assertTrue(root.bottomRight.isLeaf);
        assertTrue(root.topLeft.val);
        assertTrue(root.bottomLeft.val);
        assertFalse(root.bottomRight.val);

        Node topRight = root.topRight;
        assertTrue(topRight.topLeft.isLeaf);
        assertTrue(topRight.topRight.isLeaf);
        assertTrue(topRight.bottomLeft.isLeaf);
        assertTrue(topRight.bottomRight.isLeaf);
        assertTrue(topRight.topLeft.val);
        assertFalse(topRight.topRight.val);
        assertTrue(topRight.bottomLeft.val);
        assertFalse(topRight.bottomRight.val);
    }
}