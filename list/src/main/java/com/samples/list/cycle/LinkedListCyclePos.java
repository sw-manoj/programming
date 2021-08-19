package com.samples.list.cycle;


public class LinkedListCyclePos {

//	https://leetcode.com/problems/linked-list-cycle-ii/
	
//	https://www.youtube.com/watch?v=LUm2ABqAs1w why it works
	 public ListNode detectCycle(ListNode head) {
		 if(head == null) return head;
		 ListNode tort = head;
		 ListNode hare = head;
		 boolean cycleFound = false;
		 while(hare.next != null && hare.next.next != null)
		 {
			 tort = tort.next;
			 hare = hare.next.next;
			 if(tort == hare)
			 {
				 cycleFound = true;
				 break;
			 }
		 }
		 if(!cycleFound)
		 {
			 return null;
		 }
		 hare = head;
		 System.out.println(hare.val + "==" + tort.val);
		 while(hare != tort)
		 {
			 hare = hare.next;
			 tort = tort.next;
		 }
		 return hare;
	        
	  }
	 
	 public static void main(String[] args) {
			LinkedListCyclePos obj = new LinkedListCyclePos();
			
			ListNode l1 = new ListNode(1);
			l1.next = new ListNode(2);
//			l1.next.next = l1;
			l1.next.next = new ListNode(4);
			l1.next.next.next = new ListNode(5);
//			l1.next.next.next.next = l1.next;
			System.out.println(obj.detectCycle(l1));
		}
}
