package aqfer.graph.isomorphic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class RootFinder {

	// Utility function to perform DFS traversal on the graph
    public static void DFS(Graph graph, Vertex v,  Set<Vertex> discovered)
    {
        // mark the current node as discovered
        discovered.add(v);
 
        // do for every edge `v —> u`
        for (Entry<String, Vertex> u: graph.adjMap.get(v).entrySet())
        {
            // `u` is not discovered
            if (!discovered.contains(u.getValue())) {
                DFS(graph, u.getValue(), discovered);
            }
        }
    }
 
    // Function to find the root vertex of a graph
    public static Vertex findRootVertex(Graph graph)
    {
        // to keep track of all previously visited vertices in DFS
        Set<Vertex> visited = new HashSet<>();
 
        // find the last starting vertex `v` in DFS
        Vertex v = null;
//        for (int i = 0; i < N; i++)
//        {
//            if (!visited[i])
//            {
//                DFS(graph, i, visited);
//                v = i;
//            }
//        }
 
        for(Vertex vertex : graph.adjMap.keySet())
        {
        	if(!visited.contains(vertex))
        	{
        		DFS(graph, vertex, visited);
                v = vertex;
        	}
        }
        // reset the visited vertices
        visited.clear();
 
        // perform DFS on the graph from the last starting vertex `v`
        DFS(graph, v, visited);
 
        // return -1 if all vertices are not reachable from vertex `v`
        for(Vertex vertex : graph.adjMap.keySet())
        {
        	if(!visited.contains(vertex))
        	{
        		return null;
        	}
        }
 
        // we reach here only if `v` is a root vertex
        return v;
    }
}
