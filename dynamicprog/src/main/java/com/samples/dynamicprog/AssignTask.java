package com.samples.dynamicprog;

public class AssignTask {
	
	public static void main(String[] args) {
		int N = 4;
		
//		  int[][] costMatrix = { {9, 2, 7, 8}, {6, 4, 3, 7}, {5, 8, 1, 8}, {7, 6, 9, 4}
//		  }
//		 ; 
		 
		 
		 int[][] costMatrix = 
				{ 
					{82, 83, 69, 92}, 
					{77, 37, 49, 92}, 
					{11, 69, 5, 86}, 
					{ 8, 9, 98, 23} 
				}; 
				

		/*  int[][] costMatrix =
				{ 
					{2500, 4000, 3500}, 
					{4000, 6000, 3500}, 
					{2000, 4000, 2500} 
				};*/

//		 int[][] costMatrix = 
//				{ 
//					{90, 75, 75, 80}, 
//					{30, 85, 55, 65}, 
//					{125, 95, 90, 105}, 
//					{45, 110, 95, 115} 
//				};


		System.out.println((int) Math.pow(2, costMatrix.length)  );
		int[] dp = new int[(int) Math.pow(2, costMatrix.length)  ];
		for(int i = 0 ; i < dp.length ; i++)
		{
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		int mimCost = assignTaskUsingBitmaskDp(dp, costMatrix);
		System.out.println(mimCost);
	}
	
	static int countBitSetInMask(int mask)
	{
		int count = 0;
		while(mask > 0)
		{
			//doing AND operation with previous num reduces the bit's set in binary by 1.
			mask = mask & mask-1;
			count++;
		}
		return count;
	}
	static boolean isBitSet(int i , int mask)
	{
		if(((mask) & (1 << (i)) ) > 0 )
		{
			return true;
		}
		return false;
	}
	
	static int assignTaskUsingBitmaskDp(int[]  dp , int[][] cost)
	{
		for(int i = 0 ; i < dp.length-1 ; i ++)
		{
			//each index in dp represents a subset (combination) of task assigned to that particular person with its total cost stored as value of that index for that subset
//			For that subset we set another bit in other 0's place one by one (which internally forms another binary num (subset)) and compare cost of newly formed subset and value already existing that index (combination) and set the minimum cost in that inex
			
//			hence once we reach last subset where all bits are 1. we would have tried all combiantions of assigning the task and set min cost in its value
			int mask = i;
			int task = countBitSetInMask(mask);
			for(int j =0;j< cost.length;j++)
			{
				if(!isBitSet(j, i))
				{
					int oldVal = dp[mask|(1<<j)];
					dp[mask|(1<<j)] = Math.min(dp[mask|(1<<j)], dp[mask] + cost[task][j]);
//					System.out.println(dp[mask|(1<<j)] + " cost for mask " + mask + "==indesx==" +(mask|(1<<j)) +  "==TASK ==" + task + "==BY INCLUDING per==" + j  +"==oldvalue ="+(oldVal)+"==cost==" + (cost[task][j]));
				}
			}
			
//			System.out.println("====================");
		}
		
		return dp[dp.length-1];
	}

}
