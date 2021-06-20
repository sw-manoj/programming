package com.samples.random;

public class GainTest {

	
	public static void main(String[] args) {
		GainTest test = new GainTest();
		
		System.out.println(test.spiral(4, "UURRD"));
	}
	public int spiral(int input1 , String input2) {
	// Write code here...
	char[] charArr = input2.toCharArray();
	int n = input1;
	int midRow = (n) /2;
	int midCol = (n-1) /2;
	System.out.println(midRow + "===" + midCol);
	if(!findDest(charArr, midRow, midCol, n))
	{
		return -1;
	}
	System.out.println(destCol + "==" + destRow);
	int counter = traverseMatrix(n, midRow, midCol);
	System.out.println(counter);
return counter;


	//throw new UnsupportedOperationException("spiral_matrix(int input1,String input2)");
}
	
	private int traverseMatrix(int n, int midRow, int midCol)
	{
		int counter = 1;
		
		int verSteps = 1;
		int horSteps = 1;
		char[] dir = {'U','R','D','L'};
		int dirIndex = 0;
		//int i =0, j = 0 ;
		System.out.println(midRow + "====" + midCol);
		while(true)
		{
			if(dirIndex >= dir.length)
			{
				dirIndex = 0;
			}
			if(isDestReached(midRow, midCol))
			{
				return counter;
			}
			char c = dir[dirIndex];
			if(c == 'U')
			{
				for(int k = 0 ;k < verSteps; k++)
				{
					counter++;
					midRow--;
					if(isDestReached(midRow, midCol))
					{
						return counter;
					}
				}
				verSteps++;
				dirIndex++;
			}
			else if(c =='D')
			{
				for(int k = 0 ;k < verSteps; k++)
				{
					counter++;
					midRow++;
					if(isDestReached(midRow, midCol))
					{
						return counter;
					}
				}
				verSteps++;
				dirIndex++;
			}
			else if(c == 'L')
			{
				for(int k = 0 ;k < horSteps; k++)
				{
					counter++;
					midCol--;
					if(isDestReached(midRow, midCol))
					{
						return counter;
					}
				}
				horSteps++;
				dirIndex++;
			}
			else if(c =='R')
			{
				for(int k = 0 ;k < horSteps; k++)
				{
					counter++;
					midCol++;
					if(isDestReached(midRow, midCol))
					{
						return counter;
					}
				}
				horSteps++;
				dirIndex++;
			}
		}
	}
	
	
	private boolean isDestReached(int midRow , int midCol)
	{
		if(destRow == midRow && destCol == midCol)
		{
			return true;
		}
		return false;
	}
	int destRow, destCol;
	private boolean findDest(char[] charArr, int midRow,int midCol, int n)
	{
		for(char c : charArr)
		{
			if(c == 'U')
			{
				midRow--;
			}
			else if(c =='D')
			{
				midRow++;
			}
			else if(c == 'L')
			{
				midCol--;
			}
			else if(c =='R')
			{
				midCol++;
			}

			if(midRow < 0 || midRow >= n || midCol < 0 || midCol >= n)
			{
				return false;
			}
			
			
		}
		
		destRow = midRow;
		destCol = midCol;
		return true;
	}
}
