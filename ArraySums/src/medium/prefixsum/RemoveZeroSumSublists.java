package medium.prefixsum;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/submissions/


 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return val + "==>" + (next == null ? "" : next.toString());
    }
}
public class RemoveZeroSumSublists {

	
	 
	 
	
public ListNode removeZeroSumSublists(ListNode head) {
        
	Map<Integer, ListNode> prefixSumMap = new HashMap<>();
	ListNode dummy = new ListNode();
	dummy.next = head;
	prefixSumMap.put(0, dummy);
	int sum = 0;
	while(head != null)
	{
		sum += head.val;
		if(prefixSumMap.containsKey(sum))
		{
			ListNode prev = prefixSumMap.get(sum);
			int prevSum = sum - head.val;
			while(prevSum != sum)
			{
				prevSum -= prefixSumMap.remove(prevSum).val;
			}
			prev.next = head.next;
			
		}
		else
		{
			prefixSumMap.put(sum, head);
		}
		head = head.next;
		
	}
	
	return dummy.next;
    }

	public static void main(String[] args) {
		
		RemoveZeroSumSublists obj = new RemoveZeroSumSublists();

		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(-3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(1);
		
		System.out.println(obj.removeZeroSumSublists(head));
		
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(-3);
		head.next.next.next.next = new ListNode(-1);
		
		System.out.println(obj.removeZeroSumSublists(head));
	}
}
