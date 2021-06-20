package com.samples.dfs.medium;

import java.util.Stack;

public class MaxAreaOfIsland {

//	https://leetcode.com/problems/max-area-of-island/
	
	int[][] srcGrid;
	private int calArea(int r, int c)
	{
		if(r < 0 || r > srcGrid.length-1 || c < 0 || c > srcGrid[0].length-1 || this.srcGrid[r][c] == 0)
		{
			return 0;
		}
		
		this.srcGrid[r][c] = 0;
		
		return 1 + calArea(r+1,c) + calArea(r,c+1) + calArea(r-1,c) + calArea(r,c-1);
	}
	public int maxAreaOfIsland(int[][] grid) {
		int r = grid.length;
		int maxArea = 0;
		if( r == 0 )
		{
			return maxArea;
		}
		this.srcGrid = grid;
		
		int c = grid[0].length;
		
		for(int i = 0 ; i < r; i++)
		{
			for(int j = 0 ; j < c;j++)
			{
				maxArea = Math.max(maxArea, this.calArea(i, j));
			}
		}
		
		return maxArea;
    }
	
	public static void main(String[] args) {
		MaxAreaOfIsland obj = new MaxAreaOfIsland();
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0}
						,{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0}
						,{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
		                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		
		
		System.out.println(obj.maxAreaOfIsland(grid));
	}
	
	
	public int maxAreaOfIsland_iter(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        int ans = 0;
        for (int r0 = 0; r0 < grid.length; r0++) {
            for (int c0 = 0; c0 < grid[0].length; c0++) {
                if (grid[r0][c0] == 1 && !seen[r0][c0]) {
                    int shape = 0;
                    Stack<int[]> stack = new Stack();
                    stack.push(new int[]{r0, c0});
                    seen[r0][c0] = true;
                    while (!stack.empty()) {
                        int[] node = stack.pop();
                        int r = node[0], c = node[1];
                        shape++;
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (0 <= nr && nr < grid.length &&
                                    0 <= nc && nc < grid[0].length &&
                                    grid[nr][nc] == 1 && !seen[nr][nc]) {
                                stack.push(new int[]{nr, nc});
                                seen[nr][nc] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, shape);
                }
            }
        }
        return ans;
    }
}
