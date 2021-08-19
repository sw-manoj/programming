package com.bfs;


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class NextPointer2ndTry {

	public Node connect(Node root) {
		
		Node left = root;
		
		
		while(left != null)
		{
			Node levelLeft = new Node(0);
			Node dummy = levelLeft;
			while(left != null )
			{
				if(left.left != null )
				{
					levelLeft.next = left.left;
					levelLeft = levelLeft.next;
				}
				
				if(left.right != null )
				{
					levelLeft.next = left.right;
					levelLeft = levelLeft.next;

				}
				left = left.next;
			}
			left = dummy.next;
		}
		return root;
	}
}
