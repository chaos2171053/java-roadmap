package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//
//
//示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
//示例 2：
//
//输入：root = [1]
//输出：[[1]]
//示例 3：
//
//输入：root = []
//输出：[]
//
//
//提示：
//
//树中节点数目在范围 [0, 2000] 内
//-1000 <= Node.val <= 1000
public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        if(root==null){
//            return result;
//        }
//        List<Integer> rootQueue = new ArrayList<>();
//        rootQueue.add(root.val);
//        result.add(rootQueue);
//
//
//        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
//        treeNodeQueue.add(root);
//
//
//        while(!treeNodeQueue.isEmpty()){
//           TreeNode head =  treeNodeQueue.poll();
//            List<Integer> queue = new ArrayList<>();
//           if(head.left!=null){
//               treeNodeQueue.add(head.left);
//               queue.add(head.left.val);
//           }
//            if(head.right!=null){
//                treeNodeQueue.add(head.right);
//                queue.add(head.right.val);
//            }
//            if(!queue.isEmpty()){
//                result.add(queue);
//            }
//
//        }
//        return result;

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(level);
        }

        return result;

    }
}
