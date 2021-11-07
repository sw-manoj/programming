package com.samples.sort.cyclicsort;
//https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/tree/main/lectures/11-sorting/code/src/com/kunal

//https://leetcode.com/problems/set-mismatch/submissions/
public class FindErrorNums {

	public int[] findErrorNums(int[] nums) {
        int[] res = {-1,-1};
        
        int i = 0 ;
         while(i < nums.length)
         {
        	 int correct = nums[i]-1;
        	 if(nums[i] != nums[correct])
        	 {
        		 CyclicSort.swap(nums, i, correct);
        	 }else
        	 {
        		 i++;
        	 }
         }
         
         for(int j = 0 ; j < nums.length ; j++)
         {
        	 if(nums[j]-1 != j)
        	 {
        		 res[0] = nums[j];
        		 res[1] = j+1;
        		 return res;
        	 }
         }
        return res;
		
    }
}
