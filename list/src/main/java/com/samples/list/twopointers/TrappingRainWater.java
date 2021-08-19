package com.samples.list.twopointers;

import java.util.Stack;

//https://leetcode.com/problems/trapping-rain-water/


public class TrappingRainWater {

	//find max height in left and right side of current index(i), and find min of it which will be the upper limit. 
//	upperlimit - height[i] , give water unit trapped.
	
	// brute force approach
    public int trap4(int[] height) {

    	int ans = 0;
    	int n = height.length;

    	for( int i = 0; i < n ; i++) 
    	{
    		int leftMax = getMaxHeight(0, i, height) ,  rightMax = getMaxHeight(i, n-1, height);
    		ans += Math.min(leftMax, rightMax) - height[i];
    	}
    	return ans;
    }
    
    public int getMaxHeight(int i, int j , int[] height)
    {
    	int max = 0;
    	for(int k = i ; k <= j ; k++ )
    	{
    		max = Math.max(max, height[k]);
    	}
    	
    	return max;
    }
    
    // using dp, left and right max prefix array as DP
    //this is accepted solution.
    public int trap3(int[] height) {

    	int ans = 0;
    	int n = height.length;
    	int[] leftMax = new int[n];
    	int[] rightMax = new int[n];
    	leftMax[0] = height[0];
    	rightMax[n-1] = height[n-1];
    	
    	for( int i = 1; i < n ; i++) 
    	{
    		leftMax[i] = Math.max(leftMax[i-1], height[i]);
    	}
    	
    	for( int i = n-2; i >=0 ; i--) 
    	{
    		rightMax[i] = Math.max(rightMax[i+1], height[i]);
    	}
    	
    	for( int i = 1; i < n ; i++) 
    	{
    		ans+= Math.min(leftMax[i], rightMax[i]) - height[i];
    	}
    		
    	return ans;
    }
    
    public int trap2(int[] height) 
    {
    	int ans = 0;
    	Stack<Integer> stack = new Stack<>();
    	//keep adding small ehgith index, once found upper index, like heights 4,3,2,5 then , we take bound heights left and rights, 
//    	which means min(3,5) - 2 to get the water unit, multiple with dist between 3 to 5 distance calc is required becuase in next iteration,
//    	 we get min(4,5) - 3
    	
    	// in the other method, we got the max from complete left and right side, so no need to multiply by dist, here,
//    	we operate with maximums with at that point , it can be overall  max or some other max coming up, just like how , 
//    	we calculated above for 2 with 3 1st and using 3 with 4.
    	for(int i = 0 ; i < height.length ;i++)
    	{
    		 while(!stack.empty() && height[i] > height[stack.peek()])
    		 {
    			 int top = stack.pop();
    			 if(stack.isEmpty()) break;
    			 
    			 int top2 = stack.peek();
    			 
    			 int dist = i - top2 -1;
    			 ans += (Math.min(height[i], height[top2]) - height[top]) * dist;
    		 }
    		 stack.push(i);
    	}
    	
    	return ans;	
    }
    
    //two pointer
    public int trap(int[] height) 
    {
		int ans = 0;
		int left = 0; 
		int right = height.length-1;
//		Using two pointers, try to find max for both sides, if right is alredy big, then move left until max is reached, same on if left is big,
//		move right unitl right mmax is reached. once we get smalled height than max noted, 
//		we add the height for that node to height at that index as higher bound identified on left and right
		int leftmax = 0, rightMax = 0;
		while(left < right) 
		{
			if(height[left] < height[right])
			{
				if(height[left] >= leftmax) 
					leftmax = height[left] ;
				else
					ans += leftmax - height[left];
				
				left++;
			}
			else
			{
				if(height[right] >= rightMax) 
					rightMax = height[right] ;
				else
					ans += rightMax - height[right];
				
				right--;
			}
		}
		return ans;
    }
    public static void main(String[] args) {
		TrappingRainWater obj = new TrappingRainWater();
		System.out.println(obj.trap2(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(obj.trap2(new int[] {4,2,0,3,2,5}));

	}
}
