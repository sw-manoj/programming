package com.samples.dynamicprog;

//https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {

	public static void main(String[] args) {
		MinCostClimbingStairs obj = new MinCostClimbingStairs();
		System.out.println(obj.minCostClimbingStairs_iter(new int[] {1,100,1,1,100,1}));
		System.out.println(obj.minCostClimbingStairs_iter(new int[] {10,15,20}));

	}
	public int minCostClimbingStairs(int[] cost) {
       int min = 0;
       int[] dp = new int[cost.length];
       min = Math.min(helper(cost, 0, dp), helper(cost, 1, dp));
    		   
       
       return min;
    }
	
	private int helper(int[] cost, int index, int[] dp)
	{
		if(index >= cost.length)
		{
			return 0;
		}

		if(dp[index] > 0)
		{
			return dp[index];
		}
		dp[index] = cost[index] + Math.min(helper(cost, index+1, dp), helper(cost, index+2, dp));
		return dp[index];
	}
	
	public int minCostClimbingStairs_iter(int[] cost) {
	       int min = 0;
	       int a = cost[0], b = cost[1];
	       
	       for(int i = 2; i <= cost.length; i++)
	       {
	    	   min = Math.min(a, b) + ((i == cost.length) ? 0 : cost[i]);
	    	   a = b;
	    	   b = min;
	       }
	       return min;
	    }
}
