package Medium.longeststr;

public class LangestPalindromeSubstring {

//	https://leetcode.com/problems/longest-palindromic-substring/solution/
	
//	Linear time Manacher's algorithm to find longest palindromic substring.
//	https://github.com/mission-peace/interview/blob/master/src/com/interview/string/LongestPalindromeSubstring.java
	public String longestPalindrome(String s) {
		String res = null;
		
		int start = 0;
		int end = 0;
		
		for(int i = 0 ; i < s.length() ;i++)
		{
			int len1 = expand(s, i , i);
			int len2 = expand(s, i , i+1);
			
			
			int len = Math.max(len1,  len2);
			
			if((end-start) < len)
			{
				start = i - (len-1)/2;
				
				end = i + len/2;
			}
		}
		return s.substring(start, end+1);
	}
	
	public int expand(String s , int start , int end)
	{
		while(start >= 0 && end < s.length() && s.charAt(start )== s.charAt(end))
		{
			start--;
			end++;
		}
		
		return end-start - 1;
	}
}
