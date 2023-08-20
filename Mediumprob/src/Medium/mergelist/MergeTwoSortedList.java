package Medium.mergelist;


class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
     
     @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return val + "->" + next;
    }
};

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedList {

	
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		MergeTwoSortedList obj = new MergeTwoSortedList();
//		System.out.println(obj.mergeTwoLists2(l1, l2));

		System.out.println(obj.mergeTwoLists3(l1, l2));

	}
	
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		
		while(l1!= null && l2 != null)
		{
			if(l1.val < l2.val)
			{
				curr.next =  l1;
				l1 = l1.next;
			}else
			{
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		
		if(l1 != null)
		{
			curr.next = l1;
		}else if(l2 != null)
		{
			curr.next = l2;
		}
		
		return dummy.next;
		
	}
public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        
		ListNode newNode = new ListNode(0);
		ListNode dummy = newNode;
		while(l1 != null && l2 != null)
		{
			if(l1.val < l2.val)
			{
				newNode.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			else
			{
				newNode.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			newNode = newNode.next;
		}
		
		if(l1 != null)
		{
			newNode.next = l1;
		}
		
		if(l2 != null)
		{
			newNode.next = l2;
		}
        return dummy.next;
    }
	
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        return helper(l1, l2);
    }


private ListNode helper(ListNode l1, ListNode l2)
{
	ListNode newNode = null;
    System.out.println(l1 + "==" + l2);
	if(l1 == null && l2 ==null)
	{
		return newNode;
	}
	if(l1 == null)
	{
        System.out.println("working?");
		newNode = new ListNode(l2.val);
		l2 = l2.next;
        //newNode.next = helper(l1, l2);
	//return newNode;
	}
	else if(l2 == null)
	{
        System.out.println(l1 + "==" + l2);
		newNode = new ListNode(l1.val);
		l1 = l1.next;
//newNode.next = helper(l1, l2);
        //return newNode;
	}
	else if(l2.val < l1.val)
	{
		newNode = new ListNode(l2.val);
		l2 = l2.next;
	}
	else
	{
		newNode = new ListNode(l1.val);
		l1 = l1.next;
	}
	newNode.next = helper(l1, l2);
	return newNode;
	
	
}


	public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode dummy = head;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val)
			{
				head.next = l1;
				l1 = l1.next;
			}
			else {
				head.next = l2;
				l2  = l2.next;
			}
			head = head.next;
		}

		if(l1 != null)
		{
			head.next = l1;
		}

		if(l2 != null)
		{
			head.next = l2;
		}
		return dummy.next;
	}
}
