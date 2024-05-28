package org.example.tree;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//
//
//示例 1：
//
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
//示例 2：
//
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
//示例 3：
//
//输入：root = [1,2], p = 1, q = 2
//输出：1
//
//
//提示：
//
//树中节点数目在范围 [2, 105] 内。
//-109 <= Node.val <= 109
//所有 Node.val 互不相同 。
//p != q
//p 和 q 均存在于给定的二叉树中。
public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为 null，或者等于 p 或 q，则直接返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }

        // 在左子树中递归寻找最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // 在右子树中递归寻找最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左子树和右子树分别找到了目标节点，则当前节点就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }

        // 如果其中一个子树找到了目标节点，则将该节点向上传递
        return left != null ? left : right;
    }
}
