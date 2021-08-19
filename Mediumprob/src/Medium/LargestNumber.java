package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	
//	https://leetcode.com/problems/largest-number/solution/
	
	public static void main(String[] args) {
		LargestNumber obj = new LargestNumber();
		System.out.println(obj.largestNumber(new int[] {3,30,34,5,9}));
		
		System.out.println(obj.compare("30", "3"));
		
	    StringBuilder fraction = new StringBuilder();

//	    fraction.ins
	}
	
	private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
	
	public String largestNumber1(int[] nums) {
		sort(nums, 0, nums.length-1);
		
		String s= "";
		for(int n : nums)
		{
			s+=n;
		}
		return s;
    }

	// Merges two subarrays of arr[]. 
		// First subarray is arr[l..m] 
		// Second subarray is arr[m+1..r] 
		void merge(int arr[], int l, int m, int r) 
		{ 
			// Find sizes of two subarrays to be merged 
			int n1 = m - l + 1; 
			int n2 = r - m; 

			/* Create temp arrays */
			int L[] = new int [n1]; 
			int R[] = new int [n2]; 
			
			List<Integer> left = new ArrayList<Integer>();
			List<Integer> right = new ArrayList<Integer>();

			/*Copy data to temp arrays*/
			for (int i=l; i<=m; ++i) 
				left.add(arr[i]); 
			for (int j=m+1; j<=r; ++j) 
				right.add(arr[j]); 


			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays 
			int i = 0, j = 0; 

			// Initial index of merged subarry array 
			int k = l; 
			while (i < left.size() && j < right.size()) 
			{ 
				if (compare(String.valueOf(left.get(i)),String.valueOf(right.get(j)))) 
				{ 
					arr[k] = left.get(i); 
					i++; 
				} 
				else
				{ 
					arr[k] = right.get(j); 
					j++; 
				} 
				k++; 
			} 

			/* Copy remaining elements of L[] if any */
			while (i < left.size()) 
			{ 
				arr[k] = left.get(i); 
				i++; 
				k++; 
			} 

			/* Copy remaining elements of R[] if any */
			while (j < right.size()) 
			{ 
				arr[k] = right.get(j); 
				j++; 
				k++; 
			} 
		} 

		// Main function that sorts arr[l..r] using 
		// merge() 
		void sort(int arr[], int l, int r) 
		{ 
			if (l < r) 
			{ 
				// Find the middle point 
				int m = (l+r)/2; 

				// Sort first and second halves 
				sort(arr, l, m); 
				sort(arr , m+1, r); 

				System.out.println(l + "==" + m + "==" + r);
				// Merge the sorted halves 
				merge(arr, l, m, r); 
			} 
		} 
	
	public boolean compare(String a , String b)
	{
		int i = 0;
		int j = 0;
		while( (i <  a.length() || j <= b.length()) )
		{
			int l = i > a.length()-1 ? a.length()-1 : i;
			int r = j > b.length()-1 ? b.length()-1 : j;
			if(a.charAt(l) == b.charAt(r))
			{
				i++;
				j++;

				continue;
			}
			return a.charAt(l) > b.charAt(r);
		}
		return a.length() > b.length();
	}
}
