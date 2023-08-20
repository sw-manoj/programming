package com.samples.dynamicprog.hard;


//Given a string s, partition s such that every
//		substring
//		of the partition is a
//		palindrome
//		.
//
//		Return the minimum cuts needed for a palindrome partitioning of s.

import java.util.HashMap;

//		https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartitioningII {

	public static void main(String[] args) {
		PalindromePartitioningII obj = new PalindromePartitioningII();
//		System.out.println(obj.minCut(""));
//		System.out.println(obj.minCut("ab"));

		System.out.println(obj.minCut("aacb"));
//		System.out.println("aacb".substring(1,1));

	}

	private Integer memoCuts[][];
	private Boolean memoPalindrome[][];
//
//	public int minCut(String s) {
//		memoCuts = new Integer[s.length()][s.length()];
//		memoPalindrome = new Boolean[s.length()][s.length()];
//		return findMinimumCut(s, 0, s.length() - 1, s.length() - 1);
//	}
//
//	private int findMinimumCut(String s, int start, int end, int minimumCut) {
//		// base case
//		if (start == end || isPalindrome(s, start, end)) {
//			return 0;
//		}
//		// check for results in memoCuts
//		if (memoCuts[start][end] != null) {
//			return memoCuts[start][end];
//		}
//		for (int currentEndIndex = start; currentEndIndex <= end; currentEndIndex++) {
//			if (isPalindrome(s, start, currentEndIndex)) {
//				minimumCut = Math
//						.min(minimumCut, 1 + findMinimumCut(s, currentEndIndex + 1, end, minimumCut));
//			}
//		}
//		return memoCuts[start][end] = minimumCut;
//	}
//
//	private boolean isPalindrome(String s, int start, int end) {
//		if (start >= end) {
//			return true;
//		}
//		// check for results in memoPalindrome
//		if (memoPalindrome[start][end] != null) {
//			return memoPalindrome[start][end];
//		}
//		return memoPalindrome[start][end] = (s.charAt(start) == s.charAt(end))
//				&& isPalindrome(s, start + 1, end - 1);
//	}


	public int minCut(String s) {
		return minCutHelper(s, 0, s.length()-1, new HashMap<>());
	}

	public int minCutHelper(String s, int start, int end, HashMap<String, Integer> memo) {
		if(start == end || isPalindrome(s, start, end)) {
			return 0;
		}

		if(start > end) {
			return 0;
		}
		String currentkey = start + "-" + end;
		if(memo.containsKey(currentkey)) {
			return memo.get(currentkey);
		}
		if (memoCuts[start][end] != null) {
			return memoCuts[start][end];
		}
		int ans = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			if(isPalindrome(s, start, i)) {
				int tmp = 1 + minCutHelper(s, i+1, end, memo);
				ans = Math.min(ans, tmp);
			}

		}
		memo.put(currentkey, ans);
		memoCuts[start][end] = ans;
		return ans;
	}

	private boolean isPalindrome(String s, int start, int end) {
		while( start <= end) {
			if (memoPalindrome[start][end] != null) {
			return memoPalindrome[start][end];
		}
			if(s.charAt(start) != s.charAt(end)) {
				memoPalindrome[start][end] = false;
				return false;
			}
			start += 1;
			end -= 1;
		}
		memoPalindrome[start][end] = true;
		return true;
	}
}
