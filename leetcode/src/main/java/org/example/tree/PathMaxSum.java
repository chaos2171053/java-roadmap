package org.example.tree;

//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//
//路径和 是路径中各节点值的总和。
//
//给你一个二叉树的根节点 root ，返回其 最大路径和 。
//
//
//
//示例 1：
//
//
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
//示例 2：
//
//
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
public class PathMaxSum {
    public static int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }

    private static int maxPathSumHelper(TreeNode root, int[] maxSum) {
        if(root ==null){
            return 0;
        }
        int leftSum = Math.max(maxPathSumHelper(root.left, maxSum), 0);
        int rightSum = Math.max(maxPathSumHelper(root.right, maxSum), 0);
        int currentMax = root.val + leftSum + rightSum;
        maxSum[0] = Math.max(maxSum[0], currentMax);
        // 返回以当前节点为根的子树的最大路径和（只能包含当前节点的一侧路径）
        return root.val + Math.max(leftSum, rightSum);
    }
}
