package Medium;

import java.util.Stack;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
public class MinRemoveToMakeValid {
	
	public static void main(String[] args) {
		MinRemoveToMakeValid obj = new MinRemoveToMakeValid();
		System.out.println(obj.minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(obj.minRemoveToMakeValid("a)b(c)d"));
		System.out.println(obj.minRemoveToMakeValid("))(("));


	}

	public String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<>();
		char[] ch_arr = s.toCharArray();
		for(int i = 0 ; i < ch_arr.length ; i++)
		{
			char ch = ch_arr[i];
			if(ch == '(')
			{
				stack.push(i);
			}
			else if(ch == ')')
			{
				if (!stack.isEmpty() && ch_arr[stack.peek()] == '(')
					stack.pop();
				else
					stack.push(i);
			}
		}
		
		while(!stack.isEmpty())
		{
			ch_arr[stack.pop()] = ' ';
		}
		return String.valueOf(ch_arr).replace(" ", "");
    }
}
