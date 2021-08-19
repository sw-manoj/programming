package com.samples.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgOfLevelsBT {
	
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			int size = queue.size();
			double sum = 0;
			
			for(int i = 0; i < size; i++)
			{
				TreeNode node = queue.poll();
				sum += node.val;
				if(node.left != null)
				{
					queue.offer(node.left);
				}
				if(node.right != null)
				{
					queue.offer(node.right);
				}
			}
			Double avg =  (sum/size);
			res.add(avg);
		}
		
        return res;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		 root.left = new TreeNode(9);
		 
//		 root.left.left = new TreeNode(6);
//		 root.left.right = new TreeNode(2);
//		 root.left.right.left = new TreeNode(7);
//		 root.left.right.right = new TreeNode(4);
		 
		 root.right = new TreeNode(20);
		 root.right.left = new TreeNode(15);
		 root.right.right = new TreeNode(7);

		 
//		 System.out.println(obj.distanceK(root, root.left, 2));
		 AvgOfLevelsBT obj  = new AvgOfLevelsBT();
		 System.out.println(obj.averageOfLevels(root));
	}
}
