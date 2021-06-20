package com.samples.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RightSideView {
	
//	https://leetcode.com/problems/binary-tree-right-side-view/submissions/
	
	private void helper(TreeNode node, Map<Integer, Integer> rightNodes, int level)
	{
		if( node == null)
		{
			return;
		}
		if (!rightNodes.containsKey(level))
		{
			rightNodes.put(level, node.val);
		}
		
		helper(node.right, rightNodes, level+1);
		helper(node.left, rightNodes, level+1);

	}

	public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> rightNodes = new HashMap<Integer, Integer>();
        helper(root, rightNodes, 0);
        return new ArrayList<Integer>(rightNodes.values());
    }
	
	
	public List<Integer> rightSideView_opt(TreeNode root) {
        // dfs
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        dfs(root,result,0);
        return result;
    }
    private void dfs (TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(root.val);
        }
        dfs(root.right, result, depth + 1);
        dfs(root.left, result, depth + 1);
    }
	
	public static void main(String[] args) {
		RightSideView rightView = new RightSideView();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(6);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
				
		System.out.println(rightView.rightSideView(root));
	}
}
