package com.samples.dynamicprog.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class JumpGame6 {

	int[] dp;
	int[] seen;

	private int helper(int[] nums, int k, int index) {
		if (index >= nums.length - 1) {
			return nums[nums.length - 1];
		}
		if (seen[index] == 1) {
			return dp[index];
		}

		int ans = Integer.MIN_VALUE;

		for (int i = 1; i <= k; i++) {
			if (index + i > nums.length - 1) {
				continue;
			}
			ans = Math.max(ans, helper(nums, k, index + i));
		}
//		System.out.println(index + "==" + ans);
		dp[index] = nums[index] + ans;
		seen[index] = 1;
		return dp[index];
	}

	public int maxResult(int[] nums, int k) {
		dp = new int[nums.length];
		seen = new int[nums.length];
		return helper(nums, k, 0);

	}

	public int maxResult1(int[] nums, int k) {
		dp = new int[nums.length + 1];
		dp[0] = 0;

		for (int i = 0; i < nums.length; i++) {
			int j = Math.max(0, i - k);
			int ans = dp[j + 1];
			for (; j < i; j++) {
				ans = Math.max(ans, dp[j + 1]);
			}

//			System.out.println(nums);
			dp[i + 1] = ans + nums[i];
		}
		System.out.println(Arrays.toString(dp));
		return dp[nums.length];

	}

	public int maxResult2(int[] nums, int k) {
		int n = nums.length;
		int[] score = new int[n];
		score[0] = nums[0];
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		priorityQueue.add(new int[] { nums[0], 0 });
		for (int i = 1; i < n; i++) {
			// pop the old index
			while (priorityQueue.peek()[1] < i - k) {
				priorityQueue.remove();
			}
			score[i] = nums[i] + score[priorityQueue.peek()[1]];
			priorityQueue.add(new int[] { score[i], i });
		}
		return score[n - 1];
	}

	public static void main(String[] args) {
		JumpGame6 obj = new JumpGame6();
//		System.out.println(obj.maxResult(new int[] {1,-1,-2,4,-7,3}, 2));
//		
//		System.out.println(obj.maxResult(new int[] {10,-5,-2,4,0,3}, 3));
//		System.out.println(obj.maxResult(new int[] {1,-5,-20,4,-1,3,-6,-3}, 2));
//		
//		
		System.out.println(obj.maxResult1(new int[] { 1, -1, -2, 4, -7, 3 }, 2));

		System.out.println(obj.maxResult1(new int[] { 10, -5, -2, 4, 0, 3 }, 3));
		System.out.println(obj.maxResult1(new int[] { 1, -5, -20, 4, -1, 3, -6, -3 }, 2));

	}
}
