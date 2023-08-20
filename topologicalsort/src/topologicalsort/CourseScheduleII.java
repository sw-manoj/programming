package topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {

	Map<Integer, List<Integer>> adjMap = new HashMap<>();

	public void findCourseUtil(Set<Integer> visited, Stack<Integer> stack, int course) {
		if (visited.contains(course)) {
			return;
		}

		visited.add(course);
		if (adjMap.containsKey(course)) {
			for (int child : adjMap.get(course)) {
				if (!visited.contains(child)) {
					findCourseUtil(visited, stack, child);
				}
			}
		}

		stack.push(course);
	}

	//not working
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		if (prerequisites.length == 0 && numCourses >= 1) {
			int[] res = new int[numCourses];

			for(int i = 0 ; i < numCourses; i++) {
				res[i] = i;
			}
			return res;
		}

		for (int[] nums : prerequisites) {
			if (!adjMap.containsKey(nums[1])) {
				adjMap.put(nums[1], new ArrayList<>());
			}
			adjMap.get(nums[1]).add(nums[0]);
		}

		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();

		for (int course : adjMap.keySet()) {
			if (!visited.contains(course)) {
				findCourseUtil(visited, stack, course);
			}
		}

		int[] res = new int[stack.size()];
		int i = 0;
		while (!stack.isEmpty()) {
			res[i] = stack.pop();
			i++;
		}

		return res;
	}

	public static void main(String[] args) {
		CourseScheduleII obj = new CourseScheduleII();
//		print(obj.findOrder(2, new int[][] { { 1, 0 } }));
//
//		obj = new CourseScheduleII();
//		print(obj.findOrder_topo(2, new int[][] { { 1, 0 }, { 0, 1 } }));

		obj = new CourseScheduleII();
		print(obj.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 }, {0, 3} }));

//		obj = new CourseScheduleII();
//		print(obj.findOrder_topo(1, new int[][] {} ));
	}

	public static void print(int[] res) {
		for (int n : res) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	class Node {
		int indegree;
		List<Integer> outNodes = new ArrayList<>();
	}

	Map<Integer, Node> graph = new HashMap<>();

	
	//working
	public int[] findOrder_topo(int numCourses, int[][] prerequisites) {

		if (prerequisites.length == 0 && numCourses >= 1) {
			return new int[] {};
		}

		for (int[] nums : prerequisites) {
			Node src = graph.getOrDefault(nums[1], new Node());
			Node dest = graph.getOrDefault(nums[0], new Node());
			src.outNodes.add(nums[0]);
			dest.indegree += 1;

			graph.put(nums[1], src);
			graph.put(nums[0], dest);

		}

		Queue<Integer> queue = new LinkedList<>();
		int[] res = new int[numCourses];

//		for(Entry<Integer, Node> node :graph.entrySet())
//		{
//			if(node.getValue().indegree == 0)
//			{
//				queue.offer(node.getKey());
//			}
//		}

		for (int i = 0; i < numCourses; i++) {
			if (graph.get(i) == null || graph.get(i).indegree == 0) {
				queue.add(i);
            }
        }
		int topoSort = 0;
		while (!queue.isEmpty()) {
			int nodeKey = queue.poll();
			res[topoSort] = nodeKey;
			topoSort++;

			if(graph.get(nodeKey) != null)
			{
			for (Integer child : graph.get(nodeKey).outNodes) {
				graph.get(child).indegree--;

				if (graph.get(child).indegree == 0) {
					queue.offer(child);
				}
			}
			}
		}

		if (topoSort == numCourses) {
			return res;
		}

		return new int[0];
	}
}
