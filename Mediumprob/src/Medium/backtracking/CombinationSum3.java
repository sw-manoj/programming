package Medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
	
//	https://leetcode.com/problems/combination-sum-iii/solution/
	public static void main(String[] args) {
		CombinationSum3 combSum = new CombinationSum3();
		
		System.out.println(combSum.combinationSum3(3, 9));
		
		System.out.println(combSum.combinationSum3(3, 11));
	}
	
	public void backtracking(int limit, int k, int start, List<List<Integer>> results, LinkedList<Integer> comb)
	{
		if(limit == 0 && comb.size() == k)
		{
			results.add(new ArrayList<>(comb));
			return;
		}
		else if(limit < 0 || comb.size() > k)
		{
			return;
		}
		
		for(int i = start; i < 9; i++)
		{
			comb.add(i+1);
			backtracking(limit-(i+1), k , i+1, results, comb);
			comb.removeLast();
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        backtracking(n, k , 0 ,results, comb);
        return results;
    }
}
