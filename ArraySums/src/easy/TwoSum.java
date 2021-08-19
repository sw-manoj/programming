package easy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

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
        			result[0] =  i;
        			result[1] = j;
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
        		result[0] = i;
        		result[1] = map.get(tar);
        		return result;
        	}
        	
        	map.put(numbers[i], i);
        }
        
        
        return result;
	}
	
	public static void main(String[] args) {
		TwoSum obj = new TwoSum();
		print(obj.twoSum(new int[] {2,7,11,15}, 9));

		print(obj.twoSum2(new int[] {2,7,11,15}, 9));
	}
	
	static void print(int[] res)
	{
		System.out.println(res[0] + "==" + res[1]);
	}
	
}
