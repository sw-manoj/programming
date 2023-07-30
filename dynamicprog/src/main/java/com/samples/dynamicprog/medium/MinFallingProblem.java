package com.samples.dynamicprog.medium;

public class MinFallingProblem {

	public int minFallingPathSum(int[][] matrix) {

		int[][] cache = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length ; i++) {
			for(int j = 0; j < matrix[i].length ; j++){
				cache[i][j] = -1;
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < matrix.length ; i++) {
			int tempAns = minFallingPathSumHelper(matrix, 0, i, cache );
			ans = Math.min(tempAns, ans);
		}
		return ans;
	}

	public int minFallingPathSumHelper(int[][] matrix, int row, int col, int[][] cache) {
		if(row == matrix.length-1) {
			return matrix[row][col];
		}
		if(col < 0 || col >= matrix[row].length) {
			return 100001;
		}
		if(cache[row][col] != -1) {
			return cache[row][col];
		}
		int right = minFallingPathSumHelper(matrix, row+1, col + 1, cache);
		int left = minFallingPathSumHelper(matrix, row+1, col -1, cache);
		int down = minFallingPathSumHelper(matrix, row+1, col, cache);

		cache[row][col] = matrix[row][col] + Math.min(right, Math.min(left, down));
		return cache[row][col];
	}
}
