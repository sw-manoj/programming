package com.samples.random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import com.samples.random.Codec.TreeNode;

public class SymmentricTree {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	      
	      @Override
	    public String toString() {
	    	// TODO Auto-generated method stub
	    	return String.valueOf(val);
	    }
	  }
	
	public static void main(String[] args) {
		SymmentricTree tree = new SymmentricTree();
		tree.generateTree();
	}
	
	private void generateTree()
	{
		TreeNode root = new TreeNode(1);
		TreeNode tmp = new TreeNode(2); 
		root.left = new TreeNode(2); 
		root.right = new TreeNode(2); 
		
		root.left.left = new TreeNode(3); 
		root.left.right = new TreeNode(4); 
		root.right.left = new TreeNode(4); 
		root.right.right = new TreeNode(3); 
		
		System.out.println(isSymmetric(root));
	}
	 public boolean isSymmetric(TreeNode root) { 
		 Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    while (!q.isEmpty()) {
	        TreeNode t1 = q.poll();
	        TreeNode t2 = q.poll();
	        if (t1 == null && t2 == null) continue;
	        if (t1 == null || t2 == null) return false;
	        if (t1.val != t2.val) return false;
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    return true;
	    }
	 
	 private boolean checkListSymm(List<TreeNode> list)
	 {
		 int l = 0;
		 int r = list.size()-1;
		 while(l < r)
		 {
			 if( (list.get(l) == null && list.get(r) == null ) ||
					 (list.get(l) != null && list.get(r) != null && list.get(l).val == list.get(r).val)    ) 
			 {
				 l++;
				 r--;
			 }
			 else
			 {
				 return false;
			 }
		 }
		 return true;
	 }
}
