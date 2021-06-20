package Medium;

public class SwapNodePairs {
	
//	https://leetcode.com/problems/swap-nodes-in-pairs/
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		SwapNodePairs sp = new SwapNodePairs();
		
		ListNode res = sp.swapPairs(head);
		
		while(res != null)
		{
			System.out.println(res.val);
			res = res.next;
		}
	}

	public ListNode swapPairs(ListNode head) {
        
		ListNode dummy = new ListNode();
		dummy.next = head;
        ListNode prevNode = dummy;

		while(head != null && head.next != null)
		{
			ListNode tmp = head;
			head = head.next;
			
			prevNode.next = head;
			tmp.next = head.next;
			head.next = tmp;
			
			prevNode = tmp;
			head = tmp.next;
		}
	return dummy.next;
    }
	
	 public ListNode swapPairs_clear(ListNode head) {

	        // Dummy node acts as the prevNode for the head node
	        // of the list and hence stores pointer to the head node.
	        ListNode dummy = new ListNode(-1);
	        dummy.next = head;

	        ListNode prevNode = dummy;

	        while ((head != null) && (head.next != null)) {

	            // Nodes to be swapped
	            ListNode firstNode = head;
	            ListNode secondNode = head.next;

	            // Swapping
	            prevNode.next = secondNode;
	            firstNode.next = secondNode.next;
	            secondNode.next = firstNode;

	            // Reinitializing the head and prevNode for next swap
	            prevNode = firstNode;
	            head = firstNode.next; // jump
	        }

	        // Return the new head node.
	        return dummy.next;
	    }
}
