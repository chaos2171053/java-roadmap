package org.example.tree;

import java.util.ArrayList;

//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）
public class KthSmallestElementInBST {
    static int count = 0;
    static int result = 0;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static Object kthSmallest(TreeNode root, int i) {
        traverse(root);
        return arrayList.get(i-1);
    }

    private static void traverse(TreeNode root) {
        if(root ==null){
            return;
        }
        traverse(root.left);
        arrayList.add(root.val);
        traverse(root.right);
    }
}
