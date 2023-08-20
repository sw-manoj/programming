package com.samples.dynamicprog.hard;

import java.util.HashMap;

public class PalindromePartitionIV {

	public static void main(String[] args) {
		PalindromePartitionIV obj = new PalindromePartitionIV();
//		System.out.println(obj.checkPartitioning("juchzcedhfesefhdeczhcujzzvbmoeombv"));
		System.out.println(obj.checkPartitioning("bbab"));

//		System.out.println(obj.checkPartitioning("bcbddxy"));
//		System.out.println(obj.checkPalindrome("juchzcedhfesefhdeczhcuj"));

	}

	private boolean checkPalindrome(String s) {
		return isPalindrome(s, 0, s.length()-1);
	}
	public boolean checkPartitioning(String s) {
		return checkPartitioningHelper(s, 0 ,s.length()-1, 3, new HashMap<>());
	}

	public boolean checkPartitioningHelper(String s , int start, int end, int partitionLimit, HashMap<String, Boolean> memo) {
		if(partitionLimit <= 0) {
			return false;
		}
		if(partitionLimit == 1 && (start == end || isPalindrome(s, start, end))) {
			return true;
		}
		String currentkey = start + "-";
		if(memo.containsKey(currentkey)) {
			return memo.get(currentkey);
		}
		boolean ans = false;
		for(int i = start; i < end; i++ ) {
			if(isPalindrome(s, start, i)) {
				ans = ans | checkPartitioningHelper(s, i+1, end, partitionLimit-1, memo);
			}
		}
		memo.put(currentkey, ans);
		return ans;
	}

	private boolean isPalindrome(String s , int start, int end) {

		while(start <= end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
