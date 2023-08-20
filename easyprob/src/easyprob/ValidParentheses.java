package easyprob;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses
public class ValidParentheses {

	Map<Character, Character> parenMap = new HashMap<>() {{
		put(')', '(');
		put('}', '{');
		put(']', '[');
	}};

	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<>();
		for(Character ch : s.toCharArray())
		{
			if(parenMap.containsKey(ch))
			{
				if(stack.isEmpty() || stack.pop() != parenMap.get(ch)) return false;
			}
			else
			{
				stack.push(ch);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidParentheses obj = new ValidParentheses();
		System.out.println(obj.isValid("()"));
		System.out.println(obj.isValid("()[]{}"));

		System.out.println(obj.isValid("(]"));
		System.out.println(obj.isValid("}{"));
		System.out.println(obj.isValid("]"));


	}
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(char c : s.toCharArray())
		{
			if(parenMap.containsKey(c))
			{
				if(stack.isEmpty() || stack.pop() !=  parenMap.get(c)) return false; 
			}
			else
			{
				stack.push(c);
			}
		}
        return stack.isEmpty();
    }




}
