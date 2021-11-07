package graphalgo.aqfer.graph;

import java.util.HashMap;
import java.util.Map;

class Vertex
{
	int id;
	String label;
	static int idCounter = 0;
	Vertex(int id, String l)
	{
		label = l;
		this.id = id;
		idCounter = id;
	}
	
	Vertex( String l)
	{
		label = l;
		idCounter++;
		this.id = idCounter;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
		{
			return false;
		}

		if (getClass() != obj.getClass())
		{
			return false;
		}

		Vertex v = (Vertex) obj;
		return (this.getId() == v.getId() && this.getLabel().equals(v.getLabel()));
	}
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result += PRIME * result + getId();
		result += PRIME * result + getLabel().hashCode();

		return result;
	}
}

public class Graph {

	Map<Vertex, Map<String, Vertex>> adjMap = new HashMap<>();
	
	public void addEdge(Vertex a, Vertex b, String label)
	{

		addVertex(a);
		addVertex(b);
		adjMap.computeIfAbsent(a, v -> new HashMap<>()).put(label, b);
//		Map<String, Vertex> edgeMap = adjMap.getOrDefault(a, new HashMap<>());
//		edgeMap.put(label, b);
		
	}
	
	private void addVertex(Vertex vertex)
	{
		if(!adjMap.containsKey(vertex))
			adjMap.put(vertex, new HashMap<>());
	}
	
	public void addVertex(int id, String content)
	{
		addVertex(new Vertex(id, content));
	}
	
	public void addVertex( String content)
	{
		addVertex(new Vertex(content));
	}
	
//	private void updateRoot(Vertex v)
//	{
//		if(v.getLabel().equals("root"))
//		{
//			root = v;
//		}
//	}
}
