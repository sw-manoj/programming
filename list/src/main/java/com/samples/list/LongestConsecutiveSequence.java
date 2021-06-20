package com.samples.list;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

//	https://leetcode.com/problems/longest-consecutive-sequence/
	public int longestConsecutive(int[] nums) {
		Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;

        for (int num : num_set) {
        	if(!num_set.contains(num-1))
        	{
	        	int j = 1;
	        	while(num_set.contains(num+j))
	        	{
	        		j++;
	        	}
	        	longestStreak = Math.max(longestStreak, j);
        	}
        }

        return longestStreak;
	}
	
	public static void main(String[] args) {
		
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
		System.out.println(obj.longestConsecutive(new int []{0,3,7,2,5,8,4,6,0,1}));
		System.out.println(obj.longestConsecutive(new int []{100,4,200,1,3,2}));

	}
}
