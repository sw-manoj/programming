package com.samples.dfs.medium;

import java.util.ArrayDeque;
import java.util.Deque;


//https://leetcode.com/problems/validate-binary-search-tree
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
 
public class IsValidBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
//		root.left.left = new TreeNode(1);
		
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);

//		TreeNode root = new TreeNode(5);
//		root.left = new TreeNode(4);
//		root.right = new TreeNode(6);
		
		IsValidBST obj = new IsValidBST();
		System.out.println(obj.isValidBST(root));
	}
	public boolean isValid(TreeNode node, TreeNode low, TreeNode high)
	{
		if(node == null) return true;
		
		if(low != null && node.val <= low.val )
		{
			return false;
		}
		
		if(high != null && node.val >= high.val )
		{
			return false;
		}
		
		
		return isValid(node.left, low, node) && isValid(node.right, node, high);
	}
	public boolean isValidBST(TreeNode root) {
		
		
		return isValid(root, null, null);
    }
	
	 public boolean isValidBST_iter(TreeNode root) {
	        Deque<TreeNode> stack = new ArrayDeque();
	        Integer prev = null;

	        while (!stack.isEmpty() || root != null) {
	            while (root != null) {
	                stack.push(root);
	                root = root.left;
	            }
	            root = stack.pop();
	            // If next element in inorder traversal
	            // is smaller than the previous one
	            // that's not BST.
	            if (prev != null && root.val <= prev) {
	                return false;
	            }
	            prev = root.val;
	            root = root.right;
	        }
	        return true;
	    }
}
