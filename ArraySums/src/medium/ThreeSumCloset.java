package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class ThreeSumCloset {

	
	public int threeSumClosest(int[] nums, int target) {
//			Set<List<Integer>> result = new TreeSet<>((o1,o2) -> );
		Arrays.sort(nums);
    	int min = Integer.MAX_VALUE;
    	int minSum = 0;
    	for(int i = 0 ; i < nums.length ; i++)
    	{
    		int n = nums[i];
        	int l = i+1;
        	int r = nums.length-1;
        	
        	while(l < r)
        	{
        		int sum = n + nums[l] + nums[r];
        		
        		if(Math.abs(target-sum) < Math.abs(min))
        		{
        			min = Math.abs(target-sum);
        			minSum = sum;
        			System.out.println((target-sum) + "==" + n + nums[l] + nums[r]);
        		}
        		if(sum > target)
        		{
        			r--;
        		}
        		else
        		{
        			l++;
        		}
        	}
    	}
    	return minSum;
    }
	
	public static void main(String[] args) {
		ThreeSumCloset obj = new ThreeSumCloset();
		System.out.println(obj.threeSumClosest(new int[] {-1,2,1,-4}, 1));
		System.out.println(obj.threeSumClosest(new int[] {-0,0,0}, 0));
		
		System.out.println(obj.threeSumClosest(new int[] {-3,-1,2,1,-4}, 1));


	}
}
