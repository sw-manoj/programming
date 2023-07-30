package com.samples.dynamicprog.medium;

import java.util.HashMap;

//https://leetcode.com/problems/coin-change/
public class CoinChange {

	public static void main(String[] args) {
		CoinChange obj = new CoinChange();
		System.out.println(obj.coinChange(new int[] {1,2,5}, 11));
	}
	public int coinChange(int[] coins, int amount) {
		HashMap<String, Integer> cache = new HashMap<>();

		int res =  coinChangeHelper(coins, 0, amount, cache);
		if(res >= 10001) {
			return -1;
		}
		return res;
	}


	public int coinChangeHelper(int[] coins,int index, int amount, HashMap<String, Integer> cache) {

		if(amount == 0) {
			return 0;
		}

		if(index == coins.length) {
			return 10001;
		}
		if(cache.containsKey(index + ":"+amount))
		{
			return cache.get(index + ":"+amount);
		}

		int consider = 10001;
		if(coins[index] <= amount) {
			consider = 1 + coinChangeHelper(coins, index, amount - coins[index], cache);
		}
		int notConsider = coinChangeHelper(coins, index+1, amount, cache);

		return Math.min(consider, notConsider);
	}
}
