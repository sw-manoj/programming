package com.samples.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosetElement1 {

	public List<Integer> findClosestElements1(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
		
		int left = 0;
		 int right = arr.length-1;
		 
		 while(left < right)
		 {
			 System.out.println(left + "==" + right);

			 int mid = (left + right)/2;
			 // mid  leads to left num in smaller differences e.g 2+3/2 =2, thus so left has to be incremented on correct condition ont break the loop,
//			 right will change anyway when we just assign mid to it.
			 if(arr[mid] < x)
			 {
				 left = mid+1;
			 }
			 else
			 {
				 right = mid;
			 }
		 }
		 System.out.println(left + "==" + right);

		 left -=1;
		 right = left+1;
		 
		 while(k > 0)
		 {
			 if(right == arr.length || (left >= 0 && Math.abs(arr[left] - x) <= Math.abs(arr[right] -x)))
			 {
				 res.add(arr[left]);
				 left--;
			 }
			 else
			 {
				 res.add(arr[right]);
				 right++;
			 }
			 k--;
		 }
		 
		Collections.sort(res);
		return res;
	}
	
	public static void main(String[] args) {
		FindKClosetElement1 obj = new FindKClosetElement1();
//		System.out.println(obj.findClosestElements1(new int[] {1 ,2,3,4,5,6,7}, 3, 4));
//		System.out.println(obj.findClosestElements1(new int[] {1 ,2,3,4,5,6,7}, 3, -2));
		System.out.println(obj.findClosestElements1(new int[] {1 ,2,3,4,5,6,7}, 3, 9));
//		System.out.println(obj.findClosestElements1(new int[] {1 ,3}, 1, 2));
//		
//		System.out.println(obj.findClosestElements1(new int[] {1,10,15,25,35,45,50,59}, 1, 30));

		System.out.println(obj.findClosestElements1(new int[] {1,5,10}, 1, 4));



	}
}
