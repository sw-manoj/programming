package com.samples.list.twopointers;

public class ContainerWater {

//	https://leetcode.com/problems/container-with-most-water/submissions/
	public int maxArea(int[] height) {
        int maxArea= 0;
        
        int l = 0; 
        int r = height.length - 1;
        
        
        while(l < r)
        {
        	maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r-l));
        	
        	if(height[l] < height[r])
        	{
        		l++;
        	}
        	else
        	{
        		r--;
        	}
        }
        
        return maxArea;
    }
	
	
	public static void main(String[] args) {
		ContainerWater obj = new ContainerWater();
		System.out.println(obj.maxArea_2ndtry(new int [] {1,8,6,2,5,4,8,3,7}));
		System.out.println(obj.maxArea_2ndtry(new int [] {4,3,2,1,4}));

		System.out.println(obj.maxArea_2ndtry(new int [] {1,1}));

		System.out.println(obj.maxArea_2ndtry(new int [] {1,2,1}));

	}
	
	
	
	public int maxArea_2ndtry(int[] height) {
        int maxArea= 0;
        
        int l = 0 , r = height.length - 1;
        
        while(l < r)
        {
        	int minH = Math.min(height[l], height[r]);
        	maxArea = Math.max(maxArea, (r-l) * minH);

        	if(height[l] < height[r])
        	{
        		l++;
        	}
        	else
        	{
        		r--;
        	}
        	
        }
     
        return maxArea;
	}
}
