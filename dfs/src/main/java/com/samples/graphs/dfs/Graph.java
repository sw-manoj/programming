package com.samples.graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	public List<Node>[] adjList;
	int v;
	
	public Graph(int v)
	{
		this.v=v;
		adjList = new ArrayList[v];
		for(int i = 0 ; i < v ; i++)
		{
			adjList[i] = new ArrayList<Node>();
		}
	}
	
	//Function to add an edge into the graph 
    public void addEdge(int v, int w) 
    { 
    	Node adjnode = new Node(w);
    	Node node = new Node(v);
    	adjList[v].add(adjnode);  // Add w to v's list. 
    	adjList[w].add(node);    //Add v to w's list 
    } 
    
	public List<Node>[] getAdjList() {
		return adjList;
	}
	public void setAdjList(List<Node>[] adjList) {
		this.adjList = adjList;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	
	
}
