package com.samples.binarytree;

import java.util.ArrayList;
import java.util.List;

//Definition for a Node.
class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};

public class NaryTraversal {
	
	private void helper(Node root, List<Integer> res)
	{
		if(root == null)
		{
			return ;
		}
		
		res.add(root.val);
		
		for(Node child : root.children)
		{
			helper(child, res);
		}
	}

	public List<Integer> preorder(Node root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
	}
}
