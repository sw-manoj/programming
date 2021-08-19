package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/4sum-ii/

public class FourSumII {

	private int backtrack(List<int[]> numList, int index, int sum)
	{
		if(sum == 0 && index == numList.size())
		{
			return 1;
		}
		if(index >= numList.size()) return 0;
		
		int res = 0;
		for(int num : numList.get(index))
		{
			res += backtrack(numList, index + 1, sum + num);
		}
		return res;
	}
	
	// time limit exceeds
	public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        List<int[]> numList = new ArrayList<>();
        numList.add(nums1);
        numList.add(nums2);
        numList.add(nums3);
        numList.add(nums4);
        
        return backtrack(numList, 0, 0);
        
    }
	
	// works 
	public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cache = new HashMap<>();
        
        for(int a : nums1)
        	for(int b : nums2)
        		cache.put(a+b, cache.getOrDefault(a+b, 0)+1);
        
        int res = 0;
        for(int c : nums3)
        	for(int d : nums4)
        		if(cache.containsKey(- (c+d)))
        		{
        			res += cache.get(- (c+d)) ;
        		}
        
        return res;
    }
	
	//generic
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cache = new HashMap<>();
        int [][] nums = new int[][] {nums1, nums2, nums3, nums4};
        kSum(nums, 0, 0 , cache);
        return countSum(nums, nums.length/2, 0, cache);
	}
	
	public void kSum(int[][] nums, int index , int sum, Map<Integer, Integer> cache)
	{
		if(index == nums.length/2)
		{
    		cache.put(sum, cache.getOrDefault(sum, 0)+1);
    		return;
		}
		
		for(int n : nums[index])
		{
			kSum(nums, index+1, sum + n, cache);
		}
	}
	
	public int countSum(int[][] nums, int index, int sum, Map<Integer, Integer> cache)
	{
		if(index == nums.length && cache.containsKey(-sum))
		{
			return cache.get(-sum) ;
		}
		if(index >= nums.length) return 0;
		
		int res = 0;
		for(int n : nums[index])
		{
			res += countSum(nums, index+1, sum + n, cache);
		}
		
		return res;
		
	}
	public static void main(String[] args) {
		FourSumII obj = new FourSumII();
		
		System.out.println(obj.fourSumCount(new int[] {1,2}, new int[] {-2,-1}, new int[] {-1,2}, new int[] {0,2}));
		
		System.out.println(obj.fourSumCount(new int[] {0}, new int[] {0}, new int[] {0}, new int[] {0}));
		
		System.out.println(obj.fourSumCount1(new int[] {1,2}, new int[] {-2,-1}, new int[] {-1,2}, new int[] {0,2}));
		
		System.out.println(obj.fourSumCount1(new int[] {0}, new int[] {0}, new int[] {0}, new int[] {0}));

	}
}
