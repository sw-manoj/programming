package com.samples.sort.cyclicsort;

import java.util.Arrays;

public class CyclicSort {

	public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        
        int[] arr1 = {4,5,2,1,3};
        sort(arr1);
        System.out.println(Arrays.toString(arr1));

    }

    static void sort(int[] arr) {
    	
    	int i = 0;
    	while( i < arr.length )
    	{
    		if( arr[i]-1 != i)
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
