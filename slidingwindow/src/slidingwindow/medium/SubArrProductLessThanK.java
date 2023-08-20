package slidingwindow.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
//https://leetcode.com/problems/subarray-product-less-than-k/
public class SubArrProductLessThanK {

	//prefix sum doesnt work , because product result in number range larger thatn long type.
	
	
//	For those who are confused, let's use the example nums = [10,5,2,6]:
//
//	If we start at the 0th index, [10,5,2,6], the number of intervals is obviously 1.
//	If we move to the 1st index, the window is now [10,5,2,6]. The new intervals created are [5] and [10,5], so we add 2.
//	Now, expand the window to the 2nd index: [10,5,2,6]. The new intervals are [2], [5,2], and [10,5,2], so we add 3.
//	The pattern should be obvious by now; we add right - left + 1 to the output variable every loop!
	
	public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

		int window = 0;
		int count = 0;
		int s = 0 , e = 0;
		int prod = 1;
		while(e < nums.length)
		{
			prod *= nums[e];
			while(s < e && prod >= k )
			{
				prod = prod/nums[s];
				s++;
			}
			if(prod < k)
				count += e - s +1;
			e++;
		}
		
		return count;
		
	}
	public static void main(String[] args) {
		SubArrProductLessThanK obj = new SubArrProductLessThanK();
//		System.out.println(obj.numSubarrayProductLessThanK(new int [] {10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
//		System.out.println(obj.numSubarrayProductLessThanK(new int [] {10,5,2,3}, 100));
		System.out.println(obj.numSubarrayProductLessThanK(new int [] {2,2,60}, 100));

	}
}
