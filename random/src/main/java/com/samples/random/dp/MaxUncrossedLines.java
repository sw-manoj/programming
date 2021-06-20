package com.samples.random.dp;

public class MaxUncrossedLines {

	public static void main(String[] args) {
		int[] A = {2,5,1,2,5};
				int[] B = {10,5,2,1,5,2};
//				int[] A = {1,3,7,1,7,5} ,B = {1,9,2,5,1};
//				int[] A = {3}, B = {3,3,2};
//				int[] A = {1,4,2}, B = {1,2,4};
				MaxUncrossedLines maxLInes = new MaxUncrossedLines();
				
				System.out.println(maxLInes.maxUncrossedLines(A, B));
	}
	
	public int maxUncrossedLines(int[] A, int[] B) {
		int[][] dp = new int[A.length][B.length];
		fillDp(dp);
		return maxUncrossedLines(A, B, 0,0,0,dp);
    }
	
	private void fillDp(int[][] dp)
	{
		for(int i = 0 ; i < dp.length ; i++)
		{
			for(int j=0 ; j < dp[i].length ; j++)
			{
				dp[i][j] = -1;
			}
		}
	}
	
	public int maxUncrossedLines(int[] aArr, int[] bArr, int aIndex , int bIndex, int maxLines , int[][] dp) {
		if(aArr.length <= aIndex || bArr.length <= bIndex)
		{
			return maxLines;
		}
		
		if(dp[aIndex][bIndex] != -1)
		{
			System.out.println(aIndex + "==" + bIndex + "==" + maxLines);
			return dp[aIndex][bIndex];
		}
		
		int bMax,aMax,allMax = 0;
		if(aArr[aIndex] == bArr[bIndex])
		{
			
			allMax = maxUncrossedLines(aArr, bArr, aIndex+1, bIndex+1, maxLines+1,dp);
		}
		else
		{
//			bMax = maxUncrossedLines(aArr, bArr, aIndex, bIndex+1, maxLines,dp);			
//			aMax = maxUncrossedLines(aArr, bArr, aIndex+1, bIndex, maxLines,dp);
			allMax = maxUncrossedLines(aArr, bArr, aIndex +1, bIndex+1, maxLines,dp);
		}
		bMax = maxUncrossedLines(aArr, bArr, aIndex, bIndex+1, maxLines,dp);			
		aMax = maxUncrossedLines(aArr, bArr, aIndex +1, bIndex, maxLines,dp);
		
		
		maxLines = Math.max(Math.max(aMax,bMax),allMax);
		dp[aIndex][bIndex] = maxLines;
		System.out.println(aIndex + "===" + bIndex + "===" + maxLines);
		return dp[aIndex][bIndex];
    }
}
