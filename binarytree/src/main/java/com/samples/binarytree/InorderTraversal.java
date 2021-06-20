package com.samples.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		InorderTraversal inorder = new InorderTraversal();
		
		System.out.println(inorder.inorderTraversal(root));
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
	
	
}
