package com.samples.dfs.easy;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MaxDepthBT {


	public int maxDepth1(TreeNode root) {
		if(root == null) return 0;

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
//		root.left.left = new TreeNode(1);
		
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		
		MaxDepthBT obj = new MaxDepthBT();
		System.out.println(obj.maxDepth(root));
	}

	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		
    }
}
