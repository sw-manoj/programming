package com.samples.list;

//https://leetcode.com/problems/backspace-string-compare/submissions/
public class BackSpaceCompare {

	
	public boolean backspaceCompare(String s, String t) {
        
		return backSpaceremoved(s).equals(backSpaceremoved(t));
    }
	
	public String backSpaceremoved(String s)
	{
		int slen = s.length()-1;
		int backCharDist = 0;
		String sres = "";
		while(slen >= 0)
		{
			if(s.charAt(slen) != '#' && backCharDist > 0)
			{
				backCharDist--;
			}
			else if(s.charAt(slen) == '#')
			{
				backCharDist++;
			}
			else
			{
				sres = String.valueOf(s.charAt(slen)) + sres;
//				System.out.println(String.valueOf(s.indexOf(slen)));
			}
			slen--;
		}
//		System.out.println(sres);
		return sres;
	}
	
public boolean backspaceCompare1(String s, String t) {
        
		int i = s.length()-1;
		int j = t.length()-1;
		int si=0, tj = 0;
		
		while(i >=0 || j >=0)
		{
			while(i >= 0)
			{
				if(s.charAt(i) == '#') 
				{
					si++; 
				}
				else if(si > 0)
				{
					si--;
				}
				else
					break;
				
				i--;
			}
			
			while(j >= 0)
			{
				if(t.charAt(j) == '#') 
				{
					tj++; 
				}
				else if(tj > 0)
				{
					tj--;
				}
				else
					break;
				
				j--;
			}
			
			
			if(i>= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
			
			if(i >= 0 != j >= 0 ) return false;
			
			i--;
			j--;
		}
		return true;
    }
	
	public static void main(String[] args) {
		BackSpaceCompare obj = new BackSpaceCompare();
//		System.out.println(obj.backspaceCompare("ab##", "c#d#"));
//		System.out.println(obj.backspaceCompare("ab#c", "ad#c"));
//
//		System.out.println(obj.backspaceCompare("a##c", "#a#c"));
//		System.out.println(obj.backspaceCompare("ab#c#", "ad#c"));
//
//		System.out.println(obj.backspaceCompare("bxj##tw", "bxo#j##tw"));
//		"bxj##tw"
//		"bxo#j##tw"
		
		System.out.println(obj.backspaceCompare1("ab##", "c#d#"));
		System.out.println(obj.backspaceCompare1("ab#c", "ad#c"));

		System.out.println(obj.backspaceCompare1("a##c", "#a#c"));
		System.out.println(obj.backspaceCompare1("ab#c#", "ad#c"));

		System.out.println(obj.backspaceCompare1("bxj##tw", "bxo#j##tw"));
		System.out.println(obj.backspaceCompare1("bxj##tw", "bxj###tw"));

	}
}
