package com.samples.dfs.easy;
//https://leetcode.com/problems/diameter-of-binary-tree/submissions/
public class DiameterOfBinaryTree {
	
	int ans;
	int helper(TreeNode node)
	{
		if(node == null) return 0;
		
		int left = helper(node.left);
		int right = helper(node.right);
		
		int d = left + right + 1;
		
		ans = Math.max(ans, d);
		
		return Math.max(left, right) + 1;
	}

	 public int diameterOfBinaryTree(TreeNode root) {
	       helper(root);
	       return ans;
	 }

}
