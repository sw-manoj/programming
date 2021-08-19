package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/3sum/
public class ThreeSum {
	
	
    public List<List<Integer>> threeSum1(int[] nums) {
    	Set<List<Integer>> result = new HashSet<>();
    	
    	
    	for(int i = 0 ; i < nums.length ; i++)
    	{
    		int n = nums[i];
        	Set<Integer> cache = new HashSet<>();

    		
    		for(int j = i+1 ; j < nums.length;j++)
    		{
    			int tar = -n - nums[j];
    			if(cache.contains(tar))
    			{
    				List list = Arrays.asList(n, nums[j], tar);
    				Collections.sort(list);
    				result.add(list);
    			}
    			cache.add(nums[j]);
    		}
    	}
    	
    	return new ArrayList<>(result);
    }

	static void print(int[] res)
	{
		for(int num : res)
		{
			System.out.print(num + " ");
		}
		System.out.println();
	}
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		print(nums);
		for (int i = 0 ; i < nums.length && nums[i] <= 0; i++)
		{
			if(i == 0 || nums[i-1] != nums[i])
			{
				twoSum(i, nums, result);
			}
		}
		return result;
    }
	
	private void twoSum(int i, int[] nums, List<List<Integer>> result)
	{
		int l = i+1;
		int h = nums.length-1;
		
		while(l < h)
		{
			int tar = nums[i] + nums[l] + nums[h];
			
			if(tar == 0)
			{
				System.out.println(i + "==" + l + "==" + h);
//				System.out.println(nums[i] + "==" + nums[l] + "==" + nums[h]);

				result.add(Arrays.asList(nums[i] , nums[l] , nums[h]));
				l++;
				h--;
				
				// inorder to avoid duplicates atleast  one of the next values has to be changed, so commecnted while also works to avoid duplicates.
				//  the idea is if we avoid duplicated at one end, the sum wont be zero anyways.
//				while(l < h && nums[l-1] == nums[l])  
//				{
//					l++;
//				}
				
				while(l < h && nums[h+1] == nums[h]) // inorder to avoid duplicates atleast  one of the next values has to be changed 
				{
					h--;
				}
			}else if(tar < 0)
			{
				l++;
			}
			else
			{
				h--;
			}
		}
	}
	
	
	public List<List<Integer>> threeSum_withoutsort(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();

		for (int i = 0 ; i < nums.length; i++)
		{
//			Set<Integer> cache = new HashSet<>();

			for(int j  = i+1 ; j < nums.length;j++)
			{
				int tar = - nums[i] - nums[j];
				if(seen.containsKey(tar) && seen.get(tar) == i)
				{
					List<Integer> list = Arrays.asList(nums[i], nums[j], tar);
					Collections.sort(list);

					result.add(list);
				}
//				cache.add(nums[j]);
				seen.put(nums[j], i);
				
			}
		}
		return new ArrayList<>(result);
	}
	
	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();
		System.out.println(obj.threeSum1(new int[] {-1,0,1,2,-1,-4}));
		System.out.println(obj.threeSum(new int[] {-1,0,1,2,-1,-4}));

		System.out.println(obj.threeSum_withoutsort(new int[] {-1,0,1,2,-1,-4}));

	}
}
