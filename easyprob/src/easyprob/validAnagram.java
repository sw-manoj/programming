package easyprob;

import java.util.Arrays;

//https://leetcode.com/problems/valid-anagram/submissions/
public class validAnagram {
	
	public static void main(String[] args) {
		
		System.out.println(1 & 2);
	}

	public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        return String.copyValueOf(c1).equals(String.copyValueOf(c2));
    }
	
	public boolean isAnagram1(String s, String t) {
	    if (s.length() != t.length()) {
	        return false;
	    }
	    int[] counter = new int[26];
	    for (int i = 0; i < s.length(); i++) {
	        counter[s.charAt(i) - 'a']++;
	        counter[t.charAt(i) - 'a']--;
	    }
	    for (int count : counter) {
	        if (count != 0) {
	            return false;
	        }
	    }
	    return true;
	}
}
