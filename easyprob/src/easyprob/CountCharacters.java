package easyprob;

//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/submissions/
public class CountCharacters {

	public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] abc = new int[26];
        
        for(char c : chars.toCharArray())
        {
        	abc[c-'a'] = abc[c-'a'] + 1;
        }
        
        
        for(String s: words)
        {
        	if(isGood(s, abc))
        	{
        		res = res + s.length();
        	}
        }
        return res;
    }
	
	private boolean isGood(String s , int[] key)
	{
		int[] keyCopy = key.clone();
		
		for(char c : s.toCharArray())
		{
			keyCopy[c- 'a']--;
			if(keyCopy[c- 'a'] < 0)
			{
				return  false;
			}
		}
		
		return true;
	}
}
