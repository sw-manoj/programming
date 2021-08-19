package com.samples.dfs.medium;

public class NumberOfIslands {

//	https://leetcode.com/problems/number-of-islands/solution/
	public static void main(String[] args) {
		NumberOfIslands numIsland = new NumberOfIslands();
		String[][] grid = {
						{"1","1","1","1","0"},
		                {"1","1","0","1","0"},
		                {"1","1","0","0","0"},
		                {"0","0","0","0","0"}
				};
		
		char[][] allchar = tocharArray(grid);
		System.out.println(numIsland.numIslands_2ndtry(allchar));
		
		String[][] grid1 = {
				{"1","1","0","0","0"},
				{"1","1","0","0","0"},
				{"0","0","1","0","0"},
				{"0","0","0","1","1"}
		};
		
		System.out.println(numIsland.numIslands_2ndtry(tocharArray(grid1)));
		System.out.println(numIsland.numIslands_2ndtry(tocharArray(new String[][] {{"1","1","1"},{"0","1","0"},{"1","1","1"}} )));
		
	}
	
	
	static char[][] tocharArray(String[][] grid)
	{
		char[][] allchar = new char[grid.length][grid[0].length]; // Your code till here is proper

		// Copying the contents of the 2d array to a new 1d array
		int counter = 0; // Counter as the index of your allChar array
		for (int i = 0; i < grid.length; i++) { 
		    for (int j = 0; j < grid[i].length; j++) { // nested for loop - typical 2d array format
		        allchar[i][j] = grid[i][j].charAt(0); // copying it to the new array
		    }
		}	
		return allchar;
		
	}
	
	
	private void markSeen(int r, int c)
	{
		if(r < 0 || r >= srcGrid.length  || c < 0 || c >= srcGrid[0].length || seen[r][c])
		{
			return;
		}
		if(srcGrid[r][c] == '1')
		{
			seen[r][c] = true;
			markSeen(r-1, c);
			markSeen(r, c-1);
			markSeen(r+1, c);
			markSeen(r, c+1);
		}
	}
	
	boolean[][] seen;
	char[][] srcGrid;
	public int numIslands1(char[][] grid) {
		this.srcGrid = grid;
		int max = 0;
		
		int r = grid.length;
        if( r <= 0) return max;
        int c = grid[0].length;
		seen = new boolean[r][c];

        for(int i = 0 ; i < r ; i++)
        {
        	for(int j = 0; j < c ;j++)
        	{
        		if(!seen[i][j] && grid[i][j] == '1')
        		{
        			max++;
        			markSeen(i, j);
        		}
        	}
        }
      
		
		return max;
	}
	
	
	private void markseen1(int r , int c, char[][] grid, int[][] seen)
	{
		if(r < 0 || r > grid.length-1 || c < 0 || c > grid[0].length-1 || seen[r][c] == 1 || grid[r][c] == '0')
		{
			return;
		}

		seen[r][c] = 1;
		
		markseen1(r-1,c, grid, seen);
		markseen1(r+1,c, grid, seen);
		markseen1(r,c-1, grid, seen);
		markseen1(r,c+1, grid, seen);
		
	}
	
	public int numIslands_2ndtry(char[][] grid) {
		int max = 0;
		
		int[][] seen = new int[grid.length][grid[0].length];
		
		for(int i = 0 ; i < grid.length;i++)
		{
			for(int j = 0 ; j  < grid[0].length ; j++)
			{
				if(seen[i][j] == 0 && grid[i][j] == '1')
				{
					markseen1(i, j, grid, seen);
					max++;
				}
			}
		}
		
		return max;
		
	}

}
