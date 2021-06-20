package com.samples.list;

import java.util.Iterator;
import java.util.LinkedList;

public class FindLoopInList {
	
	Node head;
	 /* Inserts a new Node at front of the list. */
    public void push(int new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 3. Make next of new Node as head */
        new_node.next = head; 
  
        /* 4. Move the head to point to new Node */
        head = new_node; 
    } 
  
    // Returns true if there is a loop in linked 
    // list else returns false. 
//    static boolean detectLoop(Node h) 
//    { 
//        HashSet<Node> s = new HashSet<Node>(); 
//        while (h != null) { 
//            // If we have already has this node 
//            // in hashmap it means their is a cycle 
//            // (Because you we encountering the 
//            // node second time). 
//            if (s.contains(h)) 
//                return true; 
//  
//            // If we are seeing the node for 
//            // the first time, insert it in hash 
//            s.add(h); 
//  
//            h = h.next; 
//        } 
//  
//        return false; 
//    } 
  
    /* Driver program to test above function */
    public static void main(String[] args) 
    { 
    	FindLoopInList llist = new FindLoopInList(); 
  
        llist.push(20); 
        llist.push(4); 
        llist.push(15); 
        llist.push(10); 
  
        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head; 
  
        Node cycleNode = llist.isCycleExist(llist.head);
        if(cycleNode != null)
        {
        	Node startingNode = llist.startNode(llist.head, cycleNode);
        	System.out.println(startingNode.val);
        }
        else {
        	System.out.println("no cycle found");
        }
    } 
	
	private  Node isCycleExist(Node head)
	{
		if(head == null)
		{
			return null;
		}
		Node hare = head; Node tort = head;
		while(hare.next != null && hare.next.next != null)
		{
			tort = tort.next;
			hare = hare.next.next;
			if(hare.val == tort.val)
			{
				System.out.println(hare.val + " is part of cycle");
				return hare;
			}
		}
		return null;
	}
	
	private Node startNode(Node head, Node cycleNode)
	{
		Node tmp = head;
		while(tmp != null && cycleNode != null)
		{
			if(tmp.val == cycleNode.val)
			{
				return tmp;
			}
			tmp = tmp.next;
			cycleNode = cycleNode.next;
		}
		return null;
	}
	private LinkedList formList(int[] a)
	{
		LinkedList<Integer> list = new LinkedList<Integer>(); 
		for(int i = 0 ; i < a.length ; i++)
		{
			list.add(i);
		}
		return list;
	}

	class Node<E>
	{
		E val;
		Node<E> next;
		Node(E d) 
        { 
            val = d; 
            next = null; 
        } 
	}
}
