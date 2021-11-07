package com.samples.dfs.medium.island;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.youtube.com/watch?v=_426VVOB8Vo&list=PLtQWXpf5JNGJrA4oZNuF8pRfdxRq3XVm9&index=8
//https://leetcode.com/problems/making-a-large-island/
public class MakingLargeIsland {
	
	public static void main(String[] args) {
		MakingLargeIsland obj = new MakingLargeIsland();
		System.out.println(obj.largestIsland(new int[][] {{1,1},{1,1}}));
	}

	int[][] directions = {{0,1}, {1,0} , {-1,0}, {0,-1}};
	public int largestIsland(int[][] grid) {
		int max = 0;
		if (grid == null || grid.length == 0) return 0;

		Map<Integer, Integer> islandIdCountMap = new HashMap<Integer, Integer>();
		max = markIsland(grid, islandIdCountMap);
		
		System.out.println(islandIdCountMap);
		for(int i = 0 ; i < grid.length ; i++)
		{
			for(int j = 0; j < grid[0].length ; j++)
			{
				if(grid[i][j] == 0)
				{
					Set<Integer> islandIsSet = new HashSet<Integer>();
					int sum = 1;
					for(int[] dir : directions)
					{
						
						int x = i + dir[0];
						int y = j + dir[1];
						if((x < 0 || y < 0 || x > grid.length-1 || y > grid[0].length-1) ) continue;
						
						if(grid[x][y] > 1)
						{
							islandIsSet.add( grid[x][y]);
							
							
						}
						
					}
					
					for(int num : islandIsSet)
					{
						sum += islandIdCountMap.get(num);
					}
					max = Math.max(sum, max);
				}
			}
		}
		return max;
    }
	
	public int markIsland(int[][] grid, Map<Integer, Integer> islandIdCountMap)
	{
		//starting from 2 bcoz, 0,1 is already part of grid.
		int islandId = 2;
		int max = 0;
		for(int i = 0 ; i < grid.length ; i++)
		{
			for(int j = 0; j < grid[0].length ; j++)
			{
				if(grid[i][j] == 1)
				{
					int count = dfs(grid, i, j, islandId);
					max = Math.max(max, count);
					islandIdCountMap.put(islandId, count);
					islandId++;
				}
			}
		}
		return max;
	}
	
	public int dfs(int[][]grid, int r, int c, int islandId)
	 {
		if((r < 0 || c < 0 || r > grid.length-1 || c > grid[0].length-1) || grid[r][c] != 1) return 0;
		
		grid[r][c] = islandId;
		
		int sum = 1;
		
		for(int[] dir : directions)
		{
			
			sum += dfs(grid, r + dir[0], c + dir[1], islandId);
		}
		return sum;
	 }
}
