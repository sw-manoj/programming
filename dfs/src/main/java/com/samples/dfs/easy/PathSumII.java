package com.samples.dfs.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii
public class PathSumII {

	public void sum(TreeNode root, int targetSum, List<Integer> pathNodes,List<List<Integer>> result)
	{
		if(root == null) return ;
        pathNodes.add(root.val);

        if(root.left == null && root.right == null && root.val == targetSum)
        {
        	result.add(new ArrayList<Integer>(pathNodes));
        }
        sum(root.left, targetSum-root.val, pathNodes, result);
        sum(root.right, targetSum-root.val,pathNodes, result);
        pathNodes.remove(pathNodes.size()-1);
	}
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		sum(root, targetSum, new ArrayList<Integer>(), result);
		return result;
    }
	
	public static void main(String[] args) {
		PathSumII obj = new PathSumII();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(4);

		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		
		System.out.println(obj.pathSum(root, 14));
	}

	int ans = 0;
	public int maxPathSum(TreeNode root) {
		 maxPathSumHelper(root);
		 return ans;
	}

	public int maxPathSumHelper(TreeNode root) {
		if(root == null) return 0;

		int left = Math.max(maxPathSumHelper(root.left), 0);
		int right = Math.max(maxPathSumHelper(root.right), 0);

		int currentMax = Math.max(root.val + Math.max(left, right), left + right + root.val);
		if(currentMax > ans) {
			ans = currentMax;
		}

		return root.val + Math.max(left, right);


	}

}
