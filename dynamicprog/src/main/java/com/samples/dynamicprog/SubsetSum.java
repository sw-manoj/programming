package com.samples.dynamicprog;

public class SubsetSum {
//	Let's take a problem, given a set, count how many subsets have sum of elements greater than or equal to a given value.

	public static boolean subsetSum(int[] A, int n, int k)
	{
		// return true if the sum becomes 0 (subset found)
		if (k == 0) {
			return true;
		}

		// base case: no items left, or sum becomes negative
		if (n < 0 || k < 0) {
			return false;
		}

		// Case 1. Include the current item `A[n]` in the subset and recur
		// for the remaining items `n-1` with the remaining total `k-A[n]`
		boolean include = subsetSum(A, n - 1, k - A[n]);

		// Case 2. Exclude the current item `A[n]` from the subset and recur for
		// the remaining items `n-1`
		boolean exclude = subsetSum(A, n - 1, k);

		// return true if we can get subset by including or excluding the
		// current item
		return include || exclude;
	}

	static int occBit = 0;
			static int occDp = 0;
	public static void main(String[] args) {

		int[] A = { 7, 3, 2, 5, 8 };
		int k = 14;

		if (subsetSum(A, A.length - 1, k)) {
			System.out.print("Subsequence with the given sum exists");
		}
		else {
			System.out.print("Subsequence with the given sum does not exist");
		}


		int[] set = {1,2,3,4};
		int tot = 3;
		int res = subSum(set, tot);
		System.out.println(" res==" + res + "==occ times==" + occBit);
		dp(set, 0, tot, 0);
		System.out.println("dp==" +count + "==occ times==" + occDp);
	}
	
	static int subSum(int[] set,int res)
	{
		int count = 0;
		int k = set.length;
		int pow = (int) Math.pow(2, k);
		System.out.println(pow);
		for(int i = 0; i< pow ; i++)
		{
			int sum = 0 ;
			occBit = occBit + 1;
			for(int j = 0 ; j < set.length ; j++)
			{
				if((i&(1<<j)) > 0)
				{
					sum = sum + set[j];
				}
			}
			if(sum >= res)
			{
				count = count + 1;
			}
		}
		
		return count;
	}
	static int count ;
	static void dp(int[] set, int pos, int res, int tot)
	{
		if(pos == set.length)
		{
			return;
		}
		occDp = occDp + 1;
		if(tot + set[pos] >= res)
		{
			count = count + 1;
//			return;
		}
		dp(set, pos + 1, res, tot + set[pos]);
		dp(set, pos + 1, res, tot);
	}
}
