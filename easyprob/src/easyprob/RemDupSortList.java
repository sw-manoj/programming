package easyprob;

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return val + "=>" + next;
    }
}

public class RemDupSortList {

	
//	  Definition for singly-linked list.
	  
	  
	  public static void main(String[] args) {
		
		  ListNode head = new ListNode(1);
		  head.next = new ListNode(1);
		  head.next.next = new ListNode(2);
		  head.next.next.next = new ListNode(2);
		  head.next.next.next.next = new ListNode(3);
//		  head.next.next.next.next.next = new ListNode(3);
		  RemDupSortList remDup = new RemDupSortList();
		  remDup.displayList(head);
		  System.out.println("=====================");
		  ListNode res = remDup.deleteDuplicates(head);
		  remDup.displayList(res);
	}
	 
	  private void displayList(ListNode head)
	  {
		 ListNode tmp = head;
		while(tmp != null)  
		{
			System.out.println(tmp.val);
			tmp = tmp.next;
		}
	  }
	  
	  public ListNode deleteDuplicates_leetcodesol(ListNode head) {
	        if(head == null || head.next==null){
	            return head;
	        }
	        ListNode dummy = new ListNode(0);
	        ListNode l = head.next;
	        dummy.next = head;
	        while(l!=null){
	            if(l.val != head.val){
	                head.next = l;
	                head=head.next;
	            }else{
	                if(l.next == null){
	                    head.next = null;
	                    break;
	                }
	            }
	            l=l.next;
	        }
	        return dummy.next;
	    }
	  
	  public ListNode deleteDuplicates(ListNode head) {
		  ListNode tmp = head;
		  if(head == null)
		  {
			  return head;
		  }
		  ListNode lastNode = tmp;
		  while(tmp.next != null)
		  {
			  ListNode next = tmp.next;
			  if(lastNode.val == next.val)
			  {
				  tmp.next = next.next;
			  }
			  else
			  {
				  lastNode = next;
				  tmp = tmp.next;
			  }
			  
		  }
		  return head;
        
    }	
}

