package com.samples.dynamicprog;

import java.util.Arrays;

//https://leetcode.com/problems/house-robber/
public class HouseRobber {
	int[] dp;

	private int helper(int[] nums, int index, int total) {
		if (index >= nums.length) {
			return 0;
		}
		if (dp[index] > -1) {
			return dp[index];
		}

		int a = helper(nums, index + 1, total);
		int b = helper(nums, index + 2, total) + nums[index];
		dp[index] = Math.max(a, b);
		return dp[index];
	}

	public int rob1(int[] nums) {

		dp = new int[nums.length];
		Arrays.fill(dp, -1);
//		dp[0] = nums[0];
//		for( int i = 1 ; i < nums.length; i++)
//		{
//			dp[i] = nums[i] + Math.max(nums[i], nums[i-1]);
//		}
//		return nums[0] + Math.max(helper(nums, 1 , 0), helper(nums,  2 , nums[0]));

		int val = helper(nums, 0, 0);


//		for(int n : dp)
//		{
//			System.out.print(n);
//		}

		return val;
	}

	public int rob_dp(int[] nums) {
		int n = nums.length - 1;
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[n] = nums[n];
		dp[n - 1] = nums[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
		}


		return dp[0];
	}


	public int rob_dp_opt(int[] nums) {
		int n = nums.length - 1;

		int prevPlusOne = nums[n];
		int prev = nums[n - 1];
		int ans = 0;
		for (int i = n - 2; i >= 0; i--) {
			ans = Math.max(nums[i] + prevPlusOne, prev);
			prevPlusOne = prev;
			prev = ans;

		}
		return ans;
	}

	private int[] memo;

	public int rob(int[] nums) {

		this.memo = new int[100];

		// Fill with sentinel value representing not-calculated recursions.
		Arrays.fill(this.memo, -1);

		return this.robFrom(0, nums);
	}

	private int robFrom(int i, int[] nums) {

		// No more houses left to examine.
		if (i >= nums.length) {
			return 0;
		}

		// Return cached value.
		if (this.memo[i] > -1) {
			return this.memo[i];
		}

		// Recursive relation evaluation to get the optimal answer.
		int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);

		// Cache for future use.
		this.memo[i] = ans;
		return ans;
	}

	public static void main(String[] args) {
		HouseRobber obj = new HouseRobber();
		System.out.println(obj.rob(new int[]{2, 7, 9, 3, 1}));
		System.out.println(obj.rob1(new int[]{2, 7, 9, 3, 1}));
		System.out.println(obj.rob3(new int[]{2, 7, 9, 3, 1}));
		System.out.println(obj.rob3(new int[]{1,2,3,1}));
		System.out.println(obj.rob3(new int[]{2,1,1,2}));

		System.out.println(obj.rob_dp_opt(new int[]{2, 7, 9, 3, 1}));

	}

	public int rob3(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];

		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		int prevPlusOne = nums[0];
		int prev = Math.max(prevPlusOne, nums[1]);

		for(int i = 2; i< nums.length ; i++) {
			int tmp = Math.max(nums[i] + prevPlusOne, prev);
			prevPlusOne = prev;
			prev = tmp;
		}
		return prev;
	}
}
