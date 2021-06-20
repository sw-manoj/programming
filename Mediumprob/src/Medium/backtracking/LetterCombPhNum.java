package Medium.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombPhNum {

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
	
	public static void main(String[] args) {
		System.out.println(phMap);
		
		LetterCombPhNum letterComb  = new LetterCombPhNum();
		System.out.println(letterComb.letterCombinations("23"));
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
