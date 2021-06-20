package com.samples.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;


public class Paypal {

	class Node
	{
		int len; int rec;
		Node(int c, int r)
		{
			len = c;
			 rec = r;
		}
		public Node  inc()
		{
			rec++;
			
			return this;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "count==" + len + "==occurrence==" + rec;
		}
	}
	private void consecutiveSubStr(String str) //1st ques
	{
		Map<String, Node> subStrCountMap = new HashMap<String, Node>();
		String subStr = "";
		int subStrCount = 0;
		int lastChar = -1;
		for(int i = 0  ; i < str.length() ; i ++)
		{
			char ch = str.charAt(i);
			if(lastChar == -1 || lastChar + 1 == ch)
			{
				subStr += ch;
				subStrCount++;
			}
			else
			{
				if(subStr.length() > 1 )
				{
					subStrCountMap.put(subStr, subStrCountMap.getOrDefault(subStr, new Node(subStrCount, 0)).inc());
				}
				subStr = String.valueOf(ch);
				subStrCount = 1;
			}
			lastChar = ch;
		}
		if(subStr.length() > 1 )
		{
			subStrCountMap.put(subStr, subStrCountMap.getOrDefault(subStr, new Node(subStrCount, 0)).inc());
		}
		
		System.out.println(subStrCountMap);
	}
	
	private boolean isParenthesisBalanced(String str) //2nd ques
	{
		//closing to opening bracket mapping
		Map<Character,Character> parenthesisMap = new HashMap<Character, Character>();
		parenthesisMap.put(')', '(');
		parenthesisMap.put(']', '[');
		parenthesisMap.put('}', '{');
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			char ch = str.charAt(i);
			if(parenthesisMap.containsKey(ch))
			{
				//closing bracket
				char openingBrac = stack.pop();
				if(openingBrac != parenthesisMap.get(ch))
				{
					return false;
				}
			}
			else
			{
				stack.push(ch);
			}
		}
		return stack.isEmpty();
	}
	
	void characterCount(String str) //3rd ques
	{
		int[] charArr = new int[25];
		for(char ch : str.toLowerCase().toCharArray())
		{
			charArr[ch - 'a']++;
		}
		
		for(int i = charArr.length -1; i >=0 ; i-- )
		{
			if(charArr[i] > 0)
			{
			System.out.print( (char)(i + 'a') + "==" +charArr[i] + " ");
			}
		}
		System.out.println();
	}
	
	char firstNonRepeatableChar(String str) //5th ques
	{
		TreeMap<Character, Integer> characterCountMap = new TreeMap<Character, Integer>(Comparator.reverseOrder());
		
		for(char ch : str.toCharArray())
		{
			characterCountMap.put(ch, characterCountMap.getOrDefault(ch, 0) + 1);
		}
		
		if(characterCountMap.firstEntry().getValue() == 1)
		{
			return characterCountMap.firstKey();
		}
		return ' ';
	}
	
	
	List<Integer> intersectionOfUnsortedArr(int[] arr1 , int[] arr2)
	{
		List<Integer> intesectList = new ArrayList<Integer>();
		int[] sortedArr;
		if(arr1.length < arr2.length)
		{
			Arrays.sort(arr1);
			sortedArr = arr1;
			arr1 = arr2;
		}
		else
		{
			Arrays.parallelSort(arr2);
			sortedArr = arr2;
			
		}
		
		
		for(int i =0 ; i < arr1.length ; i ++)
		{
			if(binarySearch(arr1[i], sortedArr))
			{
				intesectList.add(arr1[i]);
			}
		}
		return intesectList;
	}
	
	boolean binarySearch(int num, int[] numArr)
	{
		int left = 0;
		int right = numArr.length - 1;
		
		while(left <= right)
		{
			int mid = left + (right-left)/2;
			if(numArr[mid] == num)
			{
				return true;
			}
			else if(numArr[mid] < num)
			{
				left = mid + 1;
			}
			else
			{
				right = mid -1;
			}
			
		}
		return false;
	}
	
	
	/*
	 * Find Substring with consecutive letters ‘’QWERTYABCDEZXCVXYZ” (Display your
	 * output like ABCDE, count:5 and occurrence : 1 AND XYZ, count:3 and occurrence
	 * :
	 *  2) Check for a balanced parentheses in for a given expression : Example ->
	 * Input: exp = “[()]{}{[()()]()}” Output: Balanced 
	 * Find count of each
	 * characters in the given string and print the count of each characters in
	 * descending order of alphabets String str="radioimmunoelectrophoresis" 
	 * Find Intersection of 2 unsorted arrays. 
	 * Find the first non repeatable character in
	 * the given string name="PAYPAL"
	 */
	
	
	Object getObject()
	{
		return this;
	}
	
	private Paypal() {
		// TODO Auto-generated constructor stub
	}
	
	 enum dateEnum
	    {
	        Jan("01"),Feb("02"),Mar("03"),Apr("04"),May("05"),Jun("06"),Jul("07"),Aug("08"),Sep("09"),Oct("10"),Nov("11"),Dec("12");
		 String mon;
	        dateEnum(String m)
	        {
	        	this.mon = m;
	        }
	    }
	public static void main(String[] args) {
		Paypal paypal = new Paypal();
//		paypal.consecutiveSubStr("QWEFGRTYABCDEZXCVEFXYZ");
//		
//		System.out.println(paypal.isParenthesisBalanced("[()]{}"));
//		System.out.println(paypal.isParenthesisBalanced("[()]{}{[()()]()}"));//true
//		System.out.println(paypal.isParenthesisBalanced("[(]{}"));//fasle
//		System.out.println(paypal.isParenthesisBalanced("{[()()]()"));//false
//		System.out.println(paypal.isParenthesisBalanced("{[[()]]()}"));//true
//		
//		paypal.characterCount("radioimmunoelectrophoresis");
//		
//		System.out.println(paypal.firstNonRepeatableChar("paypal"));
		
		
//		System.out.println(paypal.intersectionOfUnsortedArr(new int[] {5,4}, new int[] {1,22,5,7,2}));
//		System.out.println(paypal.intersectionOfUnsortedArr(new int[] {5,4,22,5,0,2}, new int[] {1,22,5,7,2}));
//		System.out.println(paypal.intersectionOfUnsortedArr(new int[] {5,4,5}, new int[] {1,22,5,7,2}));
//		System.out.println(paypal.getObject().getClass().getDeclaredConstructors()[0].getModifiers());
		String s = "1st";
		int digit = 1;
		int num = 0;
		for(char c : s.toCharArray())
		{
			if(!Character.isDigit(c))
			{
				break;
			}
				int n = Character.digit(c, Character.MAX_RADIX);
				num = (num * digit) + n;
				digit *= 10;
		}
		String day = String.format("%02d", num);
		System.out.println(day);
	}
	
	private String formatDate(String s)
	{
		int digit = 1;
		int num = 0;
		for(char c : s.toCharArray())
		{
			if(!Character.isDigit(c))
			{
				break;
			}
				int n = Character.digit(c, Character.MAX_RADIX);
				num = (num * digit) + n;
				digit *= 10;
		}
		String day = String.format("%02d", num);
		return day;
	}
	
	
}

