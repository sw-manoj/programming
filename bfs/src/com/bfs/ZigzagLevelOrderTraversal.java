package com.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  TreeNode(int x) { val = x; }
};

public class ZigzagLevelOrderTraversal {

//	https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
	
	
	public List<List<Integer>> zigzagLevelOrder_iter2(TreeNode root) {
	    if (root == null) {
	      return new ArrayList<List<Integer>>();
	    }

	    List<List<Integer>> results = new ArrayList<List<Integer>>();

	    // add the root element with a delimiter to kick off the BFS loop
	    LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
	    node_queue.addLast(root);
	    node_queue.addLast(null);

	    LinkedList<Integer> level_list = new LinkedList<Integer>();
	    boolean is_order_left = true;

	    while (node_queue.size() > 0) {
	      TreeNode curr_node = node_queue.pollFirst();
	      if (curr_node != null) {
	        if (is_order_left)
	          level_list.addLast(curr_node.val);
	        else
	          level_list.addFirst(curr_node.val);

	        if (curr_node.left != null)
	          node_queue.addLast(curr_node.left);
	        if (curr_node.right != null)
	          node_queue.addLast(curr_node.right);

	      } else {
	        // we finish the scan of one level
	        results.add(level_list);
	        level_list = new LinkedList<Integer>();
	        // prepare for the next level
	        if (node_queue.size() > 0)
	          node_queue.addLast(null);
	        is_order_left = !is_order_left;
	      }
	    }
	    return results;
	  }
	
	public List<List<Integer>> zigzagLevelOrder_iter(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		LinkedList<TreeNode> queue =  new LinkedList<TreeNode>();
		queue.add(root);
		boolean addFromLeft = true;
		
		while(!queue.isEmpty())
		{
			int len = queue.size();
			LinkedList<Integer> list = new LinkedList<Integer>();
			for(int i = 0 ; i < len; i++)
			{
				TreeNode node = queue.remove(); 
				
				if(addFromLeft)
				{
					list.addLast(node.val);
				}
				else {
					list.addFirst(node.val);
				}
				if(node.left != null)
				{
					queue.add(node.left);
				}
				if(node.right != null)
				{
					queue.add(node.right);
				}
			}
			result.add(list);
			addFromLeft = !addFromLeft;
		}
		return result;
    }
	

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(root, 0, result);
		return result;
    }
	
	private void helper(TreeNode node, int level, List<List<Integer>> result)
	{
		if(node == null)
		{
			return;
		}
		
		if(result.size() == level)
		{
			List<Integer> level_list = new LinkedList<Integer>();
			level_list.add(node.val);
			result.add(level_list);
		}else {
			if(level % 2 == 0)
			{
				result.get(level).add(node.val);
			}
			else {
				result.get(level).add(0, node.val);
			}
		}
		
		if(node.left != null)
		{
			helper(node.left, level+1, result);
		}
		
		if(node.right != null)
		{
			helper(node.right, level+1, result);
		}
	}
	

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		
		ZigzagLevelOrderTraversal obj = new ZigzagLevelOrderTraversal();
		
		System.out.println(obj.zigzagLevelOrder(root));
		
		System.out.println(obj.zigzagLevelOrder_iter(root));
	}
	

	 
}
