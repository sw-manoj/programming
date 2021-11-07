package com.samples.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBT {
	
	public static void main(String[] args) {
		BoundaryOfBT obj = new BoundaryOfBT();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(6);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(obj.boundaryOfBinaryTree(root));
	}

	public boolean isLeaf(TreeNode node)
	{
		return node.left == null && node.right == null;
	}
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null) return result;
        
        if (!isLeaf(root)) {
            result.add(root.val);
        }
        
        TreeNode left = root.left;
        
        while(left != null)
        {
        	if(isLeaf(left))
        	{
        		break;
        	}
        	result.add(left.val);
        	
        	if(left.left != null)
        	{
        		left = left.left;
        	}
        	else
        	{
        		left = left.right;
        	}
        }
        
        addLeaves(root, result);
        
        TreeNode right = root.right;
        Stack<Integer> stack = new Stack<>();
        
        while(right != null)
        {
        	if(isLeaf(right))
        	{
        		break;
        	}
        	stack.push(right.val);
        	
        	if(right.right != null)
        	{
        		right = right.right;
        	}
        	else
        	{
        		right = right.left;
        	}
        }
        
        while(!stack.isEmpty())
        {
        	result.add(stack.pop());
        }
        
        return result;
    }
	
	public void addLeaves(TreeNode node, List<Integer> list)
	{
		if(node ==null) return;
		
		if(isLeaf(node)) 
			{
				list.add(node.val); 
				return;
			}
		
		addLeaves(node.left, list);
		addLeaves(node.right, list);

	}
}
