package com.samples.random.tree;

public class LowestCommonAncestor {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
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
