package com.samples.list;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwoArray {

	public int[] twoSum(int[] nums, int target) {
		 if(nums.length == 0) return new int[2];
	        int[] result = new int[2];
	        Map<Integer, Integer> cache = new HashMap();
	        
	        for(int i = 0; i < nums.length; i++){
	            int num = nums[i];
	            if(cache.containsKey(num)){
	                result[0] = cache.get(num);
	                result[1] = i;
	                break;
	            }
	            cache.put(target - num, i);
	        }
	        return result;
    }
}
