package com.samples.binarytree;

import java.util.Arrays;

public class SearchRange {


	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 6, 8, 8};
		SearchRange sr = new SearchRange();
		sr.searchRange(nums, 7);
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
