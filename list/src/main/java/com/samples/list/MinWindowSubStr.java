package com.samples.list;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubStr {

	public String mySol(String s ,String t)
	{

		if(t.length() > s.length()) return  "";
		Map<Character, Integer> tMap = new HashMap<>();
		for(char c : t.toCharArray()) {
			int count = tMap.getOrDefault(c, 0);
			tMap.put(c, count+1);
		}

		int minStartIndex = -1;
		int minEndIndex = 0;
		int minWindowLen = Integer.MAX_VALUE;
		int currentWindowLen = 0;
		Map<Character, Integer> windowMap = new HashMap<>();
		int tLen = t.length();
		int start = 0;
		int end = 0;
		int matchingCharLen = 0;

		while(end < s.length() ) {

			char currChar = s.charAt(end);
			int charFreq = windowMap.getOrDefault(currChar, 0);
			windowMap.put(currChar, charFreq+1);
			currentWindowLen++;
			if(tMap.containsKey(currChar) && tMap.get(currChar) > 0 && windowMap.get(currChar) <= tMap.get(currChar)) {
				matchingCharLen++;
			}

			while(matchingCharLen == tLen) {
				if(end-start+1 < minWindowLen) {
					minWindowLen = end-start+1;
					minStartIndex = start;
					minEndIndex = end;
				}
				char startChar = s.charAt(start);

				if(tMap.containsKey(startChar) && tMap.get(startChar) > 0 && windowMap.get(startChar) <= tMap.get(startChar)) {
					matchingCharLen--;
				}
				int count = windowMap.get(startChar);
				windowMap.put(startChar, count-1);
				start++;
			}
			end++;
		}
		if(minStartIndex == -1) {
			return "";
		}

		return s.substring(minStartIndex, minEndIndex + 1);
	}
    public String minWindow(String s, String t) {
        //Fault condition.
        if (t.length() > s.length()) {
            return "";
        }
        //Count chars in t.
        int[] tHas = new int[128];
        for (char ch : t.toCharArray()) tHas[ch]++;
        
        char[] sArray = s.toCharArray();
        //Setup the window.
        int localLeft = 0, localRight = 0, globalLeft = 0, globalRight = 0, missing = t.length();
        
        //Read.
        while(localRight < sArray.length) {
            //Only if we find the character in t should we update the counts.
            if (tHas[sArray[localRight]] > 0) {
                missing--;
            }
            tHas[sArray[localRight]]--;
            localRight++;
            
            while(missing == 0) {
            	//this considers sustring from start to end where all chars match in t.
            	//when we enter 2nd time, the global diff is less than local difff thus we try removing unwanted char's at beginning of local (incrementing local left pointer)
            	//when the local window becomes less than the global window we reassign the global window size.
                if (globalRight == 0 || (localRight - localLeft) < (globalRight - globalLeft)) {
                    globalRight = localRight;
                    globalLeft = localLeft;
                }
                
                //below two lines actually removes the char's not in t and duplicate char's from t in s, by moving left pointer to substring which makes sense
                //NOTE: what happens for char not in t? , since we decrement at top with right pointer we can equally increament here thus will never reach more than 0 .
                tHas[sArray[localLeft]]++;
                if (tHas[sArray[localLeft]] > 0)
                {
                	missing++;
                }
                localLeft++;
                }
            }
        
        
        return s.substring(globalLeft, globalRight);
    }

    public static void main(String[] args) {
    	String S = "ADOBECODEBANC";String T = "ABC";
    	
    	MinWindowSubStr subStr = new MinWindowSubStr();
    	String res = subStr.minWindow(S, T);
    	System.out.println(res);
	}
        

//	public String minWindow(String s, String t) {
//        char[] charArr = t.toCharArray();
//        
//        Map<Character,Integer> cache = new HashMap<Character, Integer>();
//        char[] strArr = s.toCharArray();
////        for(int i = 0 ; i <  charArr.length ;i++)
//        {
////        	cache.put(charArr[i], -1);
////        }
//        int[] res =  {-1,-1};
//        int lastFoundIndex = 0;
//        int distance = 0;
//        for(int i = 0 ; i < strArr.length ; i++)
//        {
//        	if(t.contains(String.valueOf(strArr[i])))
//        	{
//        		Integer charIndex = cache.get(strArr[i]);
//        		
//        		cache.put(strArr[i], i);
//        		if(charIndex == null)
//        		{
//        		if(lastFoundIndex != -1)
//        		{
//        			//first element
//        			distance = distance + (i - lastFoundIndex);
//            		
//        		}
//        			lastFoundIndex = i;
//        		}else
//        		{
//        			//same char appearing 2ndtime
//        			if(lastFoundIndex != -1)
//            		{
//        				distance = distance + (i - lastFoundIndex);
//        				lastFoundIndex = i;
//                		
//            		}
//        			else
//        			{
//        				
//        			}
//
//        		}
//        	
//        		
//        		
//        	}
//        	}
//        }
//    }
}
