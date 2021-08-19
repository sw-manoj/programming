package medium.prefixsum;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contiguous-array/submissions/
public class ContigousArray {

	public int findMaxLength(int[] nums) {
		int maxLen = 0;
		Map<Integer, Integer> cache = new HashMap<>();
		
		cache.put(0, -1); // 0 indicates there is equal num of 0 & 1's updato i so i - (-1) will be the length of sub array.
		int count = 0;
//		if we reach the same count again saved in map , that means there is same num of 0& 1's between previous count's (e.g -2) instance index and current i reached.
		// lets say reach -2 is reached 1st at index 3, there has to be 1, 1, 0, 0  to reach -2 again at index 7. 7-3 = 4 gives the length.
		
		for(int i = 0; i < nums.length ;i++)
		{
			count += nums[i] == 1 ? 1 : -1;
			
			if(cache.containsKey(count))
			{
				maxLen = Math.max(maxLen, i - cache.get(count));
			}
			else
			{
				cache.put(count, i);
			}
		}
		
		return maxLen;
    }
	
	public static void main(String[] args) {
		ContigousArray obj = new ContigousArray();
		System.out.println(obj.findMaxLength(new int[] {1,0,0,1,0,1,0,0,1,1,0,0,1}));
		System.out.println(obj.findMaxLength(new int[] {0,1,0}));

	}
}
