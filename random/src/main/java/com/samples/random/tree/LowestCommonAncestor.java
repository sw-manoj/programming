package com.samples.random.tree;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestor {

	 

	boolean pfound;
	boolean qfound;
	
	public TreeNode lowestCommonAncestor_2ndtry(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        
    	TreeNode lca = null;

        if (root.val == p.val || root.val == q.val) 
        {
        	lca = root;
        }
        
        TreeNode left = lowestCommonAncestor_2ndtry(root.left , p ,q);
        TreeNode right = lowestCommonAncestor_2ndtry(root.right , p ,q);
        
        if(left != null && right != null)
        {
        	lca = root;
        }
        return lca != null ?  lca : left != null ? left : right;
        
//        return root == p 
    }



	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		
		root.right = new TreeNode(8);
		root.right.right = new TreeNode(9);
		root.right.left = new TreeNode(7);
		
		LowestCommonAncestor obj = new LowestCommonAncestor();
		System.out.println(obj.lowestCommonAncestor_2ndtry(root, new TreeNode(1), new TreeNode(4)).val);
	}
	
	
	
	
	
//	as per the problem statement m p and q exists in tree for sure.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root; // if p or q matches and other one is in subtree of the current node then, just return the current node because it could be the ancestor anyway. 
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root; // if both p and q are found we can return the cuurent node(root) as LCA
		return left != null ? left : right; // since we dont go beyond a node (to child nodes if either p or q is found
											// so even if other target is not found we can still confirm that it should
											// lie below the node already found (not null) left or right)
	}
}
