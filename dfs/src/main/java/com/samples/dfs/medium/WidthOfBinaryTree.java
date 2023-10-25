package com.samples.dfs.medium;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/maximum-width-of-binary-tree/
public class  WidthOfBinaryTree {

	class Node
	{
		TreeNode tree;
		int index;
		Node(TreeNode n, int i )
		{
			index = i;
			tree = n;
		}
	}
	public int widthOfBinaryTree(TreeNode root) {
        int maxLen = Integer.MIN_VALUE;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 1));
        
        
        while(!queue.isEmpty())
        {
        	int size = queue.size();
        	Node head = queue.peek();
        	Node elem = null;

        	for(int i = 0 ; i < size; i++)
        	{
        		elem = queue.poll();
        		
        		if(elem.tree.left != null)
        		{
        			queue.offer(new Node(elem.tree.left,2 * elem.index));

        		}
        		
        		if(elem.tree.right != null)
        		{
            		queue.offer(new Node(elem.tree.right,2 * elem.index + 1));

        		}
        		
        	
        		
        	}
        	
        	maxLen = Math.max(maxLen, elem.index - head.index + 1);
        }
        
        return maxLen;
    }
}
