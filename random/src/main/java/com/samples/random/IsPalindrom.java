package com.samples.random;

public class IsPalindrom {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	ListNode frontNode;

	public boolean isPalindrome1(ListNode head) {
		frontNode = head;
		return recursiveCheck(head);
	}

	//
//	we reach end using recursion and then mainkly  to comapre front nade value and current node value for equality 
//	and move 1 step forward for frontNode on way back in recurssion . 
//	so when the comparssion fails it reurns fals which keeps returning fasle until the end of start  
	private boolean recursiveCheck(ListNode currentNode) {
		if (currentNode != null) {
			// 1st condition basically to reach and end of list also mainly to check if
			if (!recursiveCheck(currentNode.next))
				return false;
			if (currentNode.val != frontNode.val)
				return false;
			frontNode = frontNode.next;
		}
		return true;
	}
	
	ListNode getFistHalf(ListNode node)
	{
		ListNode slow= node;
		ListNode fast = node;
		
		while(fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast =  fast.next.next;
		}
		return slow;
	}
	
	ListNode reverseList(ListNode node)
	{
		ListNode prev = null;
		ListNode curr = node;
		
		ListNode nextNode =  null;
		
		while(curr != null)
		{
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		return prev;
	}
	
	public boolean isPalindrome(ListNode head) {
		 if (head == null) return true;
		ListNode firstHalf = getFistHalf(head);
		ListNode reverseList = reverseList(firstHalf.next);
		ListNode p2 = reverseList;
		ListNode p1 = head;
		
		boolean result = true;
		while( p2 != null)
		{
			if(p1.val != p2.val)
			{
				result = false;
				break;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return result;
	}
}
