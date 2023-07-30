package com.samples.dynamicprog.medium;

import java.util.HashMap;
import java.util.Map;

public class BuyAndSellStockI {

	public static void main(String[] args) {
		BuyAndSellStockI obj = new BuyAndSellStockI();
		System.out.println(obj.maxProfit(new int[] {7,1,5,3,6,4}));
	}
	public int maxProfit(int[] prices) {
		Map<String, Integer> cache = new HashMap<>();
		return maxProfitHelper(prices, 0, false, 1, cache);
	}

	public int maxProfitHelper(int[] prices, int index, boolean bought, int transactionLimit , Map<String, Integer> cache) {

		if(index >= prices.length) {
			return 0;
		}
		if(transactionLimit == 0) {
			return 0;
		}
		String currentKey = index + ":" + bought;
		if(cache.containsKey(currentKey)){
			return cache.get(currentKey);
		}
		int with = 0;
		int without = 0;
		if(! bought) {
			with = -prices[index] + maxProfitHelper(prices, index+1, true, transactionLimit, cache);
			without = maxProfitHelper(prices, index+1, bought, transactionLimit, cache);
		}else {
			with = prices[index] + maxProfitHelper(prices, index+1, true, transactionLimit-1, cache);
			without = maxProfitHelper(prices, index+1, bought, transactionLimit, cache);
		}
		cache.put(currentKey, Math.max(with, without));
		return cache.get(currentKey);
	}
}
