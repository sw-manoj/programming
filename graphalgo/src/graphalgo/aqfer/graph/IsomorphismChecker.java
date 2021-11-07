package graphalgo.aqfer.graph;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class IsomorphismChecker {

	Set<Vertex> visitedVertex1 = new HashSet<>();
	Set<Vertex> visitedVertex2 = new HashSet<>();

	public boolean isIsomorphic(Graph a, Graph b)
	{
		
		if(a.adjMap.size() != b.adjMap.size())
		{
			return false;
		}
		
		//Identify the root vertex from which all the other vertex are reachable . the root finder also considers cycles in graph.
		Vertex aRoot = RootFinder.findRootVertex(a);
		Vertex bRoot = RootFinder.findRootVertex(b);
		

		return isIsomorphicChecker(aRoot, bRoot, a, b);
	}
	
	
	public boolean isIsomorphicChecker(Vertex a, Vertex b, Graph g1, Graph g2)
	{
		
//		if(a == null && b == null) return true;
		
		if(a == null || b == null) return false;
		
		// both the vertex are visited already return true
		if(visitedVertex1.contains(a) && visitedVertex2.contains(b)) return true;
		
		//in case either of the vertex is not visited the graph is not isomorphic
		if(visitedVertex1.contains(a) || visitedVertex2.contains(b)) return false;
		
		// no of edges from corresponding vertex doesn't match then the graphs are not isomorphic.
		if(g1.adjMap.get(a).size() != g2.adjMap.get(b).size()) return false;
		
		// mark the vertex visited.
		visitedVertex1.add(a);
		visitedVertex2.add(b);
		
		for(Entry<String, Vertex> aVertex : g1.adjMap.get(a).entrySet())
		{
			//Check corresponding edge label in other graph, otherwise the grpah isnt isomorphic. 
			if(!g2.adjMap.get(b).containsKey(aVertex.getKey()))
			{
				return false;
			}
			
//			continue iteration with each label of this vertex.
			if( !isIsomorphicChecker(aVertex.getValue(), g2.adjMap.get(b).get(aVertex.getKey()), g1, g2))
			{
				return false;
			}
		}
		return true;
	}
}
