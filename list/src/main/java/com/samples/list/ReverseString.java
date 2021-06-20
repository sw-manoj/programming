package com.samples.list;

public class ReverseString {

	public static void main(String[] args) {
		char[] s = {'H','a','n','n','a','h'};
		ReverseString rev = new ReverseString();
		rev.reverseString(s);
		rev.printArr(s);
	}
	
	void printArr(char[] s)
	{
		for(int i = 0 ; i < s.length; i++)
		{
			System.out.print(s[i] +" ");
		}
		System.out.println();
	}
public void reverseString(char[] s) {
        
	int startPos=0;int endPos = s.length-1;
	
	while(startPos < endPos)
	{
		swap(s, startPos, endPos);
		startPos++;
		endPos--;
	}
	
    }

private void swap(char[] s , int startPos , int endPos)
{
	char tmp = s[startPos];
	s[startPos] = s[endPos];
	s[endPos] = tmp;
}
}
