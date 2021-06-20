package sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatedSubStrPattern {

//	https://leetcode.com/problems/repeated-substring-pattern/solution
	
	
	public static void main(String[] args) {
		String str = "abcabcabc";
		
		RepeatedSubStrPattern pattern = new RepeatedSubStrPattern();
		System.out.println(pattern.repeatedSubstringPattern(str));
	}
	
//	Approach 4: Knuth-Morris-Pratt Algorithm (KMP)
//	https://www.youtube.com/watch?v=GTJr8OvyEVQ
	
//	https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
	public boolean repeatedSubstringPattern(String s) { //kmp2
        int n = s.length();
        char[] pattern = s.toCharArray();
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        
        

        int l = lps[n - 1];
        // check if it's repeated pattern string
        return l != 0 && n % (n - l) == 0;
    }
	
//	Approach 4: Knuth-Morris-Pratt Algorithm (KMP)
//	https://www.youtube.com/watch?v=GTJr8OvyEVQ
	
//	https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
	public boolean repeatedSubstringPattern_kmp(String s) {
        int n = s.length();
        int[] dp = new int[n];
        // Construct partial match table (lookup table).
        // It stores the length of the proper prefix that is also a proper suffix.
        // ex. ababa --> [0, 0, 1, 2, 1]
        // ab --> the length of common prefix / suffix = 0
        // aba --> the length of common prefix / suffix = 1
        // abab --> the length of common prefix / suffix = 2
        // ababa --> the length of common prefix / suffix = 1
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < n; ++i) {
            int j = dp[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = dp[j - 1];    
            }
            if (s.charAt(i) == s.charAt(j)) {
                ++j;
            }
            System.out.println(Arrays.toString(dp));

            dp[i] = j;    
        }
        
        

        int l = dp[n - 1];
        // check if it's repeated pattern string
        return l != 0 && n % (n - l) == 0;
    }
	
	
//	Approach 3: Find Divisors + Rabin-Karp
	public boolean repeatedSubstringPattern1(String s) {
        int n = s.length();
        if (n < 2) return false;
        if (n == 2) return s.charAt(0) == s.charAt(1);    
            
        for (int i = (int)Math.sqrt(n); i > 0; i--) {
            if (n % i == 0) {
                List<Integer> divisors = new ArrayList<>();
                divisors.add(i);
                if (i != 1) {
                    divisors.add(n / i);    
                }
                for (int l : divisors) {
                    String tmp = s.substring(0, l);
                    int firstHash = tmp.hashCode();
                    int currHash = firstHash;
                    int start = l;
                    while (start != n && currHash == firstHash) {
                        tmp = s.substring(start, start + l);
                        currHash = tmp.hashCode();
                        start += l;    
                    }
                    if (start == n && currHash == firstHash) {
                        return true;    
                    }    
                }     
            }    
        }     
        return false;
    }
}
