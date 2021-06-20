package com.samples.dynamicprog;


public class Maze2 {

	int[][] maze;
	int[][] seen;
	int[] destination;
	
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int distance = 0;
        int r = start[0],  c = start[1];
        boolean rDir = true, cDir = false;
        int dir = 1;
        while(r != destination[0] && c != destination[1])
        {
        	
        }
        
        
        return -1;
    }
	
	private int helper(int r, int c, boolean rDir, boolean cDir, int dir)
	{
		if(r < 0 || r >= maze.length || c < 0 || c >= maze[0].length || maze[r][c] == 1 || seen[r][c] == 1)
		{
			
		}
		if(r == destination[0] && c == destination[1])
		{
			return 1;
		}
		
		int ans ;
		if(rDir)
		{
			r = r + dir;
			ans = helper(r, c, rDir, cDir, dir);
		}
		else if(cDir)
		{
			c= c + dir;
		}
		
		
		return 1 ;
		
		
	}
}
