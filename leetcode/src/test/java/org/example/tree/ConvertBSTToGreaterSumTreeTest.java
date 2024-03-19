package org.example.tree;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ConvertBSTToGreaterSumTreeTest {

    @Test
    public void testConvertBST() {
        // 创建一个二叉搜索树示例
        //       4
        //      / \
        //     1   6
        //    / \   \
        //   0   2   7
        //        \
        //         3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.right = new TreeNode(7);

        // 将二叉搜索树转换为累加树
        TreeNode result =  ConvertBSTToGreaterSumTree.convertBST(root);

        // 验证转换结果是否正确
        int[] expected = {23, 23, 22, 20, 17, 13, 7};
        assertInOrderTraversal(result, expected);
    }

    private void assertInOrderTraversal(TreeNode root, int[] expected) {
        int[] result = new int[expected.length];
        inOrderTraversal(root, result, 0);
        assertArrayEquals(expected, result);
    }

    private int inOrderTraversal(TreeNode node, int[] result, int index) {
        if (node == null) {
            return index;
        }
        index = inOrderTraversal(node.left, result, index);
        result[index++] = node.val;
        return inOrderTraversal(node.right, result, index);
    }
}

