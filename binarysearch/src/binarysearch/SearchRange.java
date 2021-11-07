package binarysearch;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class SearchRange {


	public static void main(String[] args) {
		int[] nums = {5, 7, 7,7,7, 8};
		SearchRange sr = new SearchRange();
		sr.searchRange(nums, 7);
		
		sr.searchRange1(nums, 7);
	}
	 public int[] searchRange1(int[] nums, int target) {
		 
		 int start = binarySearch(nums, target, true);
		 if(start == -1)
		 {
			 return new int[]{-1,-1};
		 }
		 int end = binarySearch(nums, target, false);
		 return new int[]{start,end};
	 }
	 
	 int binarySearch(int[] arr, int target,boolean  findStart) {
			
			int start = 0;
			int end = arr.length-1;
			int ans = -1;
			
			while(start <= end)
			{
				int mid = start + (end-start)/2;
				
				if(arr[mid] == target)
				{
					if(findStart)
					{
						end = mid -1;
					}
					else
					{
						start = mid+1;
					}
					ans = mid;

//					return mid;
				}else if(arr[mid] < target)
				{
					start = mid+1;
				}
				else
				{
					end = mid-1;
				}
			}
			return ans;
		}
	 
	 public int[] searchRange(int[] nums, int target) {
	       int n = nums.length;
	        if(n == 0) return new int[]{-1,-1};
	        if(n == 1) return nums[0]==target?new int[]{0,0}:new int[]{-1,-1};
	        int lo = 0;
	        int hi = n-1;
	        while(lo<=hi){
	            int mid = (lo+hi)/2;
	            if(nums[mid] == target){
	                int i = mid;
	                int j = mid;
	                while(i >= lo+1 && nums[--i]==target){if(i == lo) break;}
	                while(j <= hi-1 && nums[++j] == target){if(j == hi) break;}
	                i = nums[i]==target?i:i+1;
	                j = nums[j]==target?j:j-1;
	                return new int[]{i,j};
	            }
	            if(nums[mid] < target){
	                lo = mid+1;
	            }else{
	                hi = mid -1;
	            }
	        }
	        return new int[]{-1,-1};
	    }
}
