package com.samples.sort;

public class SortList {

//	https://leetcode.com/problems/sort-list/
	public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;
        
        while(curr!= null)
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
	
	public ListNode sortList_mergesort(ListNode head) {
		if(head == null || head.next == null)
		{
			return head;
		}
		ListNode mid = getMid(head);
		ListNode left = sortList_mergesort(head);
		ListNode right = sortList_mergesort(mid);
		return merge(left, right);
	}
	
	public ListNode merge(ListNode left, ListNode right)
	{
		ListNode dummy = new ListNode();
		ListNode tail = dummy;
		
		while(left != null && right != null)
		{
			if(left.val <= right.val)
			{
				tail.next = left;
				left = left.next;
				tail = tail.next;
			}
			else
			{
				tail.next = right;
				right = right.next;
				tail = tail.next;
			}
		}
		
		tail.next = left == null ? right : left;
		return dummy.next;
	}
	
	private ListNode getMid(ListNode head)
	{
		ListNode midprev = null;
		while(head!= null && head.next != null)
		{
			midprev = midprev == null ? head : midprev.next;
			head = head.next.next;
		}
		
		ListNode mid = midprev.next;
		midprev.next = null;
		
		return mid;
	}
	
	public static void main(String[] args) {
		SortList obj = new SortList();
		ListNode head = new ListNode(4);
		head.next = new ListNode(7);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		System.out.println(obj.sortList_mergesort(head));
		System.out.println(head);
//		InsertionSortList obj = new InsertionSortList();
//		ListNode head = new ListNode(-1);
//		head.next = new ListNode(5);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(0);
//
//		System.out.println(obj.insertionSortList_opt(head));
	}
}
