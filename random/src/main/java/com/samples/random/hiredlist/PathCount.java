package com.samples.random.hiredlist;

import java.util.ArrayList;
import java.util.List;

public class PathCount {
	
	public static void main(String[] args) {
		List<String> grid = new ArrayList<String>();
		grid.add("0000");
		grid.add("1010");
		grid.add("0000");
		grid.add("0010");
		System.out.println(count_the_paths(grid));
	}

	 public static int count_the_paths(List<String> grid) {
		 
		 if(grid.size() == 0)
		 {
			 return 0;
		 }
		 int m = grid.get(0).length();
		 int n = grid.size();
	       char[][] matrix = new char[n][m];
	       
	       for(int i  = 0 ; i < grid.size() ;i++)
	       {
	    	   matrix[i] = grid.get(i).toCharArray();
	       }
	       int[][] mem = new int[n][m];
	       return helper(matrix, n-1, 0, m, mem);
	    }
	 
	 private static int helper(char[][] matrix, int row, int col, int mLimit , int mem[][] )
	 {
		 if(row == 0 && col == mLimit-1)
		 {
			 return 1;
		 }
		 
		 if(mem[row][col] > 0) return mem[row][col];
		 
		 
		 int up = row -1;
		 int right = col + 1;
		 int upCount = 0;
		 int downCount = 0;
				 
		 if(up >= 0 && matrix[up][col] != '1') upCount = helper(matrix, up, col, mLimit, mem);
		 
		 if(right < mLimit && matrix[row][right] != '1') downCount = helper(matrix, row, right, mLimit, mem);
		 
		 mem[row][col] = upCount + downCount;
		 return mem[row][col];
	 }
}
