package slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/
public class MinWindowSubStr {

	public String minWindow(String s, String t) {
        
		int left  = 0;
		int right = 0;
		int ml = 0;
		int mr = Integer.MAX_VALUE;
		int[] tchar = new int[128];
		int[] sArr = new int[256];

		for(char c : t.toCharArray()) tchar[c]++;
		
		
		int count = 0;
		while (right < s.length())
		{
			if(tchar[s.charAt(right)] > 0)
			{
				count++;
			}
			
			tchar[s.charAt(right)]--;


			
			while(count == t.length())
			{
				
				if(right - left < mr-ml)
				{
					mr = right;
					ml = left;
						
				}
				tchar[s.charAt(left)]++;
				if(tchar[s.charAt(left)] > 0)
				{
					count--;
				}
				
				left++;
			}
			
			right++;
		}
		if(mr == Integer.MAX_VALUE )
			return "";
//		System.out.println(ml + "==" + mr);
		return s.substring(ml, mr+1);
    }
	
	public String minWindow1(String s, String t) {
		Map<Character, Integer> tCountMap = new HashMap<>();
		for(char c : t.toCharArray()) 
		{
			int count = tCountMap.getOrDefault(c, 0);
			tCountMap.put(c, count+1);
		}
		
		int required = tCountMap.size();
		int formed = 0;
		int r = 0, l= 0;
		int mr = -1, ml = 0;
		
		Map<Character,Integer> window = new HashMap<>();
		while(r < s.length())
		{
			char rc = s.charAt(r);
			int c = window.getOrDefault(rc, 0);
			window.put(rc, c+1);
			
			if(tCountMap.containsKey(rc) && window.get(rc) == tCountMap.get(rc))
			{
				formed++;
			}
			
			while(formed == required && l <= r)
			{
				if(mr == -1 || (mr-ml) > (r-l))
				{
					mr = r;
					ml = l;
				}
				char lc = s.charAt(l);
				window.put(lc, window.get(lc)-1);
				if( tCountMap.containsKey(lc) && window.get(lc) < tCountMap.get(lc))
				{
					formed--;
				}
				
				l++;
			}
			
			r++;
		}

		return mr == -1 ? "" : s.substring(ml, mr+1);
	}
	
	public static void main(String[] args) {
		MinWindowSubStr obj = new MinWindowSubStr();
		System.out.println(obj.minWindow("ADBOECBANC", "ABC"));
		
		System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
		
		System.out.println(obj.minWindow("bdab", "ab"));
		System.out.println(obj.minWindow("a", "a"));

		System.out.println(obj.minWindow("a", "aa"));
		System.out.println(obj.minWindow("bba", "ab"));
		System.out.println(obj.minWindow("ABABC", "ABC"));
		
		System.out.println("======");
		System.out.println(obj.minWindow1("ADBOECBANC", "ABC"));
		
		System.out.println(obj.minWindow1("ADOBECODEBANC", "ABC"));
		
		System.out.println(obj.minWindow1("bdab", "ab"));
		System.out.println(obj.minWindow1("a", "a"));

		System.out.println(obj.minWindow1("a", "aa"));
		System.out.println(obj.minWindow1("bba", "ab"));
		System.out.println(obj.minWindow1("ABABC", "ABC"));


	}

}
