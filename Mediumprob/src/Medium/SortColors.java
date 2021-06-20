package Medium;

public class SortColors {

//	https://leetcode.com/problems/sort-colors/solution/
	
//	Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//	We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//	You must solve this problem without using the library's sort function.


	public static void main(String[] args) {
		SortColors sc  = new SortColors();
		int[] nums = {2,1,0,0,2,1};
		
		sc.sortColors(nums);
		
		
		for(int num : nums)
		{
			System.out.println(num);
		}
	}
	public void sortColors(int[] nums) {
       int p0 = 0 ; 
       int p2 = nums.length-1;
       int curr = 0;
       
       while(curr <= p2)
       {
    	   if(nums[curr] == 0)
    	   {
    		   int tmp = nums[curr];
    		   nums[curr++] = nums[p0];
    		   nums[p0++] = tmp;
    		   
    	   }else if(nums[curr] == 2)
    	   {
    		   int tmp = nums[p2];
    		   nums[p2--] = nums[curr];
    		   nums[curr] = tmp;
    	   }else {
    		   curr++;
    	   }
       }
    }
}
