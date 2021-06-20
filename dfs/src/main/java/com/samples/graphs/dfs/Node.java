package com.samples.graphs.dfs;

public class Node {

	public int weight;
	
    public 	int vertex;
	
	public Node(int vertex)
	{
		this.vertex = vertex;
	}
	
	public Node(int vertex, int weigth)
	{
		this.weight = weigth;
		this.vertex = vertex;
	}

}
