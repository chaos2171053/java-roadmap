package org.example.tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindDuplicateSubtreesTest {

    @Test
    public void testFindDuplicateSubtrees() {
        // 创建二叉树示例
        //      1
        //     / \
        //    2   3
        //   /   / \
        //  4   2   4
        //     /
        //    4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        // 寻找重复子树
        FindDuplicateSubtrees solution = new FindDuplicateSubtrees();
        List<TreeNode> duplicates = solution.findDuplicateSubtrees(root);

        // 验证结果
        assertEquals(2, duplicates.size()); // 期望有2棵重复的子树
    }
}