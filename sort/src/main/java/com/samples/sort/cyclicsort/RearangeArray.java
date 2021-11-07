package com.samples.sort.cyclicsort;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class RearangeArray {

	public static void fixArray(int ar[])
	{
		int n = ar.length;
		int i = 0;
		
		while(i < n)
		{
			int correct = ar[i];
			if(ar[i] != -1 && ar[i] != ar[correct])
			{
				CyclicSort.swap(ar, i, correct);
			}
			else
			{
				i++;
			}
		}
		
		for(int a : ar)
		{
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		fixArray(new int[] { -1, -1, 6, 1, 9,
                3, 2, -1, 4, -1 });
	}
}
