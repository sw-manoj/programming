package com.samples.list;

public class LongestContinousIncreasingSeq {

//	https://leetcode.com/problems/longest-continuous-increasing-subsequence/
	    public int findLengthOfLCIS(int[] nums) {
	        
	    	int max = 1;
	    	int prev = 0;
	    	
	    	for(int i = 1; i < nums.length ; i++)
	    	{
	    		if(nums[i] <= nums[i-1])
	    		{
	    			max = Math.max(max, i-prev);
	    			prev = i;
	    		}
	    	}
	    	
	    	return  Math.max(max, nums.length-prev);
	    }
	    
	    public static void main(String[] args) {
			LongestContinousIncreasingSeq obj = new LongestContinousIncreasingSeq();
			System.out.println(obj.findLengthOfLCIS(new int[] {1,3,1,2,6}));
			System.out.println(obj.findLengthOfLCIS(new int[] {2,2,2,2,2}));
			System.out.println(obj.findLengthOfLCIS(new int[] {1,3,5,7}));

		}
}
