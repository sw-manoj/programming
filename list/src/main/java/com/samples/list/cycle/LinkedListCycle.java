package com.samples.list.cycle;


class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
     
     @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return val + "->" + next;
    }
}
public class LinkedListCycle {
	
//	https://leetcode.com/problems/linked-list-cycle/
	
	public static void main(String[] args) {
		LinkedListCycle obj = new LinkedListCycle();
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
//		l1.next.next = l1;
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(5);
		l1.next.next.next.next = l1.next;
		System.out.println(obj.hasCycle(l1));
	}

	public boolean hasCycle(ListNode head) {
		if(head == null)
		{
			return false;
		}
		ListNode hare = head; ListNode tort = head;
		while(hare.next != null && hare.next.next != null)
		{
			tort = tort.next;
			hare = hare.next.next;
			if(hare == tort)
			{
				return true;
			}
		}
		return false;
    }
}
