package Medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Permutation {

//	https://leetcode.com/problems/permutations/
	public static void main(String[] args) {
		Permutation perm = new Permutation();
		
		System.out.println(perm.permute(new int[] {1,2,3}));
	}
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> perm = new ArrayList();
		backtract(nums, perm, result, 0);
		return result;
    }
	
	public void backtract(int[] nums, List<Integer> perm, List<List<Integer>> result , int start)
	{
		if(perm.size() == nums.length)
		{
			result.add(new ArrayList<>(perm));
			return;
		}
		
		for(int i = 0 ; i < nums.length ; i++)
		{
			if(perm.contains(nums[i]))
			{
				continue;
			}
			perm.add(nums[i]);
			backtract(nums, perm, result, start);
			perm.remove(perm.size() - 1);
		}
	}
}
