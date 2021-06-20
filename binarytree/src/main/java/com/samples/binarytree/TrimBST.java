package com.samples.binarytree;


public class TrimBST {

//	https://leetcode.com/problems/trim-a-binary-search-tree/
	private TreeNode helper(TreeNode root, int low, int high)
	{
		if(root == null)
		{
			return null;
		}
		TreeNode node = null;

		if(root.val >= low && root.val <= high)
		{
			node = new TreeNode(root.val);
		}
		
		TreeNode left = helper(root.left, low, high);
		if(node == null)
		{
			node = left;
		}
		else if(left != null)
		{
			node.left = left;
		}
		
		TreeNode right = helper(root.right, low, high);
		if(node == null)
		{
			node = right;
		}
		else if(right != null)
		{
			node.right = right;
		}
		
		return node;
	}
	public TreeNode trimBST1(TreeNode root, int low, int high) {
        return helper(root, low, high);
        		
    }
	
	
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if(root == null) return root;
		if(root.val > high) return trimBST(root.left, low, high);
		if(root.val < low) return trimBST(root.right, low, high);
		
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		
		return root;
				
				
    }
	
	public static void main(String[] args) {
		TreeNode s = new TreeNode(3);
		 s.left = new TreeNode(0);
		 s.right = new TreeNode(4);

		 s.left.right = new TreeNode(2);
		 s.left.right.left = new TreeNode(1);
		 
		 TrimBST obj = new TrimBST();
		 System.out.println(obj.trimBST(s, 1, 3));
	}
}
