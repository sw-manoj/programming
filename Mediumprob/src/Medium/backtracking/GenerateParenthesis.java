package Medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
//	https://leetcode.com/problems/generate-parentheses/
	public static void main(String[] args) {
		GenerateParenthesis gp = new GenerateParenthesis();
		
		System.out.println(gp.generateParenthesis(3));
	}

	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans; 
    }
	
	public void backtrack(List<String> ans, StringBuilder str, int open, int close, int max)
	
	{
		if(str.length() == max *2)
		{
			ans.add(str.toString());
			return;
		}
		
		if(open < max)
		{
			str.append("(");
			backtrack(ans, str, open + 1, close, max);
			str.deleteCharAt(str.length() - 1);
		}
		
		if(close < open)
		{
			str.append(")");
			backtrack(ans, str, open , close + 1, max);
			str.deleteCharAt(str.length() - 1);
		}
	}
}
