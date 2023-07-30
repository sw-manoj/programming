package com.samples.dynamicprog.medium;

public class RodCutting {
//	https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

	public static void main(String args[])
	{
		int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int size = arr.length;

		RodCutting obj = new RodCutting();
		System.out.println("Maximum Obtainable Value is "
				+ obj.cutRod(arr,  size));
	}
	int cutRod(int price[], int n)
	{
		int[][] dp = new int[n][n+1];

		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n+1; j++) {
				dp[i][j] = -1;
			}
		}
		return cutRodHelper(price, 0, n, dp);
	}
	 int cutRodHelper(int price[], int index, int len, int[][] dp)
	{
		if(len == 0) {
			return 0;
		}
		if(index >= price.length) {
			return 0;
		}

		if(dp[index][len] != -1) {
			return dp[index][len];
		}
		int consider = 0;
		if(index + 1 <= len ) {
			consider = price[index] + cutRodHelper(price, index, len - (index + 1), dp);
		}
		int notconsider = cutRodHelper(price, index+1, len, dp);

		int max = Math.max(consider, notconsider);
		dp[index][len] = max;
		return max;
	}
}
