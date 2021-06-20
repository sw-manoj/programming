package Medium;


   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
   
   
 
public class ListAddTwoNumbers {

//	https://leetcode.com/problems/add-two-numbers/
	
	public static void main(String[] args) {
		ListAddTwoNumbers addNum = new ListAddTwoNumbers();
		
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(7);
		
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);
		l2.next.next.next = new ListNode(7);
		
		ListNode res = addNum.addTwoNumbers(l1, l2);
		while(res != null)
		{
			System.out.println(res.val);
			res= res.next;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		ListNode result = new ListNode();
		ListNode head = result;
		int reminder = 0;
		while(l1 != null || l2 != null)
		{
			
			int res = 0;
			if(l1 != null)
			{
				res = res+l1.val;
				l1= l1.next;
			}
			
			if(l2 != null)
			{
				res = res+l2.val;
				l2= l2.next;
			}
			res = res + reminder;
			if (res > 9)
			{
				reminder = res / 9;
				res = res - 10;
			}
			else
			{
				reminder = 0;
			}
			ListNode node = new ListNode(res);
			result.next = node;
			result = result.next;
		}
		
		if(reminder > 0) {
			ListNode node = new ListNode(reminder);
			result.next = node;
			result = result.next;
		}
		
		return head.next;
    }
}
