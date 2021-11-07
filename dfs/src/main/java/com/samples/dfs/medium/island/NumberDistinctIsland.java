package com.samples.dfs.medium.island;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-distinct-islands/

public class NumberDistinctIsland {

	public int numDistinctIslands(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		
		Set<String> path = new HashSet<String>();
		
		for(int i = 0 ; i < grid.length ; i++)
		{
			for(int j = 0; j < grid[0].length ; j++)
			{
				if(grid[i][j] > 0)
				{
					path.add(dfs(grid, i, j, "x"));
					System.out.println(dfs(grid, i, j, "x"));
				}
			}
		}
		return path.size();
    }
	
	String dfs(int[][] grid, int r, int c, String path)
	{
		if(r < 0 || c < 0 || r >= grid.length || c>= grid[0].length  || grid[r][c] == 0) return "0";
		
		grid[r][c] = 0;
		
		String left = "l" + dfs(grid, r,c-1, path);
		String right = "r" + dfs(grid, r,c+1, path);
		String up = "u" + dfs(grid, r-1,c, path);
		String down = "d" + dfs(grid, r+1,c, path);

		return path + left + right + up + down;
	}
	
	public static void main(String[] args) {
		NumberDistinctIsland obj = new NumberDistinctIsland();
		System.out.println(obj.numDistinctIslands(new int [][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
		
		System.out.println(obj.numDistinctIslands(new int [][] {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}}));

	}
}
