package com.samples.dynamicprog.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DeleteAndEarn {

	public static void main(String[] args) {
		DeleteAndEarn obj = new DeleteAndEarn();
		System.out.println(obj.deleteAndEarn(new int[] {3,4,2}));
		System.out.println(obj.deleteAndEarn(new int[] {8,3,1}));

	}
	public int deleteAndEarn(int[] nums) {
		Map<Integer, Integer> freqNumMap = new TreeMap<>();
		int maxNumber = 0;
		for(int num : nums) {
			int freq = freqNumMap.getOrDefault(num, 0);
			freqNumMap.put(num, freq + num);
			maxNumber = Math.max(num, maxNumber);
		}

		return deleteAndEarnHelper(maxNumber, freqNumMap, new HashMap<>());
	}

	public int deleteAndEarnHelper(int num, Map<Integer, Integer> freqNumMap, Map<Integer, Integer> cache) {
		if(num <= 0) {
			return 0;
		}

		if(cache.containsKey(num)) {
			return cache.get(num);
		}

		int max = Math.max(deleteAndEarnHelper(num-1,  freqNumMap, cache), (freqNumMap.getOrDefault(num, 0)) + deleteAndEarnHelper(num-2, freqNumMap, cache));
		cache.put(num, max);
		return cache.get(num);
	}
}
