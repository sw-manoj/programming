package easyprob;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/roman-to-integer/
public class RomanToInt {

	static Map<String, Integer> values = new HashMap<>();
    
    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }
    
    public int romanToInt2ndTry(String s)
    {
    	int num = 0;
    	int prev = -1;
    	
    	for(int i = s.length()-1 ; i >= 0 ; i--)
    	{
    		int val = values.get(String.valueOf(s.charAt(i)));
    		if ( prev > val)
    		{
    			num = num-val;
    		}
    		else {
    			num = num + val;
    		}
    		prev = val;
    	}
    	
    	return num;
    }

	public static void main(String[] args) {
		//Assuming the input will always be valid
		RomanToInt roman = new RomanToInt();
		System.out.println(roman.romanToInt("IV"));
		System.out.println(roman.romanToInt("LVIII"));
		System.out.println(roman.romanToInt("MCMXCIV"));
		System.out.println(roman.romanToInt("MMMCMXCIX"));
		System.out.println(roman.romanToInt("LVIII"));
		
		
		System.out.println(roman.romanToInt2ndTry("IV"));
		System.out.println(roman.romanToInt2ndTry("LVIII"));
		System.out.println(roman.romanToInt2ndTry("MCMXCIV"));
		System.out.println(roman.romanToInt2ndTry("MMMCMXCIX"));
		System.out.println(roman.romanToInt2ndTry("LVIII"));
	}
	 public int romanToInt(String s) {
	        
		 int res = 0;
		 int lastVal = 0;
		 
		 for(int i = s.length() -1 ; i >= 0 ; i--)
		 {
			 int val = values.get(String.valueOf(s.charAt(i)));
			 if(lastVal > val)
			 {
				 res -= val;	 
			 }
			 else
			 {
				 res += val;	
			 }
			 lastVal = val;
		 }
		 return res;
	    }
}
