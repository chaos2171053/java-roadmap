package org.example.tree;

//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
//
//
//示例 1：
//
//
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
//示例 2：
//
//
//输入：p = [1,2], q = [1,null,2]
//输出：false
//示例 3：
//
//
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
public class SameTree {
    static boolean result = false;

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(q==null && p==null){
            return  true;
        }

        if (p == null && q != null || (p != null && q == null) || q.val != p.val || (p.left ==null && q.left!=null)||(p.right ==null && q.right!=null)) {
            return false;
        }
        if(q!=null && p!=null && q.left == null && q.right == null && p.right ==null && p.left == null && q.val ==p.val) {
            return  true;
        }

        boolean sameLeft = isSameTree(p.left, q.left);
        boolean sameRight = isSameTree(p.right, q.right);
        return sameLeft && sameRight;
    }


}
