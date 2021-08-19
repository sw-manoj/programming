package com.samples.binarytree;

import java.util.LinkedList;
import java.util.Queue;


public class MinimumDepth {

//	https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		
		MinimumDepth depth =  new MinimumDepth();
		System.out.println(depth.minDepth1(root));
		System.out.println(depth.minDepth(root));

	}
	
	public int minDepth(TreeNode root) {
		if(root==null){return 0;}
		if(root.left==null){return minDepth(root.right) +1;}
		if(root.right==null){return minDepth(root.left)+1;}
		return Math.min(minDepth(root.left),minDepth(root.right))+1;
	}

	public int minDepthOptBST(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        int level = 0;
        if(root!=null){
            q.offer(root);
        }
        while(!q.isEmpty()){
            int n = q.size();
            level++;
            for(int i=0;i<n; i++){
                TreeNode node = q.poll();
                System.out.println(node.val);
                if(node.left==null && node.right==null){
                    return level;
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        return 0;
    }
	
	public int minDepth1(TreeNode root) {
		if(root == null)
		{
			return 0;
		}
        return helper(root, 1);
    }
	
	private int helper(TreeNode root, int depth)
	{
		if(root.left == null && root.right == null)
        {
        	return depth;
        }
		
		int l = Integer.MAX_VALUE,r = Integer.MAX_VALUE ;
		if(root.left != null) 
		{
			l = helper(root.left, depth+1);
		}
		
		if(root.right != null) 
		{
			r = helper(root.right, depth+1);
		}
		
		return Math.min(l, r);
	}
}
