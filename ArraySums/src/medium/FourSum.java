package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/4sum/submissions/

public class FourSum {

	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return SumK(nums, 0, target, 4);
    }
	
	public List<List<Integer>> SumK(int[] nums,int start, int target, int k ) {
		List<List<Integer>> result = new ArrayList<>();
		
		
			if(start == nums.length || nums[start] * k > target || nums[nums.length-1] * k < target) 
				//in case nums[start] which is smallest ele * k is > target that means adding other greater elements in array cant reach target .
				// simiallry nums[last] ele * k  is < target  means, target get be reached with smaller ele that that so combitions traveresed till now is wrong so return empty list.
			{
				return result;
			}else if(k == 2)
			{
//				return twoSum_hashset(nums, target, start);
				return twoSum(nums, start, target);

			}
			for(int i = start; i < nums.length ; i++)
			{
				if(i != start && nums[i-1] == nums[i])
				{
					continue;
				}
				for(List<Integer> subList : SumK(nums, i+1, target-nums[i],  k-1))
				{
					List<Integer> tmp = new ArrayList<>();
					tmp.add(nums[i]);
					tmp.addAll(subList);
					
					result.add(tmp);

				}
		}
		
		
		return result;
    }
	
	private List<List<Integer>> twoSum(int[] nums, int start, int target)
	{
		List<List<Integer>> result = new ArrayList<>();

		int l = start;
		int h = nums.length -1;
		
		while(l < h)
		{
			int tar = nums[l] + nums[h];
			if(tar == target)
			{
				result.add(Arrays.asList(nums[l], nums[h]));
				l++;
				h--;
				while(l < h && nums[l-1] == nums[l]) // inorder to avoid duplicates.
				{
					l++;
				}
			}
			else if(tar < target)
			{
				l++;
			}
			else
			{
				h--;
			}
		}
		return result;
	}
	
	public List<List<Integer>> twoSum_hashset(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
    
        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i])
                if (s.contains(target - nums[i]))
                    res.add(Arrays.asList(target - nums[i], nums[i]));
            s.add(nums[i]);
        }
                                                  
        return res;
    }
	
	public static void main(String[] args) {
		FourSum obj = new FourSum();
		System.out.println(obj.fourSum(new int [] {1,0,-1,0,-2,2}, 0));
		System.out.println(obj.fourSum(new int [] {2,2,2,2,2}, 8));

	}
	
	// below methods exceeds time
	public void backtrack(int[] candidates, int target, int start, LinkedList<Integer> comb, Set<List<Integer>> result)
	{
		if(target == 0 && comb.size() == 4)
		{
			ArrayList list = new ArrayList<>(comb);
			Collections.sort(list);
			result.add(list);
			
		}

		
		for(int i = start ; i < candidates.length ; i++)
		{
			comb.add(candidates[i]);
			backtrack(candidates, target-candidates[i], i+1, comb, result);
			comb.removeLast();
		}
	}
	
	public List<List<Integer>> fourSum1(int[] nums, int target) {
		Set<List<Integer>> result = new HashSet<>();
		backtrack(nums, target, 0, new LinkedList<>(), result);
		return new ArrayList<>(result);
    }
	
	
	
	
}
