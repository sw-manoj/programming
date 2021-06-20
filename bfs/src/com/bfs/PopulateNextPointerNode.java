package com.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulateNextPointerNode {
//	https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
	
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	
	
//	perfect binary tree 
	public Node connect_space_opt(Node root) {
		
		if(root == null)
        {
            return root;
        }
		
		Node leftnode = root;
		
		while(leftnode.left != null) // this problem has all nodes at leaf level ( perfect binary tree where all leaves are on the same level) hence using .left!= null condition to terminate from BFS
		{
			Node head = leftnode;
			while(head!= null)
			{
				head.left.next = head.right;
				
				if(head.next != null)
				{
					head.right.next = head.next.left;
				}
				head = head.next;
			}
			leftnode = leftnode.left;
		}
		
		return root;
	}
	
	public Node connect(Node root) {
        
		if(root == null)
        {
            return root;
        }
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		Node head = root;
		int level = 0;
		
		while(!queue.isEmpty())
		{
			int q_len = queue.size();
			for(int i = 0 ; i < q_len ; i++)
			{
				Node node = queue.poll();
				if(i < q_len-1)
				{
					node.next = queue.peek();
				}
				if(node.left !=null)
				{
					queue.offer(node.left);
				}
				
				if(node.right !=null)
				{
					queue.offer(node.right);
				}
			}
		}
        return head;
    }
}
