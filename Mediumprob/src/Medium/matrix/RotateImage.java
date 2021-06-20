package Medium.matrix;

public class RotateImage {

//	https://leetcode.com/problems/rotate-image/submissions/
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		RotateImage tm = new RotateImage();
		tm.printMatrix(matrix);
//		tm.squareTransposeMatrix(matrix);
//		tm.reverse(matrix);
		tm.rotate(matrix);
		System.out.println();
		tm.printMatrix(matrix);
		
	}
	
	void rotate(int[][] matrix)
	{
		int n = matrix.length;
		
		for(int i = 0 ; i < (n+1)/2 ; i++)
		{
			for(int j = 0 ; j < n/2; j++)
			{
				int temp = matrix[n-1-i][n-1-j];
				System.out.println("i==" + i + "==j=="+ j + "==main==" + matrix[i][j] + "==rev==" + matrix[n-1-i][n-1-j]);

				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = temp;
			}
		}
	}
	void printMatrix(int[][] matrix)
	{
		int r = matrix.length;
		int n = matrix[0].length;

		for (int i  = 0 ; i < r ; i ++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void reverse(int[][] matrix)
	{
		int r = matrix.length;
		int n = matrix[0].length;
		for(int i=0; i < r; i++)
		{
			for(int j = 0 ; j < n/2; j++)
			{
				int temp = matrix[i][n-1-j];
				matrix[i][n-1-j] = matrix[i][j]; 
				matrix[i][j] = temp;
			}
		}
	}
	
	public void squareTransposeMatrix(int[][] matrix)
	{
		int r = matrix.length;
		int n = matrix[0].length;
		
		int[][] res = new int[n][r];
		
		for (int i  = 0 ; i < r ; i ++)
		{
			for(int j = i ; j < n ; j++) 
			//transpose  in the same matrix, so starting from 0 doesnt make any changes hence start with i. 
			{
//				System.out.println("i==" + i + "==j=="+ j + "==main==" + matrix[i][j] + "==rev==" + matrix[j][i]);
				int temp = matrix[i][j];
				
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}


