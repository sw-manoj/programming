package com.samples.dynamicprog.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {
//	https://leetcode.com/problems/target-sum/solutions/97334/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation/public class TargetSum {


//	The original problem statement is equivalent to:
//	Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target
//
//	Let P be the positive subset and N be the negative subset
//	For example:
//	Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
//	Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]
//
//	Then let's see how this can be converted to a subset sum problem:
//
//	sum(P) - sum(N) = target
//	sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
//                       2 * sum(P) = target + sum(nums)
//	So the original problem has been converted to a subset sum problem as follows:
//	Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2


//	Also same as Count no of subsets with given difference (DP)

	public int findTargetSumWays(int[] nums, int target) {
	int totalSum = 0;
	for(int num : nums)
	{
		totalSum += num;
	}
	if(totalSum < target) return 0;
	if((totalSum + target)%2 != 0) return 0;
	int subsetSum = (totalSum + target) /2 ;
	Map<String, Integer> memo = new HashMap<>();

	return helper(nums, 0 , subsetSum, memo);
}

	int helper(int[] nums, int currentIndex, int target, 	Map<String, Integer> memo) {
		if(target < 0) return 0;
		if (currentIndex == nums.length) {
			if (target == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		String currentKey = currentIndex + ":" + target;
		if(memo.containsKey(currentKey) ) return memo.get(currentKey);

		int consider = helper(nums, currentIndex + 1, target-nums[currentIndex], memo);

		int notconsider = helper(nums, currentIndex + 1, target, memo);

		memo.put(currentKey,consider + notconsider);
		return consider + notconsider;
	}

	int total;

	public int findTargetSumWays1(int[] nums, int S) {
		total = Arrays.stream(nums).sum();

		int[][] memo = new int[nums.length][2 * total + 1];
		for (int[] row : memo) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}
		return calculate(nums, 0, 0, S, memo);
	}

	public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
		if (i == nums.length) {
			if (sum == S) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (memo[i][sum + total] != Integer.MIN_VALUE) {
				return memo[i][sum + total];
			}
			int add = calculate(nums, i + 1, sum + nums[i], S, memo);
			int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
			memo[i][sum + total] = add + subtract;
			return memo[i][sum + total];
		}
	}
}
