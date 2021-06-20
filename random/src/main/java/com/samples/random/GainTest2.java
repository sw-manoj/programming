package com.samples.random;

public class GainTest2 {

	public static void main(String[] args) {
		GainTest2 test = new GainTest2();
		System.out.println(test.numberChain(89));
	}
	
	private int numberChain(int n)
	{
		int count = 0;
		for(int i = 1 ; i <= n ; i++)
		{
			count += squareAdd(i);
		}
		return count;
	}
	
	//Map<Integer,Integer> cache = new HashMap<Integer,Integer>();
	private int squareAdd(int n)
	{
		if(n == 89)
		{
			return 1;
		}
		while(n != 1 )
		{
			int sum = 0;
			while(n > 0)
			{
				int  rem = n % 10;
				n = n / 10;
				sum += (rem* rem);
			}
			if(sum == 89)
			{
				return 1;
			}
			n = sum;
			//System.out.println(n);
		}
		return 0;
	}
}
