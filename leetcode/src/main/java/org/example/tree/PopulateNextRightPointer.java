package org.example.tree;

//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//struct Node {
//int val;
//Node *left;
//Node *right;
//Node *next;
//}
//填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
//初始状态下，所有 next 指针都被设置为 NULL。
public class PopulateNextRightPointer {
    public static Node populateNextRightPointer(Node root) {
        if(root==null){
            return root;
        }
        traverse(root.left,root.right);
        return null;
    }

    private static void traverse(Node left, Node right) {
        if(left==null || right == null){
            return;
        }
        left.next = right;
        traverse(left.left,left.right);
        traverse(right.left, right.right);
        traverse(left.right, right.left);
    }
}
