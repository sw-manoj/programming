package com.samples.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


//https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/

   class TreeNodeList {
      int val;
      TreeNodeList left;
      TreeNodeList right;
      TreeNodeList next;
      TreeNodeList prev;
      TreeNodeList() {}
      TreeNodeList(int val) { this.val = val; }
      TreeNodeList(int val, TreeNodeList left, TreeNodeList right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
public class KthSmallestBST {

	public void helper(TreeNodeList node, int k ,LinkedList<Integer> arr)
	{
		if(node == null) return ;
		
		
		helper(node.left, k, arr);
		if(k == arr.size())
		{
			return ;
		}
		arr.add(node.val);
		if(k == arr.size())
		{
			return ;
		}
		helper(node.right, k, arr);
	}
	public int kthSmallest(TreeNodeList root, int k) {
		LinkedList<Integer> arr = new LinkedList<Integer>();
		helper(root, k, arr);
        return arr.getLast();
    }
	
	
//	What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
//	How would you optimize the kthSmallest routine?
	
	
	public void buildList(TreeNodeList node)
	{
		Stack<TreeNodeList> stack = new Stack<TreeNodeList>();
		TreeNodeList curr = node;
		TreeNodeList prev = null;
		while(curr != null  || stack.size() > 0)
		{
			while(curr != null)
			{
				stack.push(curr);
				curr = curr.left;
			}
			
			 curr = stack.pop();
			if(prev != null)
			{
				prev.next = curr;
				curr.prev = prev;
			}
			prev = curr;
			
			
			curr = curr.right;
			
		}
	}
	public void insert(TreeNodeList root, int n)
	{
//		if(root == null) return new TreeNodeList(n);
		
//		if(root.val > n)
//		{
//			root.left = insert(root.left, n);
//		}
//		else
//		{
//			root.right = insert(root.right, n);
//		}
//		return root;
		TreeNodeList prev = root.prev;
		while(root != null)
		{
			prev = root;
			if(root.val > n )
			{
				root = root.left;
			}
			else {
				root = root.right;
			}

		}
		TreeNodeList newNode = new TreeNodeList(n);
		
		if(prev.val < n)
		{
			prev.right = newNode;
			TreeNodeList tmp = prev.next;
			
			prev.next = newNode;
			newNode.prev = prev;
			
			newNode.next = tmp;
			if(tmp != null)
			{
				tmp.prev = newNode;
			}
		}else
		{
			prev.left = newNode;
			TreeNodeList tmp = prev.prev;
			newNode.next = prev;
			newNode.prev = tmp;
			prev.prev = newNode;
			if(tmp != null)
			{
				tmp.next = newNode;
			}
		}
		
	}
	
	public static void main(String[] args) {
		TreeNodeList root = new TreeNodeList(5);
		root.left = new TreeNodeList(3);
//		root.left.right = new TreeNodeList(4);
		root.left.left = new TreeNodeList(1);
		
		root.right = new TreeNodeList(8);
//		root.right.right = new TreeNodeList(9);

//		root.right.left = new TreeNodeList(7);
		
		KthSmallestBST obj = new KthSmallestBST();
		obj.insert(root, 2);
		obj.insert(root, 7);
		obj.insert(root, 9);

		 obj.buildList(root);
		
		 TreeNodeList tmp = root;
		 while(tmp != null)
			{
				System.out.print(tmp.val + " ");
				tmp = tmp.prev;
			}
		 System.out.println();
		 tmp = root;
		while(tmp != null)
		{
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
//		InorderTraversal traversal = new InorderTraversal();
//		System.out.println(traversal.inorderTraversal(root));
//		System.out.println(obj.kthSmallest(root, 3));
		
	}
	
	public int  smallestEle(TreeNodeList node, int k )
	{
		if(node.left == null)
		{
			return node.val;
		}
		
		int l  = smallestEle(node.left, k);
		
		return l;
	}
}
