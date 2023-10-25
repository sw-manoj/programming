package com.samples.dfs.medium;

import java.util.ArrayList;

public class RedundantConnection {

	public int[] findRedundantConnection(int[][] edges) {
		parent = new int[1000];
		rank = new int[1000];
	for(int i = 0; i < parent.length ; i++) {
		parent[i] = i;
	}
		for(int[] edge  :edges) {
			if(!union(edge[0], edge[1])) {
				return edge;
			}
		}
		throw new RuntimeException();
	}

	int[] parent ;
	int[] rank;

	private int find(int x) {

		if(parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	private boolean union(int x, int y) {
		int px = find(x), py = find(y);
		if(px == py) {
			return false;
		}
		else if(rank[px] < rank[py]) {
			parent[px] = py;
		}
		else if(rank[px] > rank[py]) {
			parent[py] = px;
		}
		else{
			parent[py] = px;
			rank[px] += 1;
		}

		return true;
	}
}
