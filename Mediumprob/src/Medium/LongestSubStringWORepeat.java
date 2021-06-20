package Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWORepeat {

//	https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
	
	//sliding window
	public static void main(String[] args) {
//		Input: s = "abcabcbb"
//		Output: 3
//		Explanation: The answer is "abc", with the length of 3.
		
		LongestSubStringWORepeat lssr = new LongestSubStringWORepeat();
		
		System.out.println(lssr.lengthOfLongestSubstring("abcabcbb"));
	}
	public int lengthOfLongestSubstring(String s) {
		int res = 0;
		Integer[] chars = new Integer[128];
		
		int r = 0, l = 0;
		
		while( r < s.length())
		{
			char c = s.charAt(r);
			Integer index = chars[c];
			
			if(index != null && index < r && index >= l )
			{
				l = index + 1;
			}
			
			res = Math.max(res, (r-l+1));
			chars[c] = r;
			r++;
			
		}
		
		return res;
    }
	
	 public int lengthOfLongestSubstring1(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	    }
}
