package org.example.tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UniqueBSTsGenerationTest {

    @Test
    public void testGenerateUniqueBSTs() {
        // 测试n为3时的情况
        int n = 3;
        List<TreeNode> result = UniqueBSTsGeneration.generateTrees(n);

        // 验证结果列表是否不为空
        assertNotNull(result);

        // 验证结果列表的长度是否正确
        assertEquals(5, result.size());

        // 验证每棵树是否满足二叉搜索树的条件
        for (TreeNode root : result) {
            assertTrue(isValidBST(root));
        }
    }

    // 辅助方法：验证一棵树是否为二叉搜索树
    private boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.val <= min.val) || (max != null && node.val >= max.val)) {
            return false;
        }
        return isValidBST(node.left, min, node) && isValidBST(node.right, node, max);
    }
}

