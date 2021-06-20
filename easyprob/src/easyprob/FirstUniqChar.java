package easyprob;

//https://leetcode.com/problems/first-unique-character-in-a-string/submissions/
public class FirstUniqChar {
	
	public int firstUniqChar(String s) {
		
		if(s== null || s.length() == 0)
		{
			return -1;
		}
		int result = s.length();
		
		for(char c = 'a'; c <= 'z'; c++)
		{
			int index = s.indexOf(c);
			if(index != -1 && index == s.lastIndexOf(c))
			{
				result = Math.min(result, index);
			}
		}
		
		return result == s.length() ? -1 : result;
	}
	public int firstUniqChar1(String s) {
        int [] charCount = new int[26];


        for(int i=0; i < s.length(); i++){
        char c = s.charAt(i);
        charCount[c - 'a'] = charCount[c - 'a'] + 1;
    }
    
    for(int i=0; i< s.length(); i++){
        char c = s.charAt(i);
        if(charCount[c - 'a'] == 1){
            return i;

        }
    }
    
    return -1;
    

    }
}
