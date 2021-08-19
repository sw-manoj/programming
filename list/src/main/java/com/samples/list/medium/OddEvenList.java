package com.samples.list.medium;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    @Override
    public String toString() {
    	return val + "==>" + (next == null ? "" : next);
    }
}

//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenList {

	
	  
	public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode oddDummy = odd;
        ListNode evenDummy = even;

        int  count = 1;
        
        while(head != null)
        {
        	if(count % 2 == 0)
        	{
        		even.next = head;
        		even = even.next;
        	}else
        	{
        		odd.next = head;
        		odd = odd.next;
        	}
        	count++;
        	head = head.next;
        }
        even.next = null;
        odd.next = evenDummy.next;
//        System.out.println(evenDummy);
		return oddDummy.next;
    }
	
	public static void main(String[] args) {
		OddEvenList obj = new OddEvenList();
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		obj.oddEvenList(l1);
		System.out.println(obj.oddEvenList(l1));
	}
}
