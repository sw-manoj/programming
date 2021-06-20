package com.samples.random.recurssion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class LongestIncreasingSeq {

	ReentrantReadWriteLock readwriteLock = new ReentrantReadWriteLock();
	ReadLock readLock = readwriteLock.readLock();
	WriteLock writeLock = readwriteLock.writeLock();
	
	
	public int lengthOfLIS1(int[] nums) {
		
		if (nums.length == 0) {
			return 0;
		}
		int maxAns = 1;
		int[] dp = new int[nums.length];
		int i = 1;
		dp[0] = 1;

		for (i = 1; i < nums.length; i++) {
			int maxVal = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					maxVal = Math.max(maxVal,dp[j]);
					
				}
			}
			dp[i] = maxVal + 1;
			maxAns = Math.max(maxAns,dp[i]);
		}
		return maxAns;

	}
	
	public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
         System.out.println(maxans);
        return maxans;
    }
	
	 public List<Integer> lengthOfLIS(int[] nums) {
		 Map<Integer,Map<Integer,List<Integer>>> memo = new HashMap<Integer,Map<Integer,List<Integer>>>(nums.length); 
		 List<Integer> res = lengthofLIS(nums, -1, 0,memo);
	        return res;
	    }
	 
	 private void init(List<List<List<Integer>>> memo, int n)
	 {
		 for(int i = 0 ; i < n ; i ++)
		 {
			 memo.add(i, new ArrayList<List<Integer>>());
			 for(int j = 0 ;  j < n ; j++)
			 {
				 memo.get(i).add(j, new ArrayList<Integer>());
			 }
		 }
	 }

	 // not working
	    public List<Integer> lengthofLIS(int[] nums, int prev, int curpos,Map<Integer,Map<Integer,List<Integer>>> memo) {
	        if (curpos == nums.length) {
	            return new ArrayList<Integer>();
	        }
	        
	        if(memo.containsKey(prev + 1) && memo.get(prev + 1).containsKey(curpos))
	        {
	        	return memo.get(prev + 1).get(curpos);
	        }
	        List<Integer> taken = new ArrayList<Integer>();
	        if (prev < 0 || nums[curpos] > nums[prev]) {
	            taken = lengthofLIS(nums, curpos, curpos + 1,memo);
	            taken.add(nums[curpos]);
	        }
	        List<Integer> nottaken = lengthofLIS(nums, prev , curpos + 1, memo);
	        //memo[prev + 1][curpos] = taken.size() > nottaken.size() ? taken : nottaken;
	        
	        if(!memo.containsKey(prev+1))
	        {
	        	memo.put(prev+1, new HashMap<Integer,List<Integer>>());
	        }
	        if(!memo.get(prev + 1).containsKey(curpos))
	        {
	        	memo.get(prev + 1).put(curpos, new ArrayList<Integer>());
	        }
	        memo.get(prev + 1).get(curpos).clear();
	        memo.get(prev + 1).get(curpos).addAll(taken.size() > nottaken.size() ? taken : nottaken);
	        return memo.get(prev + 1).get(curpos);
	    }
	    
	    
	    public static void main(String[] args) {
			LongestIncreasingSeq seq = new LongestIncreasingSeq();
			System.out.println(seq.lengthOfLIS1(new int[] {10,9,2,5,3,7,101,18}));
		}
}
