package org.example.tree;

import java.util.ArrayList;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
//inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
public class BuildTreeFromPreorderAndInorder {
    static ArrayList<Integer> preorderArray;
    static ArrayList<Integer> inorderArray;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int rootValInInorderIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(rootVal == inorder[i]){
                rootValInInorderIndex = i;
                break;
            }
        }

        int leftSize = rootValInInorderIndex - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootValInInorderIndex - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootValInInorderIndex + 1, inEnd);
        return root;
    }

    public void preorderTraverse(TreeNode root){
        preorderArray.add(root.val);
        preorderTraverse(root.left);
        preorderTraverse(root.right);

    }
    public void inorderTraverse(TreeNode root){
        inorderTraverse(root.left);
        inorderArray.add(root.val);
        inorderTraverse(root.right);
    }
}
