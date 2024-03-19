package org.example.tree;

//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
//
//提醒一下，二叉搜索树满足下列约束条件：
//
//节点的左子树仅包含键 小于 节点键的节点。
//节点的右子树仅包含键 大于 节点键的节点。
//左右子树也必须是二叉搜索树。
public class ConvertBSTToGreaterSumTree {
    // 记录累加和
    // 记录累加和
    public static TreeNode convertBST(TreeNode root) {
        traverse(root, 0);
        return root;
    }

    // 记录累加和
    static int traverse(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        // 先递归右子树，并得到右子树的累加和
        int rightSum = traverse(root.right, sum);
        // 维护累加和
        int originalVal = root.val;
        root.val += rightSum;
        // 再递归左子树，并传递更新后的累加和
        return traverse(root.left, root.val);
    }
}
