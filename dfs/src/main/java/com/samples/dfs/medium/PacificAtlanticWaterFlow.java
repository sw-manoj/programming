package com.samples.dfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/pacific-atlantic-water-flow/submissions/

//The naive approach would be to check every cell - that is, iterate through every cell, and at each one, 
//start a traversal that follows the problem's conditions. That is, find every cell that manages to reach both oceans.

//This approach, however, is extremely slow, as it repeats a ton of computation. Instead of looking for every path from cell to ocean, 
//let's start at the oceans and try to work our way to the cells. This will be much faster because when we start a traversal at a cell, 
//whatever result we end up with can be applied to only that cell. However, when we start from the ocean and work backwards, we already know that every cell we visit must be connected to the ocean.

public class PacificAtlanticWaterFlow {
	
	int[][] directions = {{1,0},{-1,0}, {0,1}, {0,-1}};

	private void dfs(int r , int c, boolean[][] reachableNodes, int[][] heights)
	{
		reachableNodes[r][c] = true;
		
		for(int[] row : directions)
		{
			int newRow = r + row[0];
			int newCol = c + row[1];
			
			if(newRow < 0 || newRow > reachableNodes.length -1 || newCol < 0 || newCol > reachableNodes[0].length-1 || reachableNodes[newRow][newCol])
			{
				continue;
			}
			
			if(heights[r][c] <= heights[newRow][newCol])
			{
				dfs(newRow, newCol, reachableNodes, heights);
			}
		}
		
		
	}
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int numRows = heights.length;
		int numCols = heights[0].length;
		
		boolean[][] pacificRechable = new boolean[numRows][numCols];
		boolean[][] atlanticRechable = new boolean[numRows][numCols];

		for(int i = 0 ; i < numRows; i++)
		{
			dfs(i,0,pacificRechable,heights);
			dfs(i,numCols-1,atlanticRechable,heights);
		}
		
		for(int i = 0 ; i < numCols; i++)
		{
			dfs(0,i,pacificRechable,heights);
			dfs(numRows-1,i,atlanticRechable,heights);
		}
		for(int i = 0 ; i < numRows; i++)
		{
			for(int j = 0 ; j < numCols; j++)
			{
				if(pacificRechable[i][j] && atlanticRechable[i][j])
				{
					result.add(Arrays.asList(i, j));
				}
			}
		}
		return result;
    }
	
	private boolean[][] bfs(int numRows, int numCols, Queue<int[]> queue, int[][] heights)
	{
		boolean[][] rechable = new boolean[numRows][numCols];
		
		while(!queue.isEmpty())
		{
			int[] cell = queue.poll();
			int r = cell[0];
			int c = cell[1];
			
			rechable[r][c] = true;
			
			for(int[] newCell : directions)
			{
				int newRow = r + newCell[0];
				int newCol = c + newCell[1];
				
				if(newRow < 0 || newRow > numRows -1 || newCol < 0 || newCol > numCols-1 || rechable[newRow][newCol])
				{
					continue;
				}
				
				if(heights[r][c] <= heights[newRow][newCol])
				{
					queue.offer(new int[] {newRow, newCol});
				}
			}
		}
		return rechable;
	}
	public List<List<Integer>> pacificAtlantic_bfs(int[][] heights) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int numRows = heights.length;
		int numCols = heights[0].length;
		
		Queue<int[]> pacificQueue = new LinkedList<int[]>();
		Queue<int[]> atlanticQueue = new LinkedList<int[]>();

		for(int i = 0 ; i < numRows; i++)
		{
			pacificQueue.offer(new int[] {i, 0});
			atlanticQueue.offer(new int[] {i, numCols-1});
		}
		
		for(int i = 0 ; i < numCols; i++)
		{
			pacificQueue.offer(new int[] {0,i});
			atlanticQueue.offer(new int[] {numRows-1,i});
//			dfs(0,i,pacificRechable,heights);
//			dfs(numRows-1,i,atlanticRechable,heights);
		}
		
		boolean[][] pacificRechable = bfs(numRows, numCols, pacificQueue, heights);
		boolean[][] atlanticRechable = bfs(numRows, numCols, atlanticQueue, heights);
		for(int i = 0 ; i < numRows; i++)
		{
			for(int j = 0 ; j < numCols; j++)
			{
				if(pacificRechable[i][j] && atlanticRechable[i][j])
				{
					result.add(Arrays.asList(i, j));
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] heights = new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
		System.out.println(obj.pacificAtlantic(heights));
		
		System.out.println(obj.pacificAtlantic_bfs(heights));

		
	}
}
