package com.samples.sort.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

	public static void main(String[] args) {
		FindDisappearedNumbers obj = new FindDisappearedNumbers();
		System.out.println(obj.findDisappearedNumbers(new int [] {4,3,2,7,8,2,3,1}));
	}
	 public List<Integer> findDisappearedNumbers(int[] nums) {
		 List<Integer> result = new ArrayList<Integer>();
		 sort(nums);
			
		 for(int i = 0 ; i < nums.length;i++)
			{
				if(nums[i] -1 != i)
				{
					result.add(i+1);
				}
			}
		 return result;
	 }
	 
	 void sort(int[] arr) {
	    	
	    	int i = 0;
	    	while( i < arr.length )
	    	{
	    		if( arr[i]-1 != i && arr[i] != arr[arr[i]-1])
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
