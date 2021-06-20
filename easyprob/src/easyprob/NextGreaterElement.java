package easyprob;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

//	https://leetcode.com/problems/next-greater-element-i/solution/
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack< Integer > stack = new Stack < > ();
        HashMap < Integer, Integer > map = new HashMap < > ();
        int[] res = new int[findNums.length];
        
        //sorting and put into map with key {i} to higher number as value.
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }
	
}
