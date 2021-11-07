package aqfer.graph.isomorphic;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class IsomorphicTester {

	IsomorphismChecker obj = new IsomorphismChecker();

	Vertex v0;
	Vertex v1;

	Vertex v2;
	Vertex v3;
	Vertex v4;
	Vertex v5;

	@Before
	public void before() {
		v0 = new Vertex("0");
		v1 = new Vertex("1");

		v2 = new Vertex("2");
		v3 = new Vertex("3");
		v4 = new Vertex("4");
		v5 = new Vertex("5");
	}
	
//	@Test
	public void rootTester()
	{
		Graph b = new Graph();
		b.addEdge(v0, v1, "edge0");
		b.addEdge(v1, v2, "edge1");
		b.addEdge(v2, v3, "edge2");
		b.addEdge(v3, v0, "edge3");
		b.addEdge(v4, v3, "edge41");
		b.addEdge(v4, v5, "edge42");
		b.addEdge(v5, v0, "edge5");
		

		assertEquals(RootFinder.findRootVertex(b), v4);
	}
	
//	@Test
	public void duplicateLabelVertex() {

		Graph a = new Graph();
		Vertex dupver = new Vertex("4");
		a.addEdge(dupver, v1, "edge0");
		a.addEdge(v1, v2, "edge1");
		a.addEdge(v2, v3, "edge2");
		a.addEdge(v3, dupver, "edge3");
		a.addEdge(v4, v3, "edge41");
		a.addEdge(v4, v5, "edge42"); 
		a.addEdge(v5, dupver, "edge5");

		Graph b = new Graph();
		b.addEdge(dupver, v1, "edge0");
		b.addEdge(v1, v2, "edge1");
		b.addEdge(v2, v3, "edge2");
		b.addEdge(v3, dupver, "edge3");
		b.addEdge(v4, v3, "edge41");
		b.addEdge(v4, v5, "edge42");
		b.addEdge(v5, dupver, "edge5");
		
		System.out.println(RootFinder.findRootVertex(a));
		System.out.println(RootFinder.findRootVertex(b));
		System.out.println(a.adjMap);
		assertEquals(true, obj.isIsomorphic(a, b));
	}
	
	
//	@Test
	public void wrongNumOfEdges() {

		Graph a = new Graph();
		a.addEdge(v0, v1, "edge0");
		a.addEdge(v1, v2, "edge1");
		a.addEdge(v2, v3, "edge2");
		a.addEdge(v3, v0, "edge3");
		a.addEdge(v4, v3, "edge41");
		a.addEdge(v4, v5, "edge42"); 
		a.addEdge(v5, v0, "edge5");

		Graph b = new Graph();
		b.addEdge(v0, v1, "edge0");
		b.addEdge(v1, v2, "edge1");
		b.addEdge(v2, v3, "edge2");
		b.addEdge(v3, v0, "edge3");
		b.addEdge(v4, v3, "edge41");
		b.addEdge(v4, v5, "edge42");

		assertEquals(false, obj.isIsomorphic(a, b));
	}

//	@Test
	public void wrongEdgeLabel() {

		Graph a = new Graph();
		a.addEdge(v0, v1, "edge0");
		a.addEdge(v1, v2, "edge1");
		a.addEdge(v2, v3, "edge2");
		a.addEdge(v3, v0, "edge3");
		a.addEdge(v4, v3, "edge41");
		a.addEdge(v4, v5, "edge3"); // wrong label here
		a.addEdge(v5, v0, "edge5");

		Graph b = new Graph();
		b.addEdge(v0, v1, "edge0");
		b.addEdge(v1, v2, "edge1");
		b.addEdge(v2, v3, "edge2");
		b.addEdge(v3, v0, "edge3");
		b.addEdge(v4, v3, "edge41");
		b.addEdge(v4, v5, "edge42");
		b.addEdge(v5, v0, "edge5");

	
		assertEquals(false, obj.isIsomorphic(a, b));
	}

	
	@Test
	public void similarGraph() {

		Graph a = new Graph();
		a.addEdge(v0, v1, "edge0");
		a.addEdge(v1, v2, "edge1");
		a.addEdge(v2, v3, "edge2");
		a.addEdge(v3, v0, "edge3");
		a.addEdge(v4, v3, "edge41");
		a.addEdge(v4, v5, "edge42"); 
		a.addEdge(v5, v0, "edge5");

		Vertex n3 = new Vertex("3");
		Vertex n5 = new Vertex("5");
		Graph b = new Graph();
		b.addEdge(v0, v1, "edge0");
		b.addEdge(v1, v2, "edge1");
		b.addEdge(v2, n3, "edge2");
		b.addEdge(n5, v0, "edge5");
		b.addEdge(v4, n5, "edge42");
		b.addEdge(v4, n3, "edge41");
		b.addEdge(n3, v0, "edge3");

	
		assertEquals(true, obj.isIsomorphic(a, b));
	}
	
}
