package Medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

//	https://leetcode.com/problems/permutations/
	public static void main(String[] args) {
		Permutation perm = new Permutation();
		
		System.out.println(perm.permute(new int[] {1,2,3}));
		
		System.out.println(perm.permute_2ndtry(new int[] {1,2,3}));

	}
	
	private void addPerm(int[] nums,LinkedList<Integer> perm ,  List<List<Integer>> result, int index)
	{
		if(perm.size() == nums.length)
		{
			result.add(new ArrayList(perm));
			return;
		}
		
		for(int n : nums)
		{
			if(!perm.contains(n))
			{
				perm.add(n);
				addPerm(nums, perm, result, index);
				perm.removeLast();
			}
		}
	}
	public List<List<Integer>> permute_2ndtry(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<Integer> perm = new LinkedList();
		addPerm(nums, perm, result, 0);
		return result;
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
