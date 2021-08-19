package com.samples.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/submissions/
public class KDistanceBT {

	
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
		List<Integer> res = new ArrayList<>();
		
		
		dfs(root, target, res, k);
		
		return res;
    }
	
	public int dfs(TreeNode node, TreeNode target, List<Integer> res, int k )
	{
		if(node == null ) return -1;
		
		if(node == target)
		{
			addSubTree(node, 0, k, res);
			return 1;
		}else
		{
			int l = dfs(node.left, target, res, k);
			int r = dfs(node.right, target, res, k);

			if(l != -1)
			{
					if(l == k) 
					{
						res.add(node.val);
						return -1;
					
					}
				addSubTree(node.right, l+1 , k, res);
				
				return l+1;
			}
			else if( r != -1)
			{
				if(r == k) 
				{
					res.add(node.val);
					return -1;
				
				}
			addSubTree(node.left, r+1 , k, res);
			return r+1;
			}
			else
			{
				return -1;
			}
//			return -1;
		}
	}
	
	public void addSubTree(TreeNode node,int l, int k, List<Integer> res)
	{
		if(node == null) return;
		if(l == k)
		{
			res.add(node.val);
		}
		else
		{
			addSubTree(node.left, l+1, k, res);
			addSubTree(node.right, l+1, k, res);

		}
	}
	
	
	//using parent is slow compared to above method
	public List<Integer> distanceK_using_parent(TreeNode root, TreeNode target, int k) {
        
		List<Integer> res = new ArrayList<>();
		Map<TreeNode, TreeNode> parentMap = new HashMap<>();
		
		populateParent(root, null, parentMap);
		Set<TreeNode> seen = new HashSet<>();
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.offer(target);
//		queue.offer(null);// null denoates completetion of a level of sub childs.in this case also parents
		
//		seen.add(null);
//		seen.add(target);
		int level = 0;
		while(!queue.isEmpty())
		{
			int size = queue.size();
			System.out.println(queue);
			for(int i = 0 ;i < size;i++)
			{
				TreeNode node = queue.poll();
				if(node == null)
				{
					continue;
				}
				if(level == k)
				{
					res.add(node.val);
					continue;
				}
				
				seen.add(node);

				addToQueue(queue, seen, node.left);
				addToQueue(queue, seen, node.right);

				addToQueue(queue, seen, parentMap.get(node));

			}
			if(level == k)
			{
				return res;
			}
			level++;
		}
		
		return res;
    }
	
	public void addToQueue(Queue<TreeNode> queue, Set<TreeNode> seen, TreeNode node)
	{
		if(!seen.contains(node) && node != null)
		{
			queue.offer(node);
		}
	}
	
	public void populateParent(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap)
	{
		if(node == null) return ;
		parentMap.put(node, parent);
		populateParent(node.left, node, parentMap);
		populateParent(node.right, node, parentMap);
	}
	
	
	public static void main(String[] args) {
		KDistanceBT obj = new KDistanceBT();
		
		TreeNode root = new TreeNode(3);
		 root.left = new TreeNode(5);
		 
		 root.left.left = new TreeNode(6);
		 root.left.right = new TreeNode(2);
		 root.left.right.left = new TreeNode(7);
		 root.left.right.right = new TreeNode(4);
		 
		 root.right = new TreeNode(1);
		 root.right.left = new TreeNode(0);
		 root.right.right = new TreeNode(8);

		 
//		 System.out.println(obj.distanceK(root, root.left, 2));

		 System.out.println(obj.distanceK_using_parent(root, root.left, 2));




	}
}
