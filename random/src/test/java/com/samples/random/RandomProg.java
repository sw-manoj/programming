package com.samples.random;

public class RandomProg {


	public static void main(String[] args) {
		RandomProg obj = new RandomProg();
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
	}

	public int lengthOfLongestSubstring(String s) {
		int[] arr = new int[256];
		int maxlength = 0;
		int windowLength = 0;
		int start = 0;
		int end = 0;
		while(start <= end && end < s.length()) {
			char ch = s.charAt(end);
			arr[ch]++;
			if(arr[ch] > 1) {
				windowLength = end - 1 - start;
				maxlength = Math.max(maxlength, windowLength);
				while(start <= end) {
					if(arr[ch] == 1) {
						break;
					}
					start++;
				}
			}
		}

		return maxlength;
	}
}
