package Medium.frequent;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/maximum-frequency-stack/submissions/
public class MaxFrequencyStack {
	
	public MaxFrequencyStack() {
        
    }

	Map<Integer, Integer> countMap = new HashMap<>();
	int maxFreq;
	Map<Integer, Stack<Integer>> groupMap = new HashMap<Integer, Stack<Integer>>();
	
    
    public void push(int val) {
        int freq = countMap.getOrDefault(val, 0) + 1;
        groupMap.computeIfAbsent(freq, k -> new Stack<>()).push(val);
        if(freq > maxFreq)
        {
        	maxFreq = freq;
        }
        countMap.put(val, freq);
    }
    
    public int pop() {
    	int val = groupMap.get(maxFreq).pop();
    	if(groupMap.get(maxFreq).size() == 0)
    	{
    		maxFreq--;
    	}
    	countMap.put(val, countMap.get(val)-1);
    	return val;
    	
    }
}
