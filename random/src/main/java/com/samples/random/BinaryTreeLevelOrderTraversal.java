package com.samples.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BinaryTreeLevelOrderTraversal {

	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 public static void main(String[] args) {
		 BinaryTreeLevelOrderTraversal btot = new BinaryTreeLevelOrderTraversal();
		 
		 btot.execute();
	}
	 
	 private void execute()
	 {
		 TreeNode root = new TreeNode(3);
		 root.left = new TreeNode(2);
		 root.right = new TreeNode(4);
		 root.right.left = new TreeNode(8);
		 root.right.right = new TreeNode(10);
		 root.left.left = new TreeNode(7);
		 levelOrderBottom(root);
	 }
	
	    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	    	
	    	Queue<TreeNode> queue = new LinkedBlockingDeque<TreeNode>();
	    	if(root == null) return null; 
	    	
	    	queue.add(root);
			LinkedList<List<Integer>> res = new LinkedList<>();
	    	while(!queue.isEmpty())
	    	{
	    		res.addFirst(addChild(queue));
	    	}
	    	
	    	Collections.reverse(res);
	    	System.out.println(res);
			return res;
	        
	    }
	    
	    private List<Integer> addChild(Queue<TreeNode> queue)
	    {
	    	List<Integer> list = new ArrayList<Integer>();
	    	int size = queue.size();
	    	int i = 0 ;
	    	while(i < size)
	    	{
	    		TreeNode node = queue.poll();
	    		if(node.left != null)  queue.add(node.left); 
	    		if(node.right != null)  queue.add(node.right);
	    		
	    		i++;
	    		list.add(node.val);
	    	}
	    	
	    	return list;
	    }
	
}
