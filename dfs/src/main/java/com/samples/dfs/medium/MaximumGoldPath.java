package com.samples.dfs.medium;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/path-with-maximum-gold/submissions/
public class MaximumGoldPath {
	
	int[][] direction = {{1,0}, {0,1}, {-1,0},{0,-1}};
	
	public int getMaximumGold(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		
		int max = 0;
		
		for(int i = 0 ; i < grid.length ; i++)
		{
			for(int j = 0; j < grid[0].length ; j++)
			{
				if(grid[i][j] > 0)
				{
					max = Math.max(max, dfs(grid, i , j ));
				}
			}
		}
		return max;
    }
	
	public int dfs(int[][] grid, int r, int c)
	{
		if(r < 0 || c < 0 || r >= grid.length || c>= grid[0].length  || grid[r][c] == 0) return 0;
		int max = 0;
		int old = grid[r][c];
		grid[r][c] = 0;
//		visited.add(r+":"+c);
		for(int[] dir : direction)
		{
			int x = r + dir[0]; int y = c + dir[1];
			max = Math.max(max, dfs(grid, x, y));
		}
		grid[r][c] = old;
		return max + grid[r][c];
	}
	
	public static void main(String[] args) {
		MaximumGoldPath obj = new MaximumGoldPath();
		System.out.println(obj.getMaximumGold(new int[][] {{0,6,0},{5,8,7},{0,9,0}}));
		System.out.println(obj.getMaximumGold(new int [][] {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}}));
	}

}
