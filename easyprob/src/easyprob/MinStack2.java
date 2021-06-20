package easyprob;

import java.util.Stack;

public class MinStack2 {

	Stack<Integer> minStack = new Stack<>();
	Stack<Integer> stack = new Stack<>();
	/** initialize your data structure here. */
    public MinStack2() {
        
    }
    
    public void push(int val) {
    	stack.push(val);
    	if(minStack.isEmpty() || minStack.peek() >= val)
    	{
    		minStack.push(val);
    	}
    }
    
    public void pop() {
        int val = stack.pop();
        if(minStack.peek() == val)
        {
        	minStack.pop();
        }
       
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.pop();
    }
}
