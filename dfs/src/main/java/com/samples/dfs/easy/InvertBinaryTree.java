package com.samples.dfs.easy;

//https://leetcode.com/problems/invert-binary-tree/submissions/
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        
        return root;
    }
	

}
