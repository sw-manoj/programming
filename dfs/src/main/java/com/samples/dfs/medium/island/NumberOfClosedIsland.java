package com.samples.dfs.medium.island;

//https://leetcode.com/problems/number-of-closed-islands/submissions/
public class NumberOfClosedIsland {

	 public int closedIsland(int[][] grid) {
	        int num = 0;
			if (grid == null || grid.length == 0) return 0;

			for(int i = 1 ; i < grid.length-1 ; i++)
			{
				for(int j = 1; j < grid[0].length-1 ; j++)
				{
					if(grid[i][j] == 0 && dfs(grid, i, j))
					{
						num++;
					}
				}
			}
	        return num;
	 }
	 
	 public boolean dfs(int[][]grid, int r, int c)
	 {
		 	//-1 visisted
		 	// 1 = water
		 	// = = land
			if(grid[r][c] == 1 || grid[r][c] == -1) return true;

//			once the above condition crosssed we know the r,c has 0 in grid. so if 0 is in boundary we can return false
			if((r <= 0 || c <= 0 || r >= grid.length-1 || c>= grid[0].length-1) ) return false;
			
			
			//mark visisted.
			grid[r][c] = -1;
			
			boolean left = dfs(grid, r, c-1);
			boolean right = dfs(grid, r, c+1);
			boolean up = dfs(grid, r-1, c);
			boolean down = dfs(grid, r+1, c);
			
			return left && right && up && down;

			
	 }
	 
	 public static void main(String[] args) {
		NumberOfClosedIsland obj = new NumberOfClosedIsland();
		System.out.println(obj.closedIsland(new int[][] {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}}));
		
		
		System.out.println(obj.closedIsland(new int [][] {{1,1,1,1,1,1,1},
		                                                  {1,0,0,0,0,0,1},
		                                                  {1,0,1,1,1,0,1},
		                                                  {1,0,1,0,1,0,1},
		                                                  {1,0,1,1,1,0,1},
		                                                  {1,0,0,0,0,0,1},
		                                                  {1,1,1,1,1,1,1}}));

	}
	 
}
