package org.example.tree;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryTreeDiameterTest {

    @Test
    public void testBinaryTreeDiameter() {
        // 构建测试用的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 调用方法求解直径
        int diameter = BinaryTreeDiameter.diameterOfBinaryTree(root);

        // 预期结果为 3，因为最长路径为 4 -> 2 -> 1 -> 3 或者 5 -> 2 -> 1 -> 3
        assertEquals(3, diameter);
    }


}
