package com.samples.binarytree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree2ndTry {

	Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
	int[] inorder; int[] postorder;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        
		for(int i = 0 ; i < inorder.length; i++)
		{
			inorderMap.put(inorder[i], i);
		}
		this.inorder = inorder;
		this.postorder = postorder;
		postIndex = postorder.length-1;
		
		
		return traverse(0 , this.inorder.length-1);
    }
	int postIndex;
	private TreeNode traverse(int inL, int inR )
	{
		if(postIndex < 0)
		{
			return null;
		}
		
		int val = postorder[postIndex];
		int inIndex = inorderMap.get(val);
		if(inL > inIndex || inIndex > inR)
		{
			return null;
		}
		postIndex--;
		TreeNode node = new TreeNode(val);
		node.right = traverse( inIndex+1,inR);
		node.left = traverse(inL, inIndex-1);
		
		return node;

	}
	
	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		
		BuildTree2ndTry treeBuilder = new BuildTree2ndTry();
		
		TreeNode root = treeBuilder.buildTree(inorder, postorder);
		TreeTraversal treeTraverse = new TreeTraversal();
		
		System.out.println(treeTraverse.inorderTraversal(root));
		
		
//		int[] preorder = {3, 9, 20, 15, 7};
//		root = treeBuilder.buildTreeFromPreInorder(inorder, preorder);
//		
//		System.out.println(treeTraverse.postorderTraversal(root));
		
	}
}
