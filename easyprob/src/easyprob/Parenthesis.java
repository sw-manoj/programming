package easyprob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Parenthesis {

	public static void main(String[] args) {
		Parenthesis param = new Parenthesis();
		
//		System.out.println(param.isValid("()"));
//		System.out.println(param.isValid("([)]"));
		System.out.println(param.isValid("(]"));
		System.out.println(param.isValid("(){}}{"));
	}
	static Map<Character, Character> parentmap = new HashMap<>();
	static List<Character> closingParam = new ArrayList<>();
	Stack<Character> stack = new Stack<>();
	static
	{
		parentmap.put('[', ']');
		parentmap.put('{', '}');
		parentmap.put('(', ')');
		
		closingParam.add(']');
		closingParam.add('}');
		closingParam.add(')');
	}
	public boolean isValid(String input) {
        //clear the stack
        this.stack.clear();
        
        //for each char, add it to stack, with some decision making
        for (char ch: input.toCharArray()){
            if (ch == '{' || ch == '(' || ch == '['){
                this.stack.push(ch);
            }
            else{                
                //if stack is empty, invalid
                if (this.stack.size() == 0){
                    return false;
                }
                //its a closing character, need to check current top
                // if current top is not of the same type, its a problem
                char topOfStack = this.stack.peek();
                if ((topOfStack == '{' && ch != '}') 
                    || (topOfStack == '(' && ch != ')')
                    || (topOfStack == '[' && ch != ']')){
                    return false;
                }
                //else, its of the same type, pop it
                this.stack.pop();
            }
        }        
        
        //return if stack is empty
        return stack.size() == 0;    
    }
	 public boolean isValid1(String s) {
	        
		 if(s.length() == 0) return true;
		 if(s.length() == 1) return false;
		 stack.push(s.charAt(0));
		 for(int i = 1 ; i <s.length() ; i++)
		 {
			 if(closingParam.contains(s.charAt(i)))
			 {
				 if(stack.isEmpty()) return false;
				 char c = stack.pop();
				 if(!parentmap.containsKey(c) || s.charAt(i) != parentmap.get(c))
				 {
					 return false;
				 }
			 }
			 else
			 {
				 stack.push(s.charAt(i));
			 }
		 }
		 return stack.isEmpty();
	 }
}
