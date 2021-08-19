package easy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

//Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
//
//Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
public class TwoSumII {

	
	//two pointers because the input is sorted
		public int[] twoSum3(int[] numbers, int target) {
	        int result[] = {-1, -1};
	        
	        
	        int l = 0;
	        int h = numbers.length-1;
	        
	        while(l < h)
	        {
	        	int tar = numbers[l] + numbers[h];
	        	if(tar == target)
	        	{
	        		result[0] = l+1;
	        		result[1] = h+1;
	        		return result;
	        	}else if (tar < target)
	        	{
	        		l++;
	        	}else
	        	{
	        		h--;
	        	}
	        }
	        
	        return result;
		}
		
		
		//less optmised
	public int[] twoSum(int[] numbers, int target) {
        int result[] = {-1, -1};
        
        for(int i = 0 ; i < numbers.length; i++)
        {
        	if(numbers[i] > target)
        	{
        		continue;
        	}
        	int first = target - numbers[i];
        	
        	for(int j = i+1; j < numbers.length;j++)
        	{
        		if(first == numbers[j])
        		{
        			result[0] =  i+1;
        			result[1] = j+1;
        			return result;
        		}
        	}
        }
        return result;
    }
	
	
	//extra space
	public int[] twoSum2(int[] numbers, int target) {
        int result[] = {-1, -1};
        Map<Integer,Integer> map  = new HashMap<>();
        
        for(int i = 0 ; i < numbers.length; i++)
        {
        	int tar = target - numbers[i];
        	
        	if(map.containsKey(tar))
        	{
        		result[0] = i+1;
        		result[1] = map.get(tar)+1;
        		return result;
        	}
        	
        	map.put(numbers[i], i);
        }
        
        
        return result;
	}
	
	
	
	
	public static void main(String[] args) {
		TwoSumII obj = new TwoSumII();
		print(obj.twoSum(new int[] {2,7,11,15}, 9));

		print(obj.twoSum3(new int[] {2,7,11,15}, 9));
		print(obj.twoSum(new int[] {2,3,4}, 6));

		print(obj.twoSum3(new int[] {2,3,4}, 6));
	}
	
	static void print(int[] res)
	{
		System.out.println(res[0] + "==" + res[1]);
	}
}
