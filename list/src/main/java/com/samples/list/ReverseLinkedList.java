package com.samples.list;

public class ReverseLinkedList {
	
	private void print(ListNode node)
	{
		while(node != null)
		{
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	public ListNode reverseList(ListNode head) {
		ListNode newListHead = null;
        if(head != null)
        {
        	newListHead = new ListNode(head.val);
        	
        ListNode tmpNode = head.next;
//        ListNode lastNewNode = tmpNode;
		while(tmpNode != null)
		{
			
			ListNode newNode = new ListNode(tmpNode.val);
			newNode.next = newListHead;
			newListHead = newNode;
			tmpNode = tmpNode.next;
		}
        }
		return newListHead;
    }
	
	private ListNode formLinedList()
	{
		ListNode head = new ListNode(1);
		ListNode node = new ListNode(2);
		head.next = node;
		for(int i = 3 ; i < 6; i++)
		{
//			print(node);
			node.next = new ListNode(i);
			node = node.next;
			
		}
		return head;
	}
	
	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		ListNode head = list.formLinedList();
		list.print(head);
		
		ListNode reverseList = list.reverseList(head);
		list.print(reverseList);
	}
	
	 class ListNode {
		     int val;
		     ListNode next;
		    ListNode(int x) { val = x; }
		 }
}
