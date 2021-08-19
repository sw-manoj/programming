package com.samples.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		InorderTraversal inorder = new InorderTraversal();
		
//		System.out.println(inorder.inorderTraversal_2ndtry(root));
		
		System.out.println(inorder.inorder_iter(root));

	}
	
	public List<Integer> inorderTraversal_2ndtry(TreeNode root) {
        
		List<Integer> res = new ArrayList<Integer>();
		traverse2(root, res);
		return res;
    }
	
	private void traverse2(TreeNode root, List<Integer> res)
	{
		if(root == null) return ;
		
		traverse2(root.left, res);
		res.add(root.val);
		traverse2(root.right, res);

	}
	

	public List<Integer> inorderTraversal(TreeNode root) {
        
		List<Integer> res = new ArrayList<Integer>();
		traverse(root, res);
		return res;
    }
	
	private void traverse(TreeNode node, List<Integer> res)
	{
		if(node == null)
		{
			return;
		}
		
		traverse(node.left, res);
		
		res.add(node.val);
		traverse(node.right, res);

	}
	
	public List<Integer> inorder_iter(TreeNode root) {
	    Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
    	TreeNode node = root;
	    while (node != null || stack.size() > 0) {
	      while (node != null) {
	        stack.push(node);
	        node = node.left;
	      }
	      node = stack.pop();
	      res.add(node.val);
	      node = node.right;
	    }
	    return res;
	  }
	
	
	
}
