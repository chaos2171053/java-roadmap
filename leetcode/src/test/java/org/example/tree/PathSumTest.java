package org.example.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
//
//叶子节点 是指没有子节点的节点。
//
//
//
//示例 1：
//
//
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
//示例 2：
//
//
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。
//示例 3：
//
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
//
//
//提示：
//
//树中节点的数目在范围 [0, 5000] 内
//-1000 <= Node.val <= 1000
//-1000 <= targetSum <= 1000
public class PathSumTest {
    @Test
    public void testHasPathSum_Sample1() {
        // 构建示例1的二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        // 调用 PathSum 中的 hasPathSum 方法
        boolean result = PathSum.hasPathSum(root, 22);

        // 验证结果是否符合预期
        assertEquals(true, result);
    }

    @Test
    public void testHasPathSum_Sample2() {
        // 构建示例2的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 调用 PathSum 中的 hasPathSum 方法
        boolean result = PathSum.hasPathSum(root, 5);

        // 验证结果是否符合预期
        assertEquals(false, result);
    }

    @Test
    public void testHasPathSum_EmptyTree() {
        // 构建空二叉树
        TreeNode root = null;

        // 调用 PathSum 中的 hasPathSum 方法
        boolean result = PathSum.hasPathSum(root, 0);

        // 验证结果是否符合预期
        assertEquals(false, result);
    }
}
