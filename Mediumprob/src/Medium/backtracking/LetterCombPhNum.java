package Medium.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombPhNum {

//	https://leetcode.com/problems/letter-combinations-of-a-phone-number/
	static Map<String, String> phMap = new HashMap<>(){{
	    put("2", "abc");
	    put("3", "def");
	    put("4", "ghi");
	    put("5", "jkl");
	    put("6", "mno");
	    put("7", "pqrs");
	    put("8", "tuv");
	    put("9", "wxyz");
	}};
	
	private void addperm(int index, String str, List<String> res, String digit)
	{
		if(index >= digit.length())
		{
			res.add(str);
			return;
		}
		
		char[] charArr = phMap.get(String.valueOf(digit.charAt(index))).toCharArray();
		for(char c : charArr)
		{
			addperm(index+ 1, str + "" + c, res, digit);
		}
	}
	public List<String> letterCombinations_2ndtry(String digits) {
		List<String> res = new ArrayList<>();
		
		addperm(0, "", res, digits);
		return res;
	}
	public static void main(String[] args) {
		System.out.println(phMap);
		
		LetterCombPhNum letterComb  = new LetterCombPhNum();
		System.out.println(letterComb.letterCombinations("23"));
		System.out.println(letterComb.letterCombinations_2ndtry("23"));
		System.out.println(letterComb.letterCombinations_2ndtry("2"));


	}
	
	private void backtrack(String digits, int index, StringBuilder path, List<String> result)
	{
		if(path.length() == digits.length())
		{
			result.add(path.toString());
			return;
		}
		String chara = phMap.get(String.valueOf(digits.charAt(index)));
		
		for(char c :chara.toCharArray())
		{
			path.append(c);
			backtrack(digits, index+1, path, result);
			path.deleteCharAt(path.length() - 1);
		}
	}
	
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if(digits.length() == 0)
		{
			return result;
		}
		
		backtrack(digits, 0, new StringBuilder(), result);
		return result;
        
    }
}
