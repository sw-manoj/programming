package com.samples.sort.cyclicsort;

import java.util.Arrays;

public class MissingNumber {
	public static void main(String[] args) {
		MissingNumber obj = new MissingNumber();
		System.out.println(obj.missingNumber(new int[] {7,8,9,11,12} ));
	}

	public int missingNumber(int[] nums) {
        
		int i = 0; 
		
		while(i < nums.length)
		{
			if(nums[i] < nums.length  && nums[i] >= 0 && nums[i] != i )
			{
				swap(nums, i, nums[i]);
			}
			else
			{
				i++;
			}
		}
		System.out.println(Arrays.toString(nums));
		for (int index = 1; index < nums.length; index++) {
            if (nums[index] != index) {
                return index;
            }
        }

        // case 2
        return nums.length;
    }
	
	static void swap(int[] arr, int i, int j)
    {
    	int tmp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = tmp;
    }
}
