package easyprob;

public class LongestPalindrome {

//	https://leetcode.com/problems/longest-palindrome/
	public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = 0;
        for(char c: s.toCharArray())
        {
        	count[c]++;
        	if(count[c]==2)
        	{
        		length += 2;
        		count[c] = 0;
        	}
        }
        return length == s.length() ? length : length + 1;
    }
}
