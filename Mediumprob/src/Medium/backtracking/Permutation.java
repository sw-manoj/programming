package Medium.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

//	https://leetcode.com/problems/permutations/
	public static void main(String[] args) {
		Permutation perm = new Permutation();

		System.out.println(perm.permute(new int[] { 1, 2, 3 }));

		System.out.println(perm.permute_2ndtry(new int[] { 1, 2, 3 }));

	}

	public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
// if all integers are used up
		if (first == n)
			output.add(new ArrayList<Integer>(nums));
		for (int i = first; i < n; i++) {
// place i-th integer first 
// in the current permutation
			Collections.swap(nums, first, i);
// use next integers to complete the permutations
			backtrack(n, nums, output, first + 1);
// backtrack
			Collections.swap(nums, first, i);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
// init output list
		List<List<Integer>> output = new LinkedList();

// convert nums into list since the output is a list of lists
		ArrayList<Integer> nums_lst = new ArrayList<Integer>();
		for (int num : nums)
			nums_lst.add(num);

		int n = nums.length;
		backtrack(n, nums_lst, output, 0);
		return output;
	}

	private void addPerm(int[] nums, LinkedList<Integer> perm, List<List<Integer>> result, int index) {
		if (perm.size() == nums.length) {
			result.add(new ArrayList(perm));
			return;
		}

		for (int n : nums) {
			if (!perm.contains(n)) {
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

	public List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> perm = new ArrayList();
		backtract(nums, perm, result, 0);
		return result;
	}

	public void backtract(int[] nums, List<Integer> perm, List<List<Integer>> result, int start) {
		if (perm.size() == nums.length) {
			result.add(new ArrayList<>(perm));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (perm.contains(nums[i])) {
				continue;
			}
			perm.add(nums[i]);
			backtract(nums, perm, result, start);
			perm.remove(perm.size() - 1);
		}
	}
}
