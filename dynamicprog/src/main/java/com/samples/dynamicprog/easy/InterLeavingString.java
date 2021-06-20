package com.samples.dynamicprog.easy;

public class InterLeavingString {

//	https://leetcode.com/problems/interleaving-string/solution/
	public boolean isInterleave(String s1, String s2, String s3) {
		
		if(s1.length() + s2.length() != s3.length() && (!s3.equals("") || !s1.equals("")  || !s2.equals("")))
		{
			return false;
		}
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();
		
		
		int i1 = 0 , i2 = 0 , i3 = 0;
		
		while((i1 < c1.length || i2 < c2.length) && i3 < c3.length)
		{
			System.out.println(c3[i3] + " " + c1[i1] + " " +  c2[i2]);

			if(i1 < c1.length && c1[i1] == c3[i3])
			{
				i1++;
			}
			else if(i2 < c2.length && c2[i2] == c3[i3])
			{
				i2++;
			}
			else
			{
				return false;
			}
			i3++;
		}
		return i3 == c3.length;
    }
	
	char[] c1;
	char[] c2;
	char[] c3;
	private boolean isMatch(int i1, int i2, int i3)
	{
		
		if(i3 == c3.length)
		{
			return true;
		}
		boolean b1 = false, b2 = false;
		if(i1 < c1.length && c1[i1] == c3[i3])
		{
			b1 =  isMatch(i1+1,i2,i3+1);
		}
		if (b1) return b1;
		if(i2 < c2.length && c2[i2] == c3[i3])
		{
			b2 =  isMatch(i1,i2+1,i3+1);
		}
		return b1 || b2;
		
	}
	
	public boolean isInterleave1(String s1, String s2, String s3) {
			
			if(s1.length() + s2.length() != s3.length())
			{
				return false;
			}
			
			this.c1 = s1.toCharArray();
			this.c2 = s2.toCharArray();
			this.c3 = s3.toCharArray();
			
			return isMatch(0, 0, 0);
	}
	
	public static void main(String[] args) {
		InterLeavingString obj = new InterLeavingString();
		System.out.println(obj.isInterleave1("aabcc", "dbbca", "aadbbcbcac"));
//		
		System.out.println(obj.isInterleave1("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(obj.isInterleave1("a", "", "c"));
		System.out.println(obj.isInterleave1("a", "", "a"));

		System.out.println(obj.isInterleave1("", "", ""));

	}
	
	
	public boolean isInterleave_opt(String s1, String s2, String s3) {
        // make sure length of s3 is equal s1 + s2
        return s1.length() + s2.length() == s3.length() &&
            solve(s1, s1.length(), s2, s2.length(), s3, new int[s1.length()+1][s2.length()+1]);
    }

    /*
    * DP[i][j] = (s1[i] == s3[k] && DP[i-1][j]) || (s2[i] == s3[k] && DP[i][j-1])
    */
    private boolean solve(String s1, int i, String s2, int j, String s3, int[][] dp) {
        int k = i+j;
        if (k == 0) {
            // size of string is zero, it's always matchable
            return true;
        }
        if (dp[i][j] != 0) {
            // 1 is true, 2 is false, 0 means subproblem is not solved yet
            return dp[i][j] == 1;
        }
        boolean res = (i-1 >= 0 && s1.charAt(i-1) == s3.charAt(k-1) && solve(s1, i-1, s2, j, s3, dp)) ||
                      (j-1 >= 0 && s2.charAt(j-1) == s3.charAt(k-1) && solve(s1, i, s2, j-1, s3, dp));
        dp[i][j] = res ? 1: 2;
        return res;
    }
}
