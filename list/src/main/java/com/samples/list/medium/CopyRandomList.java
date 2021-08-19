package com.samples.list.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/copy-list-with-random-pointer


//Definition for a Node.
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	    
	    @Override
	    public String toString() {
	    return val + "=>" + next;
	    }
	}
	
	
public class CopyRandomList {

	public Node copyRandomList_SpaceOpt(Node head) {
		Node ptr = head;
		
		while(ptr != null)
		{
			Node newNode = new Node(ptr.val);
			
			newNode.next = ptr.next;
			ptr.next = newNode;
			
			ptr = newNode.next;
		}
				
		ptr = head;
		while(ptr != null)
		{
			Node random = ptr.random;
			
			if(random != null)
			{
				ptr.next.random = random.next;
			}
			ptr = ptr.next.next;
		}
		
		
		ptr = head;
		Node copyNode = new Node(0);
		Node dummy = copyNode;
		while(ptr != null)
		{
			copyNode.next = ptr.next;
			copyNode = copyNode.next;
			
			
			//recoving the original list
			ptr.next = ptr.next.next;
			
			//moving on
			ptr = ptr.next;
		}
		return dummy.next;
	}
	

	public Node copyRandomList_map(Node head) {
        Map<Node, Node> map = new HashMap<>();
        
        
        Node newNode = new Node(0);
        Node dummy = newNode;   
//        map.put(head, newNode);
//        head = head.next;
        
        while(head != null)
        {
        	Node node = map.get(head);
        	if(node == null)
        	{
        		node = new Node(head.val);
        		map.put(head, node);
        	}
        	
        	if(head.random != null)
        	{
	        	if(map.containsKey(head.random))
	        	{
	        		node.random = map.get(head.random);
	        	}
	        	else
	        	{
	        		Node randomNode = new Node(head.random.val);
	        		map.put(head.random, randomNode);
	        		node.random = randomNode;
	        	}
        	}
        	
        	
        	newNode.next = node;
        	newNode = newNode.next;
        	
        	head = head.next;
        }
		
		return dummy.next;
    }
	
	
	public static void main(String[] args) {
		Node one = new Node(1);
		one.next = new Node(2);
		one.next.next = new Node(3);
		
		CopyRandomList obj = new CopyRandomList();
		System.out.println(obj.copyRandomList_SpaceOpt(one));
		
	}
}
