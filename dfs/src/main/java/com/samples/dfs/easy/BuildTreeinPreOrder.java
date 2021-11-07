package com.samples.dfs.easy;

import java.util.HashMap;
import java.util.Map;



public class BuildTreeinPreOrder {

	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7};
		int[] preorder = {3, 9, 20, 15, 7};
		
		BuildTreeinPreOrder treeBuilder = new BuildTreeinPreOrder();
		
		TreeNode root = treeBuilder.buildTree(inorder, preorder);
		
		
//		
//		int[] preorder = {3, 9, 20, 15, 7};
//		root = treeBuilder.buildTreeFromPreInorder(inorder, preorder);
//		
//		System.out.println(treeTraverse.postorderTraversal(root));
		
	}
	Map<Integer, Integer> inOrdermap = new HashMap<Integer, Integer>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        
		for(int i = 0 ; i < inorder.length ; i++)
		{
			inOrdermap.put(inorder[i], i);
		}
		
		return null;
    }
	
	int preOrderIndex = 0;
	
	TreeNode createTree(int[] preOrder,int[] inOrder, int l, int r)
	{
		if(l > r)
		{
			return null;
		}
		TreeNode node = new TreeNode(preOrder[preOrderIndex]);
		preOrderIndex++;
		int inIndex = inOrdermap.get(node.val);
		node.left = createTree(preOrder, inOrder, l, inIndex-1);
		node.right = createTree(preOrder, inOrder, inIndex +1 , r);

		return node;
	}
}
