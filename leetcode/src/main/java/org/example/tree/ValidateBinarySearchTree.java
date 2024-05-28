package org.example.tree;

public class ValidateBinarySearchTree {
    public Boolean isValidBST(TreeNode root) {
        return validBST(root,null,null);
    }

    private Boolean validBST(TreeNode root, Integer min, Integer max) {
        if(root == null){
            return  true;
        }
        if((min!=null && min>=root.val)||(max!=null && max<=root.val)){
            return false;
        }
        return validBST(root.left,min,root.val) && validBST(root.right,root.val,max);
    }
}
