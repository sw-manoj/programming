package Medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
//	https://leetcode.com/problems/generate-parentheses/
	public static void main(String[] args) {
		GenerateParenthesis gp = new GenerateParenthesis();
		
		System.out.println(gp.generateParenthesis(3));
		
		System.out.println(gp.generateParenthesis_2ndtry(3));

	}
	
	private void genParenthesis(int count, int n, String str, List<String> res, int open, int close)
	{
		if(str.length() == n * 2)
		{
			res.add(str);
			return;
		}
		String s = str;
		if(open < n)
		{
			s += "(";
			genParenthesis(count+1, n, s , res, open + 1,close);
		}
		
		if(close < open)
		{
			s += ")";
			genParenthesis(count+2, n, s , res, open, close + 1);
		}
		
	}
	
	public List<String> generateParenthesis_2ndtry(int n) {
		List<String> ans = new ArrayList<>();
		genParenthesis(0, n, "", ans, 0, 0 );
        return ans; 
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
