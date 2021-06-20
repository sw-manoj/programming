package com.samples.binarytree;

import java.util.HashMap;
import java.util.Map;

//	https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution//
public class BuildTree {

//	Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder 
//	is the postorder traversal of the same tree, construct and return the binary tree.

	
	int[] inorder;
	int[] postorder;
	
	int post_id;
	Map<Integer, Integer> inorder_index = new HashMap<Integer, Integer>();
	public TreeNode buildTreeFromPostInorder(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        post_id = postorder.length-1;
        
        for(int i  = 0 ; i < inorder.length; i++)
        {
        	inorder_index.put(inorder[i], i);
        }
		
		return helper(0, inorder.length-1);
    }
	
	private TreeNode helper(int start, int end)
	{
		if(start > end)
		{
			return null;
		}
		
		int val = postorder[post_id];
		post_id--;
		int index = inorder_index.get(val);
		
		TreeNode root = new TreeNode(val);
		
		root.right = helper(index+1, end);
		
		root.left = helper(start, index-1);
		
		return root;
		
	}
	
	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		
		BuildTree treeBuilder = new BuildTree();
		
		TreeNode root = treeBuilder.buildTreeFromPostInorder(inorder, postorder);
		TreeTraversal treeTraverse = new TreeTraversal();
		
		System.out.println(treeTraverse.preorderTraversal(root));
		
		
		int[] preorder = {3, 9, 20, 15, 7};
		root = treeBuilder.buildTreeFromPreInorder(inorder, preorder);
		
		System.out.println(treeTraverse.postorderTraversal(root));
		
	}
	
	
//	https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/
	int pre_id;
	int[] preorder;
	public TreeNode buildTreeFromPreInorder(int[] inorder, int[] preorder) {
		inorder_index.clear();
        this.inorder = inorder;
        this.preorder = preorder;
        pre_id = 0;
        
        for(int i  = 0 ; i < inorder.length; i++)
        {
        	inorder_index.put(inorder[i], i);
        }
		
		return PreInhelper(0, inorder.length-1);
    }
	
	private TreeNode PreInhelper(int start, int end)
	{
		if(start > end)
		{
			return null;
		}
		
		int val = preorder[pre_id];
		pre_id++;
		int index = inorder_index.get(val);
		
		TreeNode root = new TreeNode(val);
		
		root.left = PreInhelper(start, index-1);
		root.right = PreInhelper(index+1, end);
		
		
		
		return root;
		
	}
}
