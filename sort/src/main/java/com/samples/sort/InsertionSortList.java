package com.samples.sort;


  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      
      @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	  if(next == null) return val + "";
    	return val + "== " + next;
    }
  }
 
  
//  https://leetcode.com/problems/insertion-sort-list/submissions/

public class InsertionSortList {
	
	public static void main(String[] args) {
		InsertionSortList obj = new InsertionSortList();
		ListNode head = new ListNode(4);
		head.next = new ListNode(7);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		System.out.println(obj.insertionSortList_opt(head));
		
//		InsertionSortList obj = new InsertionSortList();
//		ListNode head = new ListNode(-1);
//		head.next = new ListNode(5);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(0);
//
//		System.out.println(obj.insertionSortList_opt(head));
	}

	public ListNode insertionSortList_opt(ListNode head) {
		ListNode dummy = new ListNode();
		
		ListNode curr = head;
		
		while(curr != null)
		{
			ListNode prev = dummy;
			while(prev.next != null && prev.next.val < curr.val)
			{
				prev = prev.next;
			}
			
			ListNode next = curr.next;
			curr.next = prev.next;
			prev.next = curr;
			
			curr = next;
		}
		
		return dummy.next;
	}
	public ListNode insertionSortList(ListNode head) {
		if(head == null) return head;
        ListNode first = new ListNode(head.val);
        
        ListNode iter = head.next;
        
        while(iter != null)
        {
        	ListNode  tmp = first;
        	ListNode prev = null;
        	while(tmp != null && tmp.val <  iter.val)
        	{
        		prev = tmp;
        		tmp = tmp.next;
        	}
        	
        	ListNode newNode = new ListNode(iter.val);
        	if(prev == null)
        	{
        		prev = newNode;
        		prev.next = tmp;
        		first = prev;
        	}else
        	{
        		if(prev.next != null)
            	{
            		newNode.next = prev.next;
            	}
            	prev.next = newNode;
            	
        	}
        	
        	
        	iter = iter.next;
        }
		
		return first;
    }
	
	
}
