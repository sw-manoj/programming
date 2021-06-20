package com.samples.random;

public class LongestPalinddrome {
// longest palindrime that can be formed from a string any combination
	 public int longestPalindrome(String s) {
	        int[] count = new int[128];
	        for (char c: s.toCharArray())
	            count[c]++;

	        int ans = 0;
	        for (int v: count) {
	            ans += v / 2 * 2;
	            if (ans % 2 == 0 && v % 2 == 1)// this condition to  inc $ans just once if single occurrence char exists. making add num str is bigger than even num str.
	                ans++;
	        }
	        return ans;
	    }
	 public static void main(String[] args) {
		LongestPalinddrome p = new LongestPalinddrome();
		System.out.println(p.longestPalindrome("abccccdd"));
	}
}
