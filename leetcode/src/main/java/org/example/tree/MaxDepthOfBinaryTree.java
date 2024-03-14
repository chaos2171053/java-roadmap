package org.example.tree;

public class MaxDepthOfBinaryTree {
    // 最大深度
    static int res = 0;
    // 遍历深度
    static int depth = 0;

    public static int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth2(root.left);
        int rightMax = maxDepth2(root.right);

        int max = Math.max(leftMax, rightMax) + 1;
        return max;
    }

    public static void traversePrint(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 前序位置的代码只能从函数参数中获取父节点传递来的数据
        System.out.println("节点 " + root.val + " 在" + level + "层");
        traversePrint(root.left, level + 1);
        traversePrint(root.right, level + 1);
    }

    public static int traversePrint2(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int leftMax = traversePrint2(root.left);
        int rightMax = traversePrint2(root.right);
        int max = Math.max(leftMax,rightMax)+1;
        System.out.println("节点 " + root.val + "左子树有" + leftMax + "个节点，右子树有"+rightMax+"个节点");
        return max;
    }
}
