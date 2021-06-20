package Medium;


//  Definition for singly-linked list.
//   class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
 
public class RemoveNthNodeList {
	
	public static void main(String[] args) {
//		Input: head = [1,2,3,4,5], n = 2
//		Output: [1,2,3,5]
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		RemoveNthNodeList nodeList = new RemoveNthNodeList();
		
		ListNode res = nodeList.removeNthFromEnd(head, 1);
		
		nodeList.printList(res);
		
	}
	
	void printList(ListNode res)
	{
		while(res != null)
		{
			System.out.println(res.val);
			res = res.next;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
	    dummy.next = head;
        ListNode nNode = dummy;
        int i = 0;
        ListNode temp = dummy;
        while(temp != null)
        {
        	if(i > n)
        	{
        		nNode = nNode.next;
        	}
        	i++;
        	temp = temp.next;
        }
        nNode.next = nNode.next.next;  
        
		return dummy.next;
    }
}
