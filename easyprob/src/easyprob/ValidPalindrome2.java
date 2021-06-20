package easyprob;

public class ValidPalindrome2 {

//	https://leetcode.com/problems/valid-palindrome-ii/solution/
	
//	Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
	
	public boolean validPalindrome(String s) {
		
		boolean result = true;
        for (int i = 0 ; i < (s.length() - 1)/2 ; i++)
        {
        	if(s.charAt(i) != s.charAt(s.length() - 1 - i))
        	{
        		int j = s.length() - 1 - i;
        		return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
        	}
        }
        
        return result;
    }
	
	private boolean isPalindrome(String s , int i , int j)
	{
		for (int k = i ; k < (i + j - 1)/ 2 ; k ++)
		{
			int z = (i + j - k);
			if(s.charAt(k) != s.charAt(z))
        	{
        		return false;
        	}
		}
		return true;
	}
}
