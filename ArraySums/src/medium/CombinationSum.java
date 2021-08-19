package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

//	https://leetcode.com/problems/combination-sum/solution/
	
	
	
	public void backtrack(int[] candidates, int target, int start, LinkedList<Integer> comb, List<List<Integer>> result)
	{
		if(target == 0)
		{
			result.add(new ArrayList<>(comb));
			return;
		}else if(target < 0)
		{
			return;
		}
		
		for(int i = start;i < candidates.length;i++)
		{
			comb.add(candidates[i]);
			backtrack(candidates, target - candidates[i], i, comb, result);
			comb.removeLast();
		}
		
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(candidates, target, 0, comb, result);
        return result;
    }
	
}
