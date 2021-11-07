package graphalgo.aqfer.graph;

public class IsomorphicTester {

	
	public static void main(String[] args) {
		IsomorphismChecker obj = new IsomorphismChecker();
		
		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");

		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");

		Graph a = new Graph();
		a.addEdge(v0, v1, "edge0");
		a.addEdge(v1, v2, "edge1");
		a.addEdge(v2, v3, "edge2");
		a.addEdge(v3, v0, "edge3");
		a.addEdge(v4, v3, "edge4");
		a.addEdge(v4, v5, "edge3");
		a.addEdge(v5, v0, "edge5");
		
		
		Graph b = new Graph();
		b.addEdge(v0, v1, "edge0");
		b.addEdge(v1, v2, "edge1");
		b.addEdge(v2, v3, "edge2");
		b.addEdge(v3, v0, "edge3");
		b.addEdge(v4, v3, "edge4");
		b.addEdge(v4, v5, "edge4");
		b.addEdge(v5, v0, "edge5");
		
		Vertex v = RootFinder.findRootVertex(a);
		System.out.println(v.label);
		
		System.out.println(RootFinder.findRootVertex(b));
		
		System.out.println(obj.isIsomorphic(a, b));
	}
}
