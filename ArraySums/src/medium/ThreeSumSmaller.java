package medium;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-smaller/
public class ThreeSumSmaller {
	
	public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length ; i++)
    	{
    		int n = nums[i];
        	int l = i+1;
        	int r = nums.length-1;
        	
        	while(l < r)
        	{
        		int sum = n + nums[l] + nums[r];
        		
        		if(sum < target)
        		{
        			ans+= r-l;
        			l++;
        		}
        		else
        		{
        			r--;
        		}
        	}
    	}
        return ans;
		
    }
	
	
	
	public static void main(String[] args) {
		ThreeSumSmaller obj = new ThreeSumSmaller();
		System.out.println(obj.threeSumSmaller(new int[] {-2,0,1,3}, 2));
		
		System.out.println(obj.threeSumSmaller(new int[] {-4,-3,-2,0,3,2}, 2));

	}

}
