package com.samples.dfs.medium;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
public class LowestCommonAncestorBT {

	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        {
        	return null;
        }
        if(root == p || root == q)
        {
        	//matched one of target, return node. not going through subtree becuase, 
//        	at the end if other node(q) is not found then it is part of p's subtree so return p at the end
        	return root; 
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root; // if left and right return non null value , root is common ancestor so return it.
        
     // if only one of it found , return it, other node(q) could be subtree of it so return it.
        return left != null ? left : right; 
    }
	
	TreeNode ans ;
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        lcsTraverse(root, p, q);
		return ans;
    }
	
	boolean lcsTraverse(TreeNode node, TreeNode p, TreeNode q)
	{
		if(node == null) return false;
		
		int left = lcsTraverse(node.left, p, q) ? 1 : 0;
		int right = lcsTraverse(node.right, p, q) ? 1 : 0;
		int mid = (node.val == p.val || node.val == q.val) ? 1 : 0;
		
		if(mid + left + right >= 2) ans = node;
		
		return mid + left + right >= 1 ? true : false;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		LowestCommonAncestorBT obj = new LowestCommonAncestorBT();
		System.out.println(obj.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);

	}
}
