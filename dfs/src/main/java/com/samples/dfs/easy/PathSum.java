package com.samples.dfs.easy;

public class PathSum {

	public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == targetSum)
        {
        	return true;
        }
        
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }
	
	public static void main(String[] args) {
		PathSum obj = new PathSum();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
//		root.left.left = new TreeNode(1);
		
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		
		System.out.println(obj.hasPathSum(root, 14));
	}
}
