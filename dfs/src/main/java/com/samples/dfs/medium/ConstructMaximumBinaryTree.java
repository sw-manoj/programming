package com.samples.dfs.medium;
//https://leetcode.com/problems/maximum-binary-tree/
public class ConstructMaximumBinaryTree {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length-1);
    }
	
	public TreeNode constructTree(int[] nums, int start, int end)
	{
		if(start  > end) return null;
		
		int maxIndex = maxIndex(nums, start, end);
		TreeNode node = new TreeNode(nums[maxIndex]);
		node.left = constructTree(nums, start, maxIndex-1);
		node.right = constructTree(nums, maxIndex+1, end);
		
		return node;
	}
	
	public int maxIndex(int[] nums, int s, int e)
	{
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		for(int i = s; i <=e ;i++)
		{
			if(max < nums[i])
			{
				max = nums[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
}
