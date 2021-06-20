package com.samples.dynamicprog.easy;

public class JumpGame6 {
	
	int[] dp;
	int[] seen;
	private int helper(int[] nums, int k , int index)
	{
		if(index >= nums.length-1)
		{
			return nums[nums.length-1];
		}
		if(seen[index] ==1)
		{
			return dp[index];
		}
		
		int ans = Integer.MIN_VALUE;
		
		for(int i = 1 ; i <= k;i++)
		{
			if(index + i > nums.length -1)
			{
				continue;
			}
			ans = Math.max(ans,helper(nums,k, index + i));
		}
//		System.out.println(index + "==" + ans);
		dp[index] = nums[index] + ans;
		seen[index] = 1;
		return dp[index];
	}
	public int maxResult(int[] nums, int k) {
		dp = new int[nums.length];
		seen = new int[nums.length];
        return helper(nums, k , 0);
		
    }
	
	public static void main(String[] args) {
		JumpGame6 obj = new JumpGame6();
		System.out.println(obj.maxResult(new int[] {1,-1,-2,4,-7,3}, 2));
		
		System.out.println(obj.maxResult(new int[] {10,-5,-2,4,0,3}, 3));
		System.out.println(obj.maxResult(new int[] {1,-5,-20,4,-1,3,-6,-3}, 2));
		
	

	}
}
