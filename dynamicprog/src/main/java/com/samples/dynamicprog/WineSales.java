package com.samples.dynamicprog;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WineSales {
//
//	Imagine you have a collection of N wines placed next to each other on a shelf. For simplicity, let's number the wines from left to right as they are standing on the shelf with integers from 1 to N, respectively. The price of the ith wine is pi. (prices of different wines can be different).
//
//	Because the wines get better every year, supposing today is the year 1, on year y the price of the ith wine will be y*pi, i.e. y-times the value that current year.
//
//	You want to sell all the wines you have, but you want to sell exactly one wine per year, starting on this year. One more constraint - on each year you are allowed to sell only either the leftmost or the rightmost wine on the shelf and you are not allowed to reorder the wines on the shelf (i.e. they must stay in the same order as they are in the beginning).
//
//	You want to find out, what is the maximum profit you can get, if you sell the wines in optimal order?"

	static int[][] cache;
	public static int profitWithBackTracking(int[] priceArr , int begin, int end)
	{
		if(begin > end)
		{
			return 0;
		}
			int year = priceArr.length - (end - begin + 1) + 1;
			
			return Math.max(profitWithBackTracking(priceArr, begin + 1, end) + year * priceArr[begin], 
					profitWithBackTracking(priceArr, begin, end-1) + year * priceArr[end]);
		
		
		
	}
	
	public static int profitWithDP(int[] priceArr , int begin, int end)
	{
		if(begin > end)
		{
			return 0;
		}
		
		if(cache[begin][end] != -1)
		{
			return cache[begin][end];
		}
			int year = priceArr.length - (end - begin + 1) + 1;
			
			 cache[begin][end] = Math.max(profitWithBackTracking(priceArr, begin + 1, end) + year * priceArr[begin], 
					profitWithBackTracking(priceArr, begin, end-1) + year * priceArr[end]);
		
			 return cache[begin][end];
		
	}
	
	
	public static void main(String[] args) {
		int[] priceArr = {2,3,5,1,4};
		
		int profit = profitWithBackTracking(priceArr, 0, priceArr.length - 1);
		
		cache = new int[priceArr.length][priceArr.length];
		
		initCache(priceArr.length);
		System.out.println("profit with back tracking "+profit);
		
		
		int profitDp = profitWithDP(priceArr, 0, priceArr.length-1);
		
		System.out.println("profit with DP "+profitDp);
	}
	
	static void initCache(int n )
	{
		for(int i = 0; i < n ; i++)
		{
			for(int j = 0 ; j < n;j ++)
			{
				cache[i][j] = -1;
			}
		}
	}
}
