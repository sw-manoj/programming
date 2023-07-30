package com.samples.dynamicprog;

public class Fibo {

	public static void main(String[] args) {
		Fibo fibo = new Fibo();
		int res = fibo.climbStairs(4);
		System.out.println(res);
	}

	public int climbStairs1(int n) {
		return climbStairsHelper(n, new Integer[n], 0);
	}

	public int climbStairsHelper(int n, Integer[] dp, int index) {
		if(index > n)
		{
			return 0;
		}
		if(index == n)
		{
			return 1;
		}
		if(dp[index] != null) {
			return dp[index];
		}
		dp[index] = climbStairsHelper(n, dp, index+1) + climbStairsHelper(n,dp, index+2);
		return dp[index];
	}
	
    public int fib(int N) {
        
    	int[] memo = new int[N+1];
    	memo[0] = 0; 
    	if(N > 0)
    	{
    	memo[1] = 1;
    	}
    	
    	for(int i = 2 ; i <= N ; i++)
    	{
    		memo[i] = memo[i-1] + memo[i-2];
    	}
    	return memo[N];
    	
    }
    
    public int climbStairs(int n) {
	if(n < 3)
	{
		return n;
	}
	int[] memo = new int[n+1];
	memo[0] = 0; 
	memo[1] = 1;
	memo[2] = 2;
	
	for(int i = 3 ; i <= n ; i++)
	{
		memo[i] = memo[i-1] + memo[i-2];
	}
	return memo[n];
    }
}