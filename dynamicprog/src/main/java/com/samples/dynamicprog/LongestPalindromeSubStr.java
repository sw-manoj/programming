package com.samples.dynamicprog;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestPalindromeSubStr {

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i); // this get the length of palindrome with i as center.(odd number
													// str)
			int len2 = expandAroundCenter(s, i, i + 1); // this get the length of palindrome with i and i+ 1 as
														// center.(even number str)
			int len = Math.max(len1, len2);
			if (len > end - start) // this condn checks if current max sub string Length with i as center and
									// Length of prev palindrome str (end - start)
			{
				start = i - (len - 1) / 2; // in case of new largere sub str palindrone we need to calculate the start
											// and end of the substr to use it later.
				end = i + len / 2;
			}
		}
		
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

//	public static void main(String[] args) {
//		LongestPalindromeSubStr subStr = new LongestPalindromeSubStr();
//		System.out.println(subStr.longestPalindrome("abacdfgdcaba"));
//		System.out.println("1111111111111111111111111111111111111111111111111111111110000101".length());
//		
//		Scanner s = new Scanner(System.in);
//		System.out.println(s.nextLine());
//		System.out.println(s.next());
//		char c = 0 ;
//		System.out.println(new String("asas".charAt(1)));
////		if(c !=  && c+1 = curChar)
////        {
////            c = curChar;
////        }
//	}
	
	public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */
        
        // Write your code here

        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        s.nextLine();
        List<String> strs = new ArrayList<String>();
//        for(int i = 0 ; i < n; i++)
//        {
//            strs.add(s.nextLine());
//        }
//        System.out.println(strs);
//        int queNum = s.nextInt();
        strs.add("aaaaa");
        strs.add("bbbbb");
        strs.add("ccccc");
        strs.add("ddddd");
        strs.add("eeeee");
//        for(int i = 0 ; i < queNum ; i++)
//        {
//            int l = s.nextInt();
//            int r = s.nextInt();
//            int k = s.nextInt();
//            System.out.println(l + "===" + r);
//            System.out.println(grpFunc(strs,l,r,k));
//        }
        System.out.println(grpFunc(strs,3,5,15));
    }

    public static String grpFunc(List<String> strs, int l , int r, int k)
    {
        if(strs.size() < l || strs.size() < r)
        {
            return "";
        }
        char c = 0;
        int totalLen = 0;
        for(int i = l ; i <= r ; i++)
        {
            String curStr = strs.get(i-1);
            char curChar = curStr.charAt(0);
            if(c == 0 || c+1 == curChar)
            {
                
                totalLen += curStr.length();
            }
            c = curChar;
            if(totalLen >= k)
            {
              return Character.toString(curStr.charAt(curStr.length() - (totalLen - k) -1));  
            }
        }
        return "";
    }
}
