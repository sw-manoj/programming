package com.samples.dfs.medium.island;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsSourceTarget {

	 public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 
		 Queue<List<Integer>> queue  = new LinkedList<List<Integer>>();
		 
		 int target = graph.length-1;
		 queue.offer(Arrays.asList(0));
		 
		 while(!queue.isEmpty())
		 {
			 List<Integer> nodeList = queue.poll();
			 int node = nodeList.get(nodeList.size()-1);
			 if(node == target) 
			 {
				 result.add(nodeList);
				 continue;
			 }
			 
			 for(int n : graph[node]) {
				 List list = new ArrayList<Integer>(nodeList);
				 list.add(n);
				 queue.offer(list);
			 }
		 }
		 
		 
		 return result;
	   }
	 
	 public static void main(String[] args) {
		AllPathsSourceTarget obj = new AllPathsSourceTarget();
		System.out.println(obj.allPathsSourceTarget(new int[][] {{1,2},{3},{3},{}}));
		System.out.println(obj.allPathsSourceTarget(new int[][] {{4,3,1},{3,2,4},{3},{4},{}}));

	}
}
