package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    //    private  static List<Integer> result = new ArrayList<>();
//    public static List<Integer> rightSideView(TreeNode root) {
//        result = new ArrayList<>();
//        traverse(root);
//        return result;
//    }
//    private static void traverse(TreeNode root) {
//        if(root==null){
//            return;
//        }
//        result.add(root.val);
//        if(root.right!=null){
//            traverse(root.right);
//        }
//    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode rightMost = null;

            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                rightMost = node; // 更新当前层的最后一个节点
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // 将当前层的最后一个节点的值加入结果列表
            result.add(rightMost.val);
        }

        return result;
    }
}
