package com.samples.list;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode cur = dummy;
        int smallestValIndex = 0;
        int minVal = Integer.MAX_VALUE;
    	while(smallestValIndex != -1)
    	{
    		smallestValIndex = -1;
            minVal = Integer.MAX_VALUE;
	    	for(int i =0 ; i < lists.length ; i++)
	    	{
	    		if(lists[i] != null)
	    		{
		    		if(minVal > lists[i].val)
		    		{
		    			smallestValIndex = i;
		    			minVal =  lists[i].val;
		    		}
	    		}
	    			    	}
	    	if(smallestValIndex != -1)
	    	{
	    		cur.next = lists[smallestValIndex];
		    	lists[smallestValIndex] = lists[smallestValIndex].next;
		    	cur = cur.next;
	    	}
    	}
    	
    	return dummy.next;
    }
    
    public ListNode mergeKListsOptimised(ListNode[] lists) {
        if(lists == null || lists.length == 0)  return null;
        return mergeKLists(lists, 0, lists.length-1);
    }
    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if(left < right)
        {
            int mid = (left+right)/2;
            return merge(mergeKLists(lists, left, mid), mergeKLists(lists, mid+1, right));
        }
        return lists[left];
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode n = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                n.next = l1;
                l1 = l1.next;
                n = n.next;
            }
            else    {
                n.next = l2;
                l2 = l2.next;
                n = n.next;
            }
        }
        if(l1 != null)
            n.next = l1;
        if(l2 != null)
            n.next = l2;
        return head.next;
    }
    public class ListNode {
    	      int val;
    	      ListNode next;
    	      ListNode(int x) { val = x; }
    	 }
}
