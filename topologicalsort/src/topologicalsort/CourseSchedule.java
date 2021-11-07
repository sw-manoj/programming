package topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


//https://leetcode.com/problems/course-schedule/submissions/

public class CourseSchedule {

	Map<Integer, List<Integer>> adjMap = new HashMap<>();

	private boolean isCycle(Set<Integer> visited, int course, Set<Integer> cycle) {
		if (cycle.contains(course)) {
			// if same course is visited while accessing the prerequiste of course, that
			// means cycle is detected.
			return true;
		}

		// end of graph or already visited ,
		if (!adjMap.containsKey(course) || visited.contains(course)) {
			return false;
		}

		visited.add(course);
		cycle.add(course);
		for (int num : adjMap.get(course)) {

			if (isCycle(visited, num, cycle)) {
				return true;
			}
		}

		cycle.remove(course);
		return false;

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		if (prerequisites.length == 0 && numCourses >= 1) {
			return false;
		}

		for (int[] n : prerequisites) {
			if (!adjMap.containsKey(n[1])) {
				adjMap.put(n[1], new ArrayList<>());
			}

			adjMap.get(n[1]).add(n[0]);
		}
		Set<Integer> visited = new HashSet<>();
		Set<Integer> cycle = new HashSet<>();

		for (int course : adjMap.keySet()) {
			if (!visited.contains(course) && isCycle(visited, course, cycle)) {
				// cycle is detected hence csnt complete the course.
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		CourseSchedule obj = new CourseSchedule();
		System.out.println(obj.canFinish_topo(2, new int[][] { { 1, 0 } }));

		obj = new CourseSchedule();
		System.out.println(obj.canFinish_topo(2, new int[][] { { 1, 0 }, { 0, 1 } }));

		obj = new CourseSchedule();
		System.out.println(obj.canFinish_topo(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } }));
	}

	class Node {
		int indegree;
		List<Integer> outNodes = new ArrayList<>();
	}

	Map<Integer, Node> graph = new HashMap<>();

	public boolean canFinish_topo(int numCourses, int[][] prerequisites) {

		if (prerequisites.length == 0)
			return true;
		for (int[] nums : prerequisites) {
			Node src = graph.getOrDefault(nums[1], new Node());
			Node dest = graph.getOrDefault(nums[0], new Node());
			src.outNodes.add(nums[0]);
			dest.indegree += 1;

			graph.put(nums[1], src);
			graph.put(nums[0], dest);

		}



		int totalDeps = prerequisites.length;

		LinkedList<Integer> queue = new LinkedList<>();
		int topoEdges = 0;
		for (int course : graph.keySet()) {
			if (graph.get(course).indegree == 0) {
				queue.add(course);
			}
		}

		while (!queue.isEmpty()) {
			int course = queue.pop();
			if (graph.containsKey(course)) {
				for (int child : graph.get(course).outNodes) {
					graph.get(child).indegree--;
					topoEdges++;
					if (graph.get(child).indegree == 0) {
						queue.add(child);
					}
				}
			}
		}

		if (topoEdges != totalDeps) {
			return false;
		} else {
			return true;
		}
	}


	// leet code solution same as above
	class GNode {
		public Integer inDegrees = 0;
		public List<Integer> outNodes = new LinkedList<Integer>();
	}

	public boolean canFinish1(int numCourses, int[][] prerequisites) {

		if (prerequisites.length == 0)
			return true; // no cycle could be formed in empty graph.

		// course -> list of next courses
		HashMap<Integer, GNode> graph = new HashMap<>();

		// build the graph first
		for (int[] relation : prerequisites) {
			// relation[1] -> relation[0]
			GNode prevCourse = this.getCreateGNode(graph, relation[1]);
			GNode nextCourse = this.getCreateGNode(graph, relation[0]);

			prevCourse.outNodes.add(relation[0]);
			nextCourse.inDegrees += 1;
		}

		// We start from courses that have no prerequisites.
		int totalDeps = prerequisites.length;
		LinkedList<Integer> nodepCourses = new LinkedList<Integer>();
		for (Map.Entry<Integer, GNode> entry : graph.entrySet()) {
			GNode node = entry.getValue();
			if (node.inDegrees == 0)
				nodepCourses.add(entry.getKey());
		}

		int removedEdges = 0;
		while (nodepCourses.size() > 0) {
			Integer course = nodepCourses.pop();

			for (Integer nextCourse : graph.get(course).outNodes) {
				GNode childNode = graph.get(nextCourse);
				childNode.inDegrees -= 1;
				removedEdges += 1;
				if (childNode.inDegrees == 0)
					nodepCourses.add(nextCourse);
			}
		}

		if (removedEdges != totalDeps)
			// if there are still some edges left, then there exist some cycles
			// Due to the dead-lock (dependencies), we cannot remove the cyclic edges
			return false;
		else
			return true;
	}

	protected GNode getCreateGNode(HashMap<Integer, GNode> graph, Integer course) {
		GNode node = null;
		if (graph.containsKey(course)) {
			node = graph.get(course);
		} else {
			node = new GNode();
			graph.put(course, node);
		}
		return node;
	}
}
