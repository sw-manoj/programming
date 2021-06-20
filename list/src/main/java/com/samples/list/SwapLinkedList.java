package com.samples.list;

import com.samples.list.FindLoopInList.Node;

public class SwapLinkedList {

	//wrong
    public ListNode swapPairs(ListNode head) {
        
    	return null;
    }
    ListNode head;
	 /* Inserts a new Node at front of the list. */
   public void push(int new_data) 
   { 
       /* 1 & 2: Allocate the Node & 
                 Put in the data*/
	   ListNode new_node = new ListNode(new_data); 
 
       /* 3. Make next of new Node as head */
       new_node.next = head; 
 
       /* 4. Move the head to point to new Node */
       head = new_node; 
   } 

    
    private ListNode swap(ListNode node)
    {
    	ListNode newHead = node;
    	while(node != null && node.next != null)
    	{
    		ListNode tmp = node;
    		
    		node = node.next;
    		tmp.next = node.next;
    		node.next = tmp;
    		
    	}
    	return null;
    }
    public class ListNode {
    	     int val;
    	      ListNode next;
    	      ListNode(int x) { val = x; }
    }

}
