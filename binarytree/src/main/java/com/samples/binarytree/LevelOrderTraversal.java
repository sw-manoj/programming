package com.samples.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

//	https://leetcode.com/problems/binary-tree-level-order-traversal/solution/
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		
		LevelOrderTraversal lorder = new LevelOrderTraversal();
		System.out.println(lorder.levelOrder(root));
		System.out.println(lorder.levelOrder1(root));

	}
	
	public List<List<Integer>> levelOrder1(TreeNode root)
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		int level = 0;
		
		while(!queue.isEmpty())
		{
			int q_len = queue.size();
			res.add(new ArrayList<Integer>());
			for(int i = 0 ; i < q_len ; i++)
			{
				TreeNode node = queue.remove();
				res.get(res.size()-1).add(node.val);
				if(node.left !=null)
				{
					queue.add(node.left);
				}
				
				if(node.right !=null)
				{
					queue.add(node.right);
				}
			}
		}
        return res;
	}
	
	//recursive level order traversal
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, 0, res);
        return res;
		
    }
	
	private void helper(TreeNode node, int level, List<List<Integer>> res)
	{
		if(node == null)
		{
			return;
		}
		if(res.size() == level)
		{
			res.add(new ArrayList<Integer>());
		}
		
		res.get(level).add(node.val);
		
		if(node.left != null)
		{
			helper(node.left, level+1, res);
		}
		
		if(node.right != null)
		{
			helper(node.right, level+1, res);
		}
	}
}
