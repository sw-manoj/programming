package easyprob;

public class IntersectList {

	public static void main(String[] args) {
		IntersectList intList = new IntersectList();
		ListNode four = new ListNode(4);
		four.next = new ListNode(6);
		four.next.next = new ListNode(8);
		ListNode head = new ListNode(1);
		  head.next = new ListNode(2);
		  head.next.next = four;
		  
		  ListNode headB = new ListNode(9);
		  headB.next = four;
//		  headB.next = new ListNode(8);

		System.out.println(intList.getIntersectionNode(head, headB));
		System.out.println(intList.getIntersectionNode1(head, headB));
	}
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        ListNode p1 = headA;
	        ListNode p2 = headB;
	        
	        while(p1 != p2)
	        {
	        	p1 = p1 == null ? headB : p1.next;
	        	p2 = p2 == null ? headA : p2.next;
	        }
	        return p1;
	 }





	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		ListNode p1 = headA;
		ListNode p2 = headB;

		while(p1 != p2) {
			p1 = p1 == null ? headB : p1.next;
			p2 = p2 == null ? headA : p2.next;
		}
		return p1;
	}
}



