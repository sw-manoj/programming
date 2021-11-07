package com.samples.list;


class ListNode
{
	ListNode next;
	int val;
	ListNode(int v) {val = v;}
}
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/
public class RemoveDupSortedList {

	public ListNode deleteDuplicates(ListNode head) {
        
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = null;
		
		while(head != null)
		{
			if(prev == null)
			{
				prev = head;
				head = head.next;
				continue;
			}
			
			if(prev.val == head.val)
			{
				prev.next = head.next;
			}else
			{
				prev = head;
			}
			head = head.next;
		
		}
		return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		RemoveDupSortedList obj = new RemoveDupSortedList();
		System.out.println(obj.deleteDuplicates(head));
	}
}
