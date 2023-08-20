package com.samples.dynamicprog.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.samples.dynamicprog.hard.PalindromePartitioningII;

//https://leetcode.com/problems/palindrome-partitioning/submissions/
public class PalindromePartition {

	public static void main(String[] args) {
		PalindromePartition obj = new PalindromePartition();
		System.out.println(obj.partition("aab"));
	}

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		partitionHelper(s, 0, result, new ArrayList<>());
		return result;
	}

	public void partitionHelper(String s, int start, List<List<String>> result, List<String> currentList) {

		if(start >= s.length()) {
			result.add(new ArrayList<>(currentList));
			return;
		}
		for(int end = start; end < s.length() ; end ++) {
			if(isPalindrome(s, start, end)) {
				currentList.add(s.substring(start, end+1));
				partitionHelper(s, end+1, result, currentList);
				currentList.remove(currentList.size()-1);

			}
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		while( start < end) {

			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start += 1;
			end -= 1;
		}
		return true;
	}
}
