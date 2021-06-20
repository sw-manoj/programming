package com.samples.graphs.dfs.binconnected;

import com.samples.graphs.dfs.Graph;
import com.samples.graphs.dfs.Node;

public class FindArticulationPt {

	int visitedCount;

	void findArt(int[] parent, boolean[] visited, int[] lowTime, int[] vTime, Graph graph, int vertex) {
		visited[vertex] = true;
		visitedCount++;
		vTime[vertex] = lowTime[vertex] = visitedCount;
		int childCount = 0;
		for (Node adjNode : graph.adjList[vertex]) {

			if (!visited[adjNode.vertex]) {
				childCount++;
				parent[adjNode.vertex] = vertex;
				findArt(parent, visited, lowTime, vTime, graph, adjNode.vertex);

				// this is a tree edge , since
				// lowTIme is calculated by
				// bottom-up approach child will
				// have correct lowtime , hence
				// taking minimum of lowTIme of
				// child and parent  for parent.rule 3
//				low[adjNode.vertex] will have the discovery time of the earliest discovered vertex that can be reached from any vertex in the subtree rooted at adjNode.vertex.
				lowTime[vertex] = Math.min(lowTime[adjNode.vertex], lowTime[vertex]);
				
				if (parent[vertex] == -1 && childCount > 1)
				{
					// this condn is root nodes
					System.out.println(vertex + " is a articulation point");
				}

				// (2) If u is not root and low value of one of its child
				// is more than discovery value of u.
				if (parent[vertex] != -1 && lowTime[adjNode.vertex] >= vTime[vertex]) // condn for art pt
				{
					System.out.println(vertex + " is a articulation point");
				}

			} else {
				if (parent[vertex] != adjNode.vertex) // back edge
				{
					lowTime[vertex] = Math.min(lowTime[vertex], vTime[adjNode.vertex]);// here adjNode is the parent
																						// which form s the cycle.
				}
			}
		}
	}

	void start(Graph graph, int startVertex) {
		int[] parent = new int[graph.getV()];
		boolean[] visited = new boolean[graph.getV()];
		int[] lowTime = new int[graph.getV()];
		int[] vTime = new int[graph.getV()];
		for (int i = 0; i < graph.getV(); i++) {
			parent[i] = -1;
//			lowTime[]
		}
		findArt(parent, visited, lowTime, vTime, graph, startVertex);
	}

	public static void main(String[] args) {
		FindArticulationPt findArt = new FindArticulationPt();
		System.out.println("Articulation points in first graph ");
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);

		findArt.start(g1, 0);
		System.out.println();
	}

}
