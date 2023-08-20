package com.samples.list;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/solution/
public class RotateArray {
	public static void main(String[] args) {
		RotateArray obj = new RotateArray();
		
//		int[] nums = {1,2,3,4, 5,6,7};
//		obj.rotate3(nums,3);
		
		int[] nums1 = {-1,-100,3,99};
		obj.rotate3(nums1, 2);

		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums1));

	}

	public void rotate3(int[] nums, int k) {

		k = k % nums.length;
		int current_step;
		int start = 0;
		int count = 0;

		while(count < nums.length) {
			int currentIndex = start;
			int currentElement = nums[currentIndex];

			do  {
				int nextIndex = (currentIndex + k) % nums.length;
				int nextElement = nums[nextIndex];
				nums[nextIndex] = currentElement;
				currentIndex = nextIndex;
				currentElement = nextElement;
				count++;
			} while(currentIndex != start);
			start++;
		}
	}

	public void rotate_timedout(int[] nums, int k) {
		
		
		if(k >= nums.length)
		{
			k = k % nums.length;
		}
		if(k <= 0)
		{
			return;
		}
		
		int end = nums.length  - 1 - k;
		
		while(end >= k)
		{
			for(int i = end ; i > (end - k) ; i--)
			{
				swap(nums, i , i + k);
			}
			end = end-k;
		}
		System.out.println(end);
		
		for(int i = end; i >= 0 ; i--)
		{
			int inc = i;
			for(int j = 1; j <= k;j++)
			{
				swap(nums, inc, i + j);
				inc++;
			}
		}
		
    }
	
	private void swap(int[] nums, int i , int j)
	{
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public void rotate(int[] nums, int k)
	{
		k = k % nums.length;
		reverse(nums, 0 , nums.length-1);
		reverse(nums, 0 , k-1);
		reverse(nums, k  , nums.length-1);


	}
	
	private void reverse(int[] nums, int l, int r)
	{
		while(l < r)
		{
			swap(nums, l , r);
			l++;
			r--;
		}
	}
	
	//optimized
	public void rotate_cyc(int[] nums, int k)
	{
		k = k % nums.length;
		int start = 0;
		int count = 0;
		int n = nums.length;
		
		while(count < nums.length)
		{
			int current = start;
			int prev = nums[start];
			do 
			{
				int next = (current + k) % n;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				count++;
			}while(current != start);
			start++;
		}
	}
	
}
