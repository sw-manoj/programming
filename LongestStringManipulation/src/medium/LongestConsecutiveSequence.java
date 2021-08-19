package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

//	https://leetcode.com/problems/longest-consecutive-sequence/
	
//	Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//			You must write an algorithm that runs in O(n) time.
	public int longestConsecutive(int[] nums) {
		Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;

        for (int num : num_set) {
        	if(!num_set.contains(num-1)) // used to start from smallest num in increasing seq, e.g ,3,5,2,4 we start enter with 2 and check for upto 5. not not enter for 3,4,5.
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
