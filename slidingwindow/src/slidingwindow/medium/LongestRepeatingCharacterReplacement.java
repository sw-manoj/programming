package slidingwindow.medium;

//https://leetcode.com/problems/longest-repeating-character-replacement/submissions/
public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
        int maxLen = 0;
        
        int maxFreq = 0;
        
        int start = 0;
        int end = 0;
        char[] charFreq = new char[26];
        for( ; end < s.length() ; end++)
        {
        	charFreq[s.charAt(end)- 'A']++;
        	maxFreq = Math.max(maxFreq, charFreq[s.charAt(end)- 'A']);
        	int windowSize = end-start + 1;
        	int diffCharCount = windowSize - maxFreq;
        	
        	if(diffCharCount > k) // not a valid window with more diff chars than k , so reduce the size of window
        	{
            	charFreq[s.charAt(start)- 'A']--;
            	start++;
        	}
        	else {
        		maxLen = Math.max(maxLen, windowSize);
        	}
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
		System.out.println(obj.characterReplacement("ABBABBA", 2));
	}
}
