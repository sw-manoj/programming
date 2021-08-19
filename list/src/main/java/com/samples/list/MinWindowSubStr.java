package com.samples.list;

public class MinWindowSubStr {

	public String mySol(String s ,String t)
	{
		 int no_of_chars = 256; 

		 
		 char[] sArr = new char[no_of_chars];
		 char[] tArr = new char[no_of_chars];
		 
		 for(char c: t.toCharArray())
		 {
			 tArr[c]++;
		 }
		 
		 int count =0;int start = 0; int finalStartINdex = 0; 
		 int minLen =Integer.MAX_VALUE;
		 
		 
		 for(int j = 0 ; j < s.length() ; j ++)
		 {
			 sArr[s.charAt(j)]++;
			 
			 if(tArr[s.charAt(j)] > 0)
			 {
				 count++;
			 }
			 
			 if(count == t.length())
			 {
				 //extra char's coming after reaching count , we keep adding them in line 25, 
				 //and remove prev added char in this if condn thus checing all window options.
				 while(sArr[s.charAt(start)] > tArr[s.charAt(start)] || tArr[s.charAt(start)] ==0)
				 {
					 if(sArr[s.charAt(start)] > tArr[s.charAt(start)])
					 {
						 sArr[s.charAt(start)]--; 
					 }
					 start++;
				 }
				 
				 int windowLen = j - start + 1;
				 if(minLen > windowLen)
				 {
					 finalStartINdex = start;
					 minLen = windowLen;
				 }
			 }
		 }
		 
		// If no window found 
	        if (finalStartINdex == -1) 
	        { 
	        System.out.println("No such window exists"); 
	        return ""; 
	        } 
		 return s.substring(finalStartINdex, finalStartINdex + minLen);
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
