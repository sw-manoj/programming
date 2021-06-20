package com.samples.random;

import java.util.Stack;

public class TrapWater {

	
	
	public int trap2(int[] arr)
	{
		int unit = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int current = 0; current < arr.length; current ++) 
		{
			while(!stack.isEmpty() && arr[stack.peek()] < arr[current])
			{
				int top = stack.pop();
				if(stack.isEmpty())
				{
					break;
				}
				int top2 = stack.peek();
				
				int distance = current - top2 - 1;
				
				int heigth = Math.min(arr[current], arr[top2]) - arr[top];
				unit +=  distance * heigth;
			}
			stack.add(current);
		}
		return unit;
	}
	
	 public int trap(int[] height) {
	        int i = 0, j = height.length - 1;
	        int res = 0;
	        
	        while (i < j) {
	            if (height[i] < height[j]) {
	                int temp = height[i];
	                while (height[i] <= temp && i < j) {
	                    res += temp - height[i++];
	                }
	            } else {
	                int temp = height[j];
	                while (height[j] <= temp && i < j) {
	                    res += temp - height[j--];
	                }
	            }
	        }
	        return res;
	    }
	public static void main(String[] args) {
		TrapWater t = new TrapWater();
		System.out.println(t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//		
//		System.out.println(t.trap(new int[]{0,1,1,2,1,0,0,1,1,3,2,1,2,1}));
//		
//		System.out.println(t.trap(new int[]{1}));
//		System.out.println(t.trap(new int[]{2,0,2}));
		System.out.println(t.trap(new int[]{4,3,2,0}));
		System.out.println(t.trap(new int[]{0,1,0,1}));
		System.out.println(t.trap(new int[]{0,1,4,3,2,3}));

		
		System.out.println(t.trap(new int[]{0,1,0,4,0,0,3,1,0,1,2,5}));
		System.out.println(t.trap(new int[]{0,1,0,4,0,0,3,1,3,2,0,2,5}));
	}
}
