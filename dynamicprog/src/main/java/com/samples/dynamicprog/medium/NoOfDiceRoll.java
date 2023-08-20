package com.samples.dynamicprog.medium;

import java.util.HashMap;

//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/submissions/
public class NoOfDiceRoll {

	public static void main(String[] args) {
		NoOfDiceRoll obj = new NoOfDiceRoll();
//		System.out.println(obj.numRollsToTarget(1,6,3));
		System.out.println(obj.numRollsToTarget(2,6, 7));
		System.out.println(obj.numRollsToTarget(30,30, 500));

	}
	public int numRollsToTarget(int n, int k, int target) {
		return numRollsToTargetHelper(n, k ,target, new HashMap<>());
	}

	public int numRollsToTargetHelper(int n, int k, int target, HashMap<String, Integer> memo) {

		if(n == 0 && target == 0) {
			return 1;
		}

		if(n == 0 && target != 0) {
			return 0;
		}
		if(n!= 0 && target <= 0) {
			return 0;
		}
		if(n <= 0 || target <= 0) {
			return 0;
		}

		String currentKey = n + "-" + target;
		if(memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}
		int ans = 0;
		int MOD = 1000000007;

		for(int i = 1; i <= k ; i++) {
			int temp = numRollsToTargetHelper(n-1, k, target-i, memo) % MOD;;
			ans = ans % MOD;
			ans = (ans + temp) % MOD;
		}

		memo.put(currentKey, ans);
		return ans;
	}
}
