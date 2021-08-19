package com.samples.dynamicprog;

import java.util.HashMap;
import java.util.Map;

public class SumToANum {

	// no of subsets add upto total
	static int dp(int total , int[] arr, int pos, Map<String,Integer> mem)
	{
		String key = String.valueOf(total) + ":" + String.valueOf(pos);
		if(mem.containsKey(key))
		{
			return mem.get(key);
		}
		if(total ==0)
		{
			return 1;
		}
		else if(total <0 || pos < 0)
		{
			return 0;
		}
		
		int toReturn;
		if(total < arr[pos])
		{
			toReturn = dp(total, arr, pos-1, mem);
		}
		else
		{
			toReturn = dp(total-arr[pos], arr, pos-1, mem) + dp(total, arr, pos-1, mem);
		}
		
		mem.put(key, toReturn);
		return toReturn;
		
	}
	
	static void countSubsets(int total, int[] arr)
	{
		Map<String,Integer> mem = new HashMap<String, Integer>();
		int result = dp(total, arr, arr.length -1 , mem);
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		int total = 25;
		int[] arr = {6,2,4,10,8,3};
		
		countSubsets(total, arr);
	}
}
