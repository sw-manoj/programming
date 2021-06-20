package com.samples.binarytree;

public class BinarySearch {

	public static void main(String[] args) {
		Solution so = new Solution();
		int [] nums = {2,5};
		int target = 5;
		int index = so.search(nums, target);
		System.out.println("index of target " + index);
		
		
		System.out.println("guess game" + so.guessGame(1));
			}
}

class Solution {
	
    public int search(int[] nums, int target) {
//        if(nums.length == 1 )
//        {
//        	return (nums[0] == target) ? 0 : -1;
//        }
    	return rec(0, nums.length - 1, nums, target);
    }
    
    public int guessGame(int n)
    {
    	int low = 0 ; int high = n;
    	
    	while(low <= high)
    	{
    		int mid = low + (high-low)/2;
    		int res = guessNum(mid);
    		if(res ==0 )
    		{
    			return mid;
    		}
    		else if(res == -1)
    		{
    			low = mid +1;
    		}
    		else if(res == 1)
    		{
    			high = mid -1;
    		}
    		
    	}
    	
    	return 0;
    }
    
    public int guessNum(int n)
    {
    	int tar = 1;
    	if(n == tar)
    	{
    		return 0;
    	}
    	else if(n > tar)
    	{
    		return 1;
    	}
    	else if(n < tar)
    	{
    		return -1;
    	}
		return -1;
    }
    
    public int rec(int low, int high, int[] nums, int target)
    {
    	if(low <= high)
    	{

    		    	
    	int mid = (high + low)/2;
    	
    	if(nums[mid] == target)
    	{
    		return mid;
    	}
    	else if(nums[mid] < target)
    	{
    		return rec(mid +1, high , nums, target);
    	}
    	else if(nums[mid] > target)
    	{
    		return rec(low, mid-1, nums, target);
    	}
    	}
    	
    	return -1;
    }
}
