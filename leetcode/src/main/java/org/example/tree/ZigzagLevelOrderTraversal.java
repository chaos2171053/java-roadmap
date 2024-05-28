package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
//
//
//示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
//示例 2：
//
//输入：root = [1]
//输出：[[1]]
//示例 3：
//
//输入：root = []
//输出：[]
public class ZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.addLast(node.val); // 从左到右添加
                } else {
                    level.addFirst(node.val); // 从右到左添加
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(level);
            leftToRight = !leftToRight; // 切换方向
        }
        return  result;
    }
}
