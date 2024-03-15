package org.example.tree;

// 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        traverse(root.left);
        traverse(root.right);
    }


    public static TreeNode invertTree2(TreeNode root) {
        if(root ==null){
            return null;
        }
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left =right;
        root.right = left;
        return root;
    }
}
