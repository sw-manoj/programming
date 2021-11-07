package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//https://leetcode.com/problems/longest-increasing-subsequence/solution/
public class LongestIncreasingSubSeq {

	public int lengthOfLIS(int[] nums) {
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
	
    public int lengthOfLIS1(int[] nums) {
    	List<Integer> subList = new ArrayList<>();
    	subList.add(nums[0]);
    	
    	for(int i = 1;i < nums.length ; i++)
    	{
    		int num = nums[i];
    		if(num > subList.get(subList.size()-1))
    		{
    			subList.add(num);
    		}
    		else
    		{
    			//instead of this below loop we can use binary search to find the correct index, which will be more optimized.
    			int j = 0;
    			while(num > subList.get(j))
    			{
    				j++;
    			}
    			subList.set(j, num);
    		}
    	}
    	
    	return subList.size();
    }
	
	public static void main(String[] args) {
		LongestIncreasingSubSeq obj = new LongestIncreasingSubSeq();
		System.out.println(obj.lengthOfLIS1(new int[] {10,9,2,5,3,7,101,18}));
		System.out.println(obj.lengthOfLIS(new int[] {0,1,0,3,2,3}));
		System.out.println(obj.lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
		System.out.println(obj.lengthOfLIS(new int[] {-2,-1}));

	}
}
