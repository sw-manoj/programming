package com.samples.list;

public class FindMaxDepthTree {

	public class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		FindMaxDepthTree treeDepth = new FindMaxDepthTree();
//		int res = treeDepth.maxDepth(root);
//		System.out.println("depth o fthree " + res);
	}
	
	 public int maxDepth(TreeNode root) {
	        if(root == null)
	           {
	               return 0;
	           }
	        return helper(root, 0);
	    }
		
		int helper(TreeNode root, int depth)
		
		{
			if(root == null)
			{
				return depth;
			}
	        depth++;
			return Math.max(helper(root.left, depth),helper(root.right, depth));
		}
	 public double myPow(double x, int n) {
	        long N = n;
	        if (N < 0) {
	            x = 1 / x;
	            N = -N;
	        }
	        double ans = 1;
	        double current_product = x;
	        for (long i = N; i > 0; i /= 2) {
	            if ((i % 2) == 1) {
	                ans = ans * current_product;
	            }
	            current_product = current_product * current_product;
	        }
	        return ans;
	    }
}
