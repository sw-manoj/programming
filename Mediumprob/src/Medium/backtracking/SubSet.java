package Medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubSet {
//	https://leetcode.com/problems/subsets/
	public static void main(String[] args) {
		SubSet subset = new SubSet();
		System.out.println(subset.subsets(new int[]{1, 2, 3}));
	}

	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
//	    Arrays.sort(nums);
	    backtrack(list, new LinkedList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , LinkedList<Integer> tempList, int [] nums, int start){
		list.add(new ArrayList<>(tempList));
		
		for(int i = start ; i < nums.length;i++)
		{
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i+1);
			tempList.removeLast();
		}
	}
}
