package com.bfs;

import com.bfs.PopulateNextPointerNode.Node;

public class PopuNextPointer2 {
	
//	https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/solution/
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


	
	//same as below just done in single method.
	public Node connect_mysolt(Node root) {
		if(root == null)
        {
            return root;
        }
		
		Node leftnode = root;
		
		
		while(leftnode != null) // this problem has all nodes at leaf level ( perfect binary tree where all leaves are on the same level) hence using .left!= null condition to terminate from BFS
		{
			Node levelNode = leftnode;
			leftnode = null;
			Node prev = null;
			while(levelNode != null)
			{
				if(levelNode.left != null)
				{
					if(prev == null)
					{
						leftnode = levelNode.left;
					}
					else
					{
						prev.next = levelNode.left;
					}
					prev = levelNode.left;
				}
				if(levelNode.right != null)
				{
					if(prev == null)
					{
						prev = levelNode.right;
						leftnode = levelNode.right;
					}
					else
					{
						prev.next = levelNode.right;
					}
					prev = levelNode.right;
				}
				
				levelNode = levelNode.next;
			}
		}
		
		return root;
	}
	
	 Node prev, leftmost;
	    
	    public void processChild(Node childNode) {
	        
	        if (childNode != null) {
	            
	            // If the "prev" pointer is alread set i.e. if we
	            // already found atleast one node on the next level,
	            // setup its next pointer
	            if (this.prev != null) {
	                this.prev.next = childNode;
	                    
	            } else {
	                
	                // Else it means this child node is the first node
	                // we have encountered on the next level, so, we
	                // set the leftmost pointer
	                this.leftmost = childNode;
	            }    
	                
	            this.prev = childNode; 
	        }
	    }
	        
	    public Node connect(Node root) {
	        
	        if (root == null) {
	            return root;
	        }
	        
	        // The root node is the only node on the first level
	        // and hence its the leftmost node for that level
	        this.leftmost = root;
	        
	        // Variable to keep track of leading node on the "current" level
	        Node curr = leftmost;
	        
	        // We have no idea about the structure of the tree,
	        // so, we keep going until we do find the last level.
	        // the nodes on the last level won't have any children
	        while (this.leftmost != null) {
	            
	            // "prev" tracks the latest node on the "next" level
	            // while "curr" tracks the latest node on the current
	            // level.
	            this.prev = null;
	            curr = this.leftmost;
	            
	            // We reset this so that we can re-assign it to the leftmost
	            // node of the next level. Also, if there isn't one, this
	            // would help break us out of the outermost loop.
	            this.leftmost = null;
	            
	            // Iterate on the nodes in the current level using
	            // the next pointers already established.
	            while (curr != null) {
	                
	                // Process both the children and update the prev
	                // and leftmost pointers as necessary.
	                this.processChild(curr.left);
	                this.processChild(curr.right);
	                
	                // Move onto the next node.
	                curr = curr.next;
	            }
	        }
	                
	        return root ;
	    }
}
