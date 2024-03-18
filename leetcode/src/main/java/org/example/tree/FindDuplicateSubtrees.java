package org.example.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
//
//对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
//
//如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
public class FindDuplicateSubtrees {
    HashMap<String,Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    private String dfs(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "#";
        String key = sb.append(root.val).append("-").append(dfs(root.left)).append(dfs(root.right)).toString();

        map.put(key, map.getOrDefault(key, 0) + 1);
        if(map.get(key) == 2) {
            res.add(root);
        }
        return key;
    }
}
