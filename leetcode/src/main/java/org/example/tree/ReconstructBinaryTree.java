package org.example.tree;

import java.util.HashMap;

public class ReconstructBinaryTree {
    static HashMap<Integer,Integer> valToIndex = new HashMap<>();

    public static TreeNode reconstructBinaryTree(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart + 1];

        int index = valToIndex.get(leftRootVal);
        // 左子树的元素个数
        int leftSize = index - postStart + 1;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);
        return root;
    }
}

