package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestContinousIncreasingSeq {

//	https://leetcode.com/problems/longest-continuous-increasing-subsequence/
	    public int findLengthOfLCIS(int[] nums) {
	        
	    	int[] dp = new int[nums.length];
			int max = 1;
			for(int i = 1; i < nums.length ; i++)
			{
				for(int j = i-1; j >=0 ;j--)
				{
					if(nums[i] > nums[j])
					{
						dp[i] = Math.max(dp[i], Math.max(dp[j], 1) + 1);
						max = Math.max(dp[i], max);
					}
				}
			}
			return max;
	    }
	    
	    public int lengthOfLIS_opt(int[] nums) {
	        ArrayList<Integer> sub = new ArrayList<>();
	        sub.add(nums[0]);
	        
	        for (int i = 1; i < nums.length; i++) {
	            int num = nums[i];
	            if (num > sub.get(sub.size() - 1)) {
	                sub.add(num);
	            } else {
	                // Find the first element in sub that is greater than or equal to num
	                int j = 0;
	                while (num > sub.get(j)) {
	                    j += 1;
	                }
	                
	                sub.set(j, num);
	            }
	        }
	        
	        return sub.size();
	    }
	    
	    public static void main(String[] args) {
			LongestContinousIncreasingSeq obj = new LongestContinousIncreasingSeq();
			System.out.println(obj.findLengthOfLCIS(new int[] {1,3,1,2,6}));
			System.out.println(obj.findLengthOfLCIS(new int[] {2,2,2,2,2}));
			System.out.println(obj.findLengthOfLCIS(new int[] {1,3,5,7}));

		}
}
