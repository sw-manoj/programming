package com.samples.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomUpLevelOrderTraversal {

//	https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		int level = 0;
		
		while(!queue.isEmpty())
		{
			int q_len = queue.size();
			res.addFirst( new ArrayList<Integer>());
			for(int i = 0 ; i < q_len ; i++)
			{
				TreeNode node = queue.remove();
				res.getFirst().add(node.val);
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
		
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		BottomUpLevelOrderTraversal obj = new BottomUpLevelOrderTraversal();
		System.out.println(obj.levelOrderBottom(root));
	}

}
