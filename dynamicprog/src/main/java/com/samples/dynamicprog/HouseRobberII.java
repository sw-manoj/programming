package com.samples.dynamicprog;

public class HouseRobberII {

//	https://leetcode.com/problems/house-robber-ii/
	
	
//	Assume we have nums of [7,4,1,9,3,8,6,5] as shown in the figure. 
//	Since the start house and last house are adjacent to each other, if the thief decides to rob the start house 7, 
//	they cannot rob the last house 5. Similarly, if they select last house 5, they have to start from a house with value 4.
//	Therefore, the final solution that we are looking for is to take the maximum value 
//	the thief can rob between houses of list [7,4,1,9,3,8,6] and [4,1,9,3,8,6,5]. 
//	For each of the lists, all we need to do is to figure the maximum value the thief can get using the 
//	approach in the original House Robber Problem.
	
	public int rob(int[] nums, int start , int end) {
		
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		
        int prevPlusOne = 0;
        int prev = 0;
        for(int i = start ;i <= end; i++)
        {
        	int tmp = prev;
        	prev = Math.max(nums[i] + prevPlusOne, prev);
        	prevPlusOne = tmp;
//        	prev = nums[i];
        }
//        System.out.println(prev + "==");
        return prev;
    }
	
	public int rob(int[] nums)
	{
		return Math.max(rob(nums,0, nums.length-2), rob(nums,1, nums.length-1));
	}
	
	public static void main(String[] args) {
		HouseRobberII obj = new HouseRobberII();
		System.out.println(obj.rob(new int[] {2,3,2}));
		System.out.println(obj.rob(new int[] {1,2,3,1}));
		System.out.println(obj.rob(new int[] {200,3,140,20,10}));



	}
}
