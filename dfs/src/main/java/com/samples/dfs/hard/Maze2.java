package com.samples.dfs.hard;

import java.util.concurrent.atomic.AtomicReference;

public class Maze2 {
	

	int[][] maze;
	int[][] seen;
	int[] destination;
	
	public static void main(String[] args) {
		Maze2 obj = new Maze2();
		int[][] m = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		
		
		System.out.println(obj.shortestDistance(m, new int[] {0,4}, new int[] {4,4}));
	}
	
	public int shortestDistance(int[][] m, int[] start, int[] destination) {
		this.maze = m;
		this.destination = destination;
		this.seen = new int[maze.length][maze[0].length];
        int distance = Integer.MAX_VALUE;
        int r = start[0],  c = start[1];
        for(int[] d : dir)
        {
        	int rdir = d[0];
        	int cdir = d[1];
        	distance = Math.min(distance, helper(r+rdir, c+cdir, rdir, cdir));
        }
        
        
        return distance;
    }
	
	int[][] dir = {{-1,0}, {1,0},{0,-1},{0,1}};
	private int helper(int r, int c, int rDir, int cDir)
	{
//		if(r < 0 || r >= maze.length || c < 0 || c >= maze[0].length )
//		{
//			return Integer.MAX_VALUE;
//		}
		if(destination[0] == r && destination[0] == c)
		{
			return 1;
		}
		
		int min = Integer.MAX_VALUE;
		if(r < 0 || r >= maze.length || c < 0 || c >= maze[0].length  || maze[r][c] == 1  )
		{
			
			r -= rDir;
			c -= cDir;
			System.out.println(r + "== " + c) ;
			for(int[] d : dir)
			{
				if(d[0] == rDir && d[1]==cDir)
				{
					continue;
				}
				if( seen[r + d[0]][ c + d[1]] > 0)
				{
					return seen[r + d[0]][ c + d[1]] ;
				}
				min = Math.min(min, helper(r + d[0], c + d[1], d[0], d[1]));
			}
			
		}
		else
		{
			if( seen[r][c] > 0)
			{
				return seen[r][c] ;
			}
			min = helper(r+ rDir, c +cDir, rDir, cDir);
		}
			
		
		seen[r][c] = min+1;
		
		return seen[r][c] ;
		
		
	}
}
