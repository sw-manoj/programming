package com.samples.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		
		App treeBuilder = new App();
		
		TreeTraversal treeTraverse = new TreeTraversal();
		
//		System.out.println(treeTraverse.preorderTraversal(root));
		
		
		int[] preorder = {3, 9, 20, 15, 7};
		TreeNode root = treeBuilder.buildTree(preorder, inorder);
		
		System.out.println(treeTraverse.postorderTraversal(root));
    }
    
    int preIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
    	for(int i = 0 ; i < inorder.length ; i++)
    	{
    		inorderMap.put(inorder[i], i);
    	}
    		
    	
    	return helper(preorder, inorder,  0 ,inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end)
    {
    	if(preIndex == preorder.length || start > end)
    	{
    		return null;
    	}
    	TreeNode root = new TreeNode(preorder[preIndex]);
    	int inIndex = inorderMap.get(root.val);
    	
    	
    	preIndex++;
    	
    	
    	root.left = helper(preorder, inorder, start, inIndex-1 );
    	root.right = helper(preorder, inorder, inIndex + 1, end );

    	return root;
    	
    }
}
