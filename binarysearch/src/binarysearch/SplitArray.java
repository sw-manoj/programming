 package binarysearch;

// https://leetcode.com/problems/split-array-largest-sum/
 
 
// Time complexity: O(n * log(sum of array))O(n∗log(sumofarray)). 
// The binary search costs O(log(sum of array))O(log(sumofarray)), where sum of array is the sum of elements in nums. 
// For each computation of F(x), the time complexity is O(n)O(n) since we only need to go through the whole array.
 
public class SplitArray {
	
	public int splitArray(int[] nums, int m) {
        long l = 0;
        long r = 0;        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            r += nums[i];
            if (l < nums[i]) {
                l = nums[i];
            }
        }
        long ans = l;
        while (l <= r) {
            long mid = (l + r) >> 1;
            long sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    cnt ++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            
			System.out.println(l + "==" + mid + "==" + r + "==" + cnt);

            if (cnt <= m) {
                ans = Math.max(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;      
    }

	public int splitArray1(int[] nums, int m) {
        
		int start =0;
		int end = 0;
		
		int ans = Integer.MAX_VALUE;
		
		
		for(int num : nums)
		{
			start = Math.max(start, num);
			end += num;
		}
		
//		System.out.println(start + "=="  + "==" + end);

		while(start < end)
		{
			int pieces = 1;
			int sum = 0;
			int mid = start + (end-start)/2;
			
			for(int num : nums)
			{
				if(sum + num <= mid)
				{
					sum += num;
				}
				else
				{
					pieces ++;
					sum = num;
				}
			}
			System.out.println(start + "==" + mid + "==" + end + "==" + pieces);

			if(pieces <= m)
			{
				// when start and end are consecutive numbers, mid always becomes start like 16,17 makes mid = 16, so atleast incrementing start to get out of loop
				// so initial while loop check only for < and not <=
				end = mid;//reducing the mid to check for a lower sum subarray to increase the number of pieces.
			}
			else
			{
				start = mid  + 1;//increasing the mid to check for a larger sum subarray to decrease the number of pieces.
			}
			
		}
		return end;//Or start.   since here end == start.
    }
	
	public static void main(String[] args) {
		SplitArray obj = new SplitArray();
		System.out.println(obj.splitArray(new int[] {7,2,5,10,8}, 2));
		System.out.println(obj.splitArray(new int[] {1,4,4}, 3));
		
		System.out.println(obj.splitArray(new int[] {1,2,3,4,5}, 2));

		System.out.println(obj.splitArray(new int[] {5,8,9,2,1}, 2));

	}
}
