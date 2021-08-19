package com.samples.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;


//https://leetcode.com/problems/find-k-closest-elements/
public class FindKClosetElement {

public List<Integer> findClosestElements1(int[] arr, int k, int x) {
	
	
	
	Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
	for(int num : arr)
	{
		map.computeIfAbsent(Math.abs(x-num), k1 -> new ArrayList<>()).add(num);
	}

	List<Integer> res = new ArrayList<>();
	for(List<Integer> list : map.values())
	{
		for(int n : list)
		{
			if(res.size() == k)
			{
				break;
			}
			res.add(n);
		}
	}
	Collections.sort(res);
		return res;
    }

public List<Integer> findClosestElements2(int[] arr, int k, int x) {
    // Convert from array to list first to make use of Collections.sort()
    List<Integer> sortedArr = new ArrayList<Integer>();
    for (int num: arr) {
        sortedArr.add(num);
    }
    
    // Sort using custom comparator
    Collections.sort(sortedArr, (num1, num2) -> Math.abs(num1 - x) - Math.abs(num2 - x));
    
    System.out.println(sortedArr);
    // Only take k elements
    sortedArr = sortedArr.subList(0, k);
    
    // Sort again to have output in ascending order
    Collections.sort(sortedArr);
    return sortedArr;
}

public List<Integer> findClosestElements3(int[] arr, int k, int x) {
	int left = 0; int right = arr.length-1;
	int mid = 0;
	
	 while (left < right) {
         mid = (left + right) / 2;
// 		System.out.println(left + "==" + right + "==" + mid);
		 // mid  leads to left num in smaller differences e.g 2+3/2 =2, thus so left has to be incremented on correct case, right will change anyway we assign mid to it.

         if (arr[mid] >= x) {
             right = mid;
         } else {
             left = mid + 1;
         }
     }
//		System.out.println(left + "==" + right + "==" + mid);

     // Initialize our sliding window's bounds
     left -= 1;
     right = left + 1;
//		System.out.println(left + "==" + right + "==" + mid);

	int l = left, r = l+1;
	int index = mid;
	List<Integer> res = new ArrayList<>();
	while(k > 0)
	{
		
		if( r == arr.length || (l >= 0 && Math.abs(x- arr[l ]) <= Math.abs(x- arr[r ])) )
		{
			res.add(arr[l]);
			l--;
		}
		else
		{
			res.add(arr[r]);
			r++;
		}
		k--;
	}
//	System.out.println(res);
    Collections.sort(res);

	return res;
}

public List<Integer> findClosestElements(int[] arr, int k, int x) {
    // Initialize binary search bounds
    int left = 0;
    int right = arr.length -k;

    // Binary search against the criteria described
    while (left < right) {
        int mid = (left + right) / 2;
// 		System.out.println(left + "==" + right + "==" + mid);

        if (x - arr[mid] > arr[mid + k] - x) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
//		System.out.println(left + "==" + right + "==" );

    // Create output in correct format
    List<Integer> result = new ArrayList<Integer>();
    for (int i = left; i < left + k; i++) {
        result.add(arr[i]);
    }
    
    return result;
}

public static void main(String[] args) {
	FindKClosetElement obj = new FindKClosetElement();
	System.out.println(obj.findClosestElements(new int[] {1 ,2,3,4,5,6,7}, 3, 4));
	System.out.println(obj.findClosestElements(new int[] {1 ,2,3,4,5,6,7}, 3, -2));
	System.out.println(obj.findClosestElements(new int[] {1 ,2,3,4,5,6,7}, 3, 9));
	System.out.println(obj.findClosestElements(new int[] {1 ,3}, 1, 2));
	
	System.out.println(obj.findClosestElements(new int[] {1,10,15,25,35,45,50,59}, 1, 30));

	
	System.out.println(obj.findClosestElements3(new int[] {1 ,2,3,4,5,6,7}, 3, 4));
	System.out.println(obj.findClosestElements3(new int[] {1 ,2,3,4,5,6,7}, 3, -2));
	System.out.println(obj.findClosestElements3(new int[] {1 ,2,3,4,5,6,7}, 3, 9));
	System.out.println(obj.findClosestElements3(new int[] {1 ,3}, 1, 2));
	
	System.out.println(obj.findClosestElements3(new int[] {1,10,15,25,35,45,50,59}, 1, 30));


}

}
