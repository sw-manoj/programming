package com.samples.sort;

import java.util.ArrayList;
import java.util.List;

/* Java program for Merge Sort */
public class MergeSort 
{ 
	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	void merge(int arr[], int l, int m, int r) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		int L[] = new int [n1]; 
		int R[] = new int [n2]; 
		
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();

		/*Copy data to temp arrays*/
		for (int i=l; i<=m; ++i) 
			left.add(arr[i]); 
		for (int j=m+1; j<=r; ++j) 
			right.add(arr[j]); 


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < left.size() && j < right.size()) 
		{ 
			if (left.get(i) <= right.get(j)) 
			{ 
				arr[k] = left.get(i); 
				i++; 
			} 
			else
			{ 
				arr[k] = right.get(j); 
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < left.size()) 
		{ 
			arr[k] = left.get(i); 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < right.size()) 
		{ 
			arr[k] = right.get(j); 
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(int arr[], int l, int r) 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		int arr[] = {12, 11, 13, 5, 6, 7}; 

		System.out.println("Given Array"); 
		printArray(arr); 

		MergeSort ob = new MergeSort(); 
		ob.sort(arr, 0, arr.length-1); 

		System.out.println("\nSorted array"); 
		printArray(arr); 
	} 
} 
/* This code is contributed by Rajat Mishra */
