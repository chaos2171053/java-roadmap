package org.example.tree;

import java.util.Stack;

//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
//
//
//示例 1：
//
//
//输入：root = [3,1,4,null,2], k = 1
//输出：1
//示例 2：
//
//
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
//
//
//
//
//提示：
//
//树中的节点数为 n 。
//1 <= k <= n <= 104
//0 <= Node.val <= 104
//
//
//进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
public class KthSmallestElementInBST2 {
    // 其实使用一个 count 变量来计数就可以了
    public Stack<Integer> stack = new Stack<Integer>();
    public int kthSmallest(TreeNode root, int i) {
        stack = new Stack<Integer>();
        traverse(root);
        for (int j = 0; j < stack.size(); j++) {
            if(j==i-1){
                return stack.get(j);
            }
        }
        return -1;
    }

    private void traverse(TreeNode root) {
        if(root==null){
            return;
        }

        traverse(root.left);
        stack.push(root.val);
        traverse(root.right);
    }
}
