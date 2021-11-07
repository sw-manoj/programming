package com.samples.dfs.easy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/path-sum-iii/solution/
public class PathSumIII {
	int count;
	Map<Integer, Integer> prefixCache = new HashMap<Integer, Integer>();
	public void helper(TreeNode node, int k, int currSum)
	{
		if(node == null) return ;
		
		// current prefix sum
        currSum += node.val;

        // here is the sum we're looking for
        if (currSum == k)
            count++;	
		
         // number of times the curr_sum − k has occured already, 
            // determines the number of times a path with sum k 
            // has occured upto the current node
		count += prefixCache.getOrDefault(currSum - k , 0);
		
		
		// add the current sum into hashmap
        // to use it during the child nodes processing
		prefixCache.put(currSum , prefixCache.getOrDefault(currSum , 0) + 1);
		
		helper(node.left, k, currSum);
		helper(node.right, k, currSum);
		
		
		// remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
		prefixCache.put(currSum, prefixCache.getOrDefault(currSum , 0) - 1);
		
	}

	public int pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0);
        return count;
    }
}
