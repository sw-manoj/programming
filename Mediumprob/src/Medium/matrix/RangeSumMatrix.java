package Medium.matrix;

public class RangeSumMatrix {

//	https://leetcode.com/problems/range-sum-query-2d-immutable/submissions/
	
	
	//half optimised 
	
	//row wise cache sum of row elements upto end.
	
//	int[][] dp;
//	public RangeSumMatrix(int[][] matrix) {
//        dp = new int[matrix.length][matrix[0].length];
//        
//        for(int i = 0 ; i < matrix.length; i++)
//        {
//        	for(int j = 0 ; j < matrix[0].length; j++)
//            {
//            	dp[i][j] = matrix[i][j] + (j == 0 ? 0 : dp[i][j-1]);
//            }
//        }
//    }
//    
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int max = 0;
//    	for(int i = row1; i <= row2 ;i++)
//    	{
//    		max += dp[i][col2] - (col1 == 0 ? 0 : dp[i][col1-1]);
//    	}
//    	
//    	return max;
//    }
    
	
	//rectangle wise cache, look at link sol for explanation.
    
    int[][] dp;
	public RangeSumMatrix(int[][] matrix) {
        dp = new int[matrix.length +1][matrix[0].length +1];
        for(int i = 0 ; i < matrix.length; i++)
        {
        	for(int j = 0 ; j < matrix[0].length; j++)
            {
            	dp[i+1][j+1] = matrix[i][j] + dp[i][j+1] + dp[i+1][j] - dp[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int max = 0;
    	max = dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1];
    	
    	return max;
    }
    
    public void print()
    {
    	for(int i = 0 ; i < dp.length; i++)
        {
        	for(int j = 0 ; j < dp[0].length; j++)
            {
            	System.out.print(dp[i][j] + " ");
            }
        	System.out.println();
        }
    }
    
    public static void main(String[] args) {
		int[][] matrix = {  {3, 0, 1, 4, 2}, 
							{5, 6, 3, 2, 1}, 
							{1, 2, 0, 1, 5}, 
							{4, 1, 0, 1, 7}, 
							{1, 0, 3, 0, 5}};
		
		RangeSumMatrix obj = new RangeSumMatrix(matrix);
		obj.print();
		System.out.println(obj.sumRegion(2, 1, 4, 3));
		System.out.println(obj.sumRegion(1, 1, 2, 2));

		System.out.println(obj.sumRegion(1, 2, 2, 4));

	}
}
