package com.samples.dfs.hard;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//https://leetcode.com/problems/binary-tree-maximum-path-sum/

//Better example to check the significance of using Math.max in left_gain and right_gain in step int left_gain = Math.max(max_gain(node.left), 0) compared to only int left_gain = max_gain(node.left) will be:
//Consider the below Tree:
//..............7
//......-2............2
//
//root = 7
//root.left=-2
//root.right=2
//
//or [7,-2,2] by level order
//
//Without Math.max in left_gain and right_gain, Result: 7
//With Math.max in left_gain and right_gain, Result: 9
//So 9 is right which is the max path 7 -> 2, i.e root to right

//if every node is negative then max negative is the final answer  which is taken care  but below condition
//		max = Math.max(max, node.val + leftmax + rightmax);
//here only node.val value is taken because of of left max and right max is 0. hence node.val is considered for max.so mex negative will be the final answer.
//		int leftmax = Math.max(traverse(node.left), 0 );
//		int rightmax = Math.max(traverse(node.right), 0 );
public class MaxPathSum {

	int max = Integer.MIN_VALUE;
	int traverse(TreeNode node)
	{
		if(node == null) return 0;
		
//		https://leetcode.com/problems/binary-tree-maximum-path-sum/solution/740749 - why max of zero
//		inorder to eliminate negate gains, ,we could take max with 0
		int leftmax = Math.max(traverse(node.left), 0 );
		int rightmax = Math.max(traverse(node.right), 0 );
		
		//checking if including node as centre of path from left right will give max values.
		max = Math.max(max, node.val + leftmax + rightmax);
		
//		returning max values attainted from left or right and summing it with node val. to be used by its parent.
		return node.val + Math.max(leftmax, rightmax);

	}
	public int maxPathSum(TreeNode root) {
     
	traverse(root);
	return max;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		MaxPathSum obj = new MaxPathSum();
		System.out.println(obj.maxPathSum(root));
		
		root = new TreeNode(10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		obj = new MaxPathSum();
		System.out.println(obj.maxPathSum(root));
	}
}
