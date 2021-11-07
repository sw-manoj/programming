package com.samples.dfs.medium;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestBST {

	public void prefixHelper(TreeNode node, int k ,  List<Integer> res)
	{
		if(node == null) return ;
		
		prefixHelper(node.left, k, res);
		res.add(node.val);
		if(res.size() == k)
		{
			return;
		}
		prefixHelper(node.right, k, res);
		if(res.size() == k)
		{
			return;
		}
	}
	public int kthSmallest(TreeNode root, int k) {
        List<Integer> res  = new ArrayList<Integer>();
        
        return res.get(res.size()-1);
    }
}
