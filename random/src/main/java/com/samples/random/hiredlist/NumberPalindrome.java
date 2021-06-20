package com.samples.random.hiredlist;

public class NumberPalindrome {

	public static boolean is_numeric_palindrome(long number) {
		
		if(number <= 0)
		{
			return false;
		}
	    String val = String.valueOf(number);
	    int len  =val.length();
	    int mid =-1;
	    mid = len/2;
	    
	    int i = 1 ;
	    long revNum = 0;
	    while(i <= mid)
	    {
	    	if(number > 0)
	    	{
	    		revNum *= 10;
	    		revNum += (number % 10L) ;
	    		number = number/ 10;
	    	}
	    	else
	    	{
	    		break;
	    	}
	    	i++;
	    }
	    
	    if(len%2 != 0)
	    {
	    	number = number/10;
	    }
	    return revNum == number;
	  }
	
	public static void main(String[] args) {
		System.out.println(is_numeric_palindrome(234432));
		System.out.println(is_numeric_palindrome(23432));
		System.out.println(is_numeric_palindrome(22));
		System.out.println(is_numeric_palindrome(223));
		System.out.println(is_numeric_palindrome(232));
		System.out.println(is_numeric_palindrome(2));
		
		String bitmask = Integer.toBinaryString(0);
		System.out.println(bitmask);
	}
}
