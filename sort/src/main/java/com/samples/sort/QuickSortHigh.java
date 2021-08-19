package com.samples.sort;


public class QuickSortHigh {

   
    
    public void quickSort(int[] arr, int low, int high)
    {
    	int pivot = arr[high];
    	
    	int i= low, j = high;
    	
    	while(i <= j)
    	{
    		while(arr[i] < pivot)
    		{
    			i++;
    		}
    		while(arr[j] > pivot)
    		{
    			j--;
    		}
    		
    		if(i <= j)
    		{
    			swap(arr, i, j);
    			i++;
    			j--;
    		}
    	}
    	
    	System.out.println(i + "===" + j);
    	if(low < j)
    	{
    		quickSort(arr, low, j);
    	}
    	
    	if(high > i)
    	{
    		quickSort(arr, i, high);
    	}
    	
    }
    
    static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
    
    static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
    
    public static void main(String[] args) {
		int arr[] = {0,2, 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		QuickSortHigh ob = new QuickSortHigh();
		ob.quickSort(arr, 0, n - 1);

		System.out.println("sorted array");
		printArr(arr);
	}
}
