package com.samples.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StairCaseProb {

	static int numWaysBottomUp(int n ,List<Integer> set)
	{
		// this basically saves num of ways to that step from 1 to n, e,g to ge tto 4th
		// step 4-1 =3 which is no of ways to get 3 a+1.
		//similarly 4-3=1 which is no of ways to get to 1 and +1 (direct 3 steps)
		if (n ==0 ) return 1;
		int[] num = new int[n+1];
		num[0] = 1;
		for(int i = 1;i<= n ; i++)
		{
			int total = 0;
			for(int j :set)
			{
				if(i-j>=0)
				{
					total += num[i-j];
				}
			}
			num[i] = total;
		}
		System.out.println(num[2]);
		return num[n];
	
	}
	
	static int numWaysTopBottom(int n ,List<Integer> set,int[] num)
	{
		if(num[n] != -1)
		{
			return num[n];
		}
		if (n ==0 ) return 1;
		
		int total = 0;
		for(int i =0 ; i < set.size() ;i ++)
		{
			if(n-set.get(i) >= 0)
			{
				total += numWaysTopBottom(n-set.get(i), set, num);
			}
		}
		num[n] = total;
		
		return num[n];
	
	}
	
	
	public static void main(String[] args) {
		
		int n = 7;
		List<Integer> set =  new ArrayList<Integer>(Arrays.asList(1,3,5));
		int num = numWaysBottomUp(n, set);
		
		System.out.println(num);

		int[] numArr = new int[n+1];
		for(int i = 0  ;i < numArr.length ;i ++)
		{
			numArr[i] = -1;
		}
		int num2 = numWaysTopBottom(n, set, numArr);
		
		System.out.println(num2);
		
	}
}
