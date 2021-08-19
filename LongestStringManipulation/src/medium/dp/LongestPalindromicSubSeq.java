package medium.dp;

//https://leetcode.com/problems/longest-palindromic-subsequence/
//Given a string s, find the longest palindromic subsequence's length in s.
//
//A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.


//for better explanation
//https://www.youtube.com/watch?v=_AcULHRds3I 
public class LongestPalindromicSubSeq {
	
	public int subSeq1(int start, int end, String s)
	{
		if( start > end) return 0;
		
		
		if (start == end) return 1;
		
		if(s.charAt(start) == s.charAt(end))
		{
			return 2 + subSeq1(start +1, end -1, s);
		}
		else
		{
			return Math.max(subSeq1(start +1, end, s), subSeq1(start, end-1, s));
		}
	}

	//time exceeds
	public int longestPalindromeSubseq1(String s) {
                
        return subSeq1(0, s.length()-1,s);
    }
	
	
	
	//using dynamic programming top down approach.
	public int subSeq(int start, int end, String s,Integer[][] dpArr)
	{
		if( start > end) return 0;
		
		
		if (start == end) return 1;
		
		if(dpArr[start][end] != null) return dpArr[start][end];
		
		int res = 0;
		if(s.charAt(start) == s.charAt(end))
		{
			res =  2 + subSeq(start +1, end -1, s, dpArr);
		}
		else
		{
			res =  Math.max(subSeq(start +1, end, s, dpArr), subSeq(start, end-1, s, dpArr));
		}
		
		dpArr[start][end] = res;
		return dpArr[start][end];
	}

	public int longestPalindromeSubseq(String s) {
        Integer[][] dpArr = new Integer[s.length()][s.length()];   
        int res =  subSeq(0, s.length()-1,s, dpArr);
        
//        dp has start has row and end col strcuture
//        for eg , "bbcbac"
//        
//        	  b  b  c  b  a  c
//        b   1  
//        b	     1
//        c		    1
//        b			   1
//        a				  1
//        c					  1
//        System.out.println("============");
//        printArr(dpArr);
        return res;
    }
	
	void printArr(Integer[][] dp)
	{
		System.out.println("printing dp arr for better understnading");
		for(int i = 0 ; i < dp.length ; i++)
		{
			for(int j = 0 ; j < dp[0].length ; j++)
			{
				System.out.print((dp[i][j] == null ? 0 : dp[i][j]) + " ");
			}
			System.out.println();
		}
	}
	
	//dp bottom up approach derived from above dp, reversing it.
	public int longestPalindromeSubseq2(String s) {
		Integer[][] dp = new Integer[s.length()][s.length()];
		//filiing diagonals 
		int n = dp.length;
		for(int i = 0 ; i < n ; i++)
		{
			dp[i][i] = 1;
		}
		
		
		for(int start = n-2; start >= 0 ; start--)
		{
			for(int end = start+1; end < n ; end++)
			{
				if(s.charAt(start) == s.charAt(end))
				{
					dp[start][end] = 2 + (dp[start+1][end-1] == null ? 0 : dp[start+1][end-1]);
				}
				else
				{
					dp[start][end] = Math.max(dp[start+1][end] ,dp[start][end-1]);
				}
			}
		}
		
		return dp[0][s.length()-1];
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubSeq obj = new LongestPalindromicSubSeq();
		System.out.println(obj.longestPalindromeSubseq1("bbbab"));
		System.out.println(obj.longestPalindromeSubseq1("abbccba"));
		
		
		System.out.println(obj.longestPalindromeSubseq("bbbab"));
		System.out.println(obj.longestPalindromeSubseq("abbccba"));
		
		System.out.println(obj.longestPalindromeSubseq2("bbbab"));
		System.out.println(obj.longestPalindromeSubseq2("abbccba"));

	}
}
