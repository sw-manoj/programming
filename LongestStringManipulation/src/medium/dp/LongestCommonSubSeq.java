package medium.dp;

//https://leetcode.com/problems/longest-common-subsequence/solution/
public class LongestCommonSubSeq {

	
	public int subSeq(String t1, String t2, int m, int n, Integer[][] dp)
	{
		if(t1 == "" || t2 == "") return 0;
		
		if(m == t1.length() || n == t2.length())
		{
			return 0;
		}
		if(dp[m][n] != null)
		{
			return dp[m][n];
		}
		int res = 0;
		if(t1.charAt(m) == t2.charAt(n))
		{
//			System.out.println(t1.charAt(m));
			res =  1 + subSeq(t1, t2, m+1, n+1, dp);
		}
		else
		{
			res =  Math.max(subSeq(t1, t2, m+1, n, dp), subSeq(t1, t2, m , n+1 ,dp ));
		}
		
		dp[m][n] = res;

		return dp[m][n];
	}
	
	//
	public int longestCommonSubsequence(String text1, String text2) {
		Integer[][] dp = new Integer[text1.length()][text2.length()];
         subSeq(text1, text2,0,0, dp);
         
// 		printArr(dp);
 		return dp[0][0];
    }
	
	void printArr(int[][] dp)
	{
		System.out.println("printing dp arr for better understnading");
		for(int i = 0 ; i < dp.length ; i++)
		{
			for(int j = 0 ; j < dp[0].length ; j++)
			{
				System.out.print(( dp[i][j]) + " ");
			}
			System.out.println();
		}
	}
	
	
	//bottom up approach
	public int longestCommonSubsequence_dp(String text1, String text2) {
		int[][] dp = new int[text1.length() +1][text2.length() + 1];
		
		
		
		
		for(int i = 1 ; i <= text1.length() ; i++)
		{
			for(int j = 1; j <= text2.length();j++)
			{
				if(text1.charAt(i-1) == text2.charAt(j-1))
				{
					dp[i][j] =  1 + dp[i-1][j-1];
				}
				else
				{
					dp[i][j] =  Math.max(dp[i][j-1], dp[i-1][j]);
				}
					
//				dp[i][j] =  (text1.charAt(i) == text2.charAt(j) ? 1 : 0) +dp[i-1][j-1];
			}
		}
// 		printArr(dp);

        return dp[text1.length()][text2.length()];
    }
	
	
	public int longestCommonSubsequence_dp_space(String text1, String text2) {    
	    
	    // If text1 doesn't reference the shortest string, swap them.
	    if (text2.length() < text1.length()) {
	      String temp = text1;
	      text1 = text2;
	      text2 = temp;
	    }
	      
	    // The previous and current column starts with all 0's and like 
	    // before is 1 more than the length of the first word.
	    int[] previous = new int[text1.length() + 1];
	    int[] current = new int[text1.length() + 1];
	      
	    // Iterate through each column, starting from the last one.
	    for (int col = text2.length() - 1; col >= 0; col--) {
	      for (int row = text1.length() - 1; row >= 0; row--) {
	        if (text1.charAt(row) == text2.charAt(col)) {
	          current[row] = 1 + previous[row + 1];
	        } else {
	          current[row] = Math.max(previous[row], current[row + 1]);
	        }
	      }
	      // The current column becomes the previous one, and vice versa.
	      int[] temp = previous;
	      previous = current;
	      current = temp;
	    }
	        
	    // The original problem's answer is in previous[0]. Return it.
	    return previous[0];
	  }
	
	public static void main(String[] args) {
		LongestCommonSubSeq obj = new LongestCommonSubSeq();
		System.out.println(obj.longestCommonSubsequence("abcde", "ace"));
		System.out.println(obj.longestCommonSubsequence_dp("abc", "abc"));
		System.out.println(obj.longestCommonSubsequence_dp("abc", "def"));

		System.out.println(obj.longestCommonSubsequence_dp("abcde", "ace"));

	}
}
