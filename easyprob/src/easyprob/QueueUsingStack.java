package easyprob;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/solution/

public class QueueUsingStack {
	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();
	int front = -1;
	// Push element x to the back of queue.
	public void push(int x) {
	    if (s1.empty())
	        front = x;
	    s1.push(x);
	}
	
	public void pop() {
	    if (s2.isEmpty()) {
	        while (!s1.isEmpty())
	            s2.push(s1.pop());
	    }
	    s2.pop();    
	}
	
	// Return whether the queue is empty.
	public boolean empty() {
	    return s1.isEmpty() && s2.isEmpty();
	}
	
	public int peek() {
	    if (!s2.isEmpty()) {
	            return s2.peek();
	    }
	    return front;
	}
}
