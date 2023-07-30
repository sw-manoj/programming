package com.samples.dynamicprog.medium;

import java.util.HashMap;

public class CoinChangeII {

	public int change(int amount, int[] coins) {
		return changeHelper(amount, 0, coins, new HashMap<>());
	}

	public int changeHelper(int amount, int index, int[] coins, HashMap<String, Integer> memo) {
		if(amount == 0) {
			return 1;
		}
		if(index == coins.length) {
			return 0;
		}
		int currentCoin = coins[index];
		String currentKey = index + ":" + amount;
		if(memo.containsKey(currentKey)){
			return memo.get(currentKey);
		}
		int consider = 0;
		if(currentCoin <= amount) {
			consider = changeHelper(amount - currentCoin, index, coins, memo);
		}
		int notconsider = changeHelper(amount, index+1, coins , memo);

		memo.put(currentKey, consider + notconsider);
		return memo.get(currentKey);
	}
}
