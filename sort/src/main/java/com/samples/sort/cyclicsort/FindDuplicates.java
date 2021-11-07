package com.samples.sort.cyclicsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {

	public static void main(String[] args) {
		FindDuplicates obj = new FindDuplicates();
		System.out.println(obj.findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
		System.out.println(obj.findDuplicates(new int[] {1}));
		

	}
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		sort(nums);
		
//		System.out.println(Arrays.toString(nums));
		for(int i = 0 ; i < nums.length;i++)
		{
			if(nums[i] -1 != i)
			{
				result.add(nums[i]);
			}
		}
		return result;
    }
	
	void sort(int[] arr) {
    	
    	int i = 0;
    	while( i < arr.length )
    	{
    		if( arr[i] != arr[arr[i]-1])
    		{
    			swap(arr, i, arr[i]-1);
    		}
    		else
    		{
    			i++;
    		}
    	}
    }
    
    static void swap(int[] arr, int i, int j)
    {
    	int tmp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = tmp;
    }
}
