package com.samples.dynamicprog;

public class HamiltonianPath {

	//not working
	static boolean checkSubSet(int[][]  adjMatrix )
	{
		int ex = (int) Math.pow(2,adjMatrix.length);
		
		boolean[][] dp = new boolean[adjMatrix.length][ex];
		
		for(int init = 0 ; init < adjMatrix.length ; init++)
		{
			dp[init][(1 << init)] = true;
		}
		printdp(dp);
		for(int i =0 ;i < ex; i++)
		{
			if(i == 31) printdp(dp);
			for(int j = 0 ; j < adjMatrix.length ; j++)
			{
				if(((i & (1 << j)) > 0))
				{
					for(int k = 0 ; k < adjMatrix.length ; k++)
					{
						if(i ==31)
						{
							System.out.println((i^(1 << j)) + "== mask==" + j + "==vertex==" + k + "===" + dp[k][i^(1 << j)]);
						}
						if(j != k && ((i & (1 << k)) > 0) && (adjMatrix[k][j] > 0) && dp[k][i^(1 << j)])
						{
							System.out.println(i + "== mask==" + j + "==vertex==" + k);
							dp[j][i] = true;
							break;
						}
					}
				}
			}
//			System.out.println("printind dp for mask " + i);
//			printdp(dp);
		}
		
		for(int i = 0 ; i < adjMatrix.length ;i ++)
		{
			System.out.println(i);
			if(dp[i][(1 << adjMatrix.length) -1] )
{
	return true;
}
		}
		return false;
	}
	
	
	static void printdp(boolean[][] dp)
	{
		for(int i = 0 ; i < dp.length ; i++)
		{
			for(int j = 0 ; j < dp[i].length ; j++)
			{
				System.out.print((dp[i][j] ? "1" : "0") + " ");
			}
			System.out.println();
		}
		System.out.println("===============================");
	}
	static boolean isBitSet(int i , int mask)
	{
		if(((mask) & (1 << (i-1)) ) > 0 )
		{
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int graph1[][]={{0, 1, 0, 1, 0}, 
	            		{1, 0, 1, 1, 1}, 
	            		{0, 1, 0, 0, 1}, 
	            		{1, 1, 0, 0, 1}, 
	            		{0, 1, 1, 1, 0}, 
	        }; 
//		System.out.println(checkSubSet(graph1));
		
		  /* Let us create the following graph  
	    (0)--(1)--(2)  
	    | / \ |  
	    | / \ |  
	    | / \ |  
	    (3) (4) */
		
        int graph2[][] ={{0, 1, 0, 0, 0}, 
                		 {1, 0, 1, 0, 0}, 
                		 {0, 1, 0, 0, 1}, 
                		 {0, 0, 0, 0, 0}, 
                		 {0, 0, 1, 0, 0}, 
            }; 

        System.out.println("==="+checkSubSet(graph2));
	}
}
