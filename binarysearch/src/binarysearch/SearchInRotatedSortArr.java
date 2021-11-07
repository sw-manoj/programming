
package binarysearch;

public class SearchInRotatedSortArr {
	
	public static void main(String[] args) {
		SearchInRotatedSortArr srArr = new SearchInRotatedSortArr();
		
//		System.out.println(srArr.search(new int[] {4, 5,6,7,1,2,3} , 2));
//		
//		System.out.println(srArr.search(new int[] {6,7,1,2,3, 4,5} , 1));
//
//		System.out.println(srArr.search_2ndtry(new int[] {4, 5,6,7,1,2,3} , 2));
//
//		System.out.println(srArr.search_2ndtry(new int[] {4,5,6,7,0,1,2} , 0));
//
//		System.out.println(srArr.search_lessopt(new int[] {4, 5,6,7,1,2,3}, 2 ));
//
//		System.out.println(srArr.findRotateIndex(new int[] {6,7,1,2,3, 4,5} ));
		
		System.out.println(srArr.findRotateIndex1(new int[] {6,7,1,1,2,2,3, 4,5} ));
		
//		System.out.println(srArr.search1(new int[] {4, 5,6,7,1,2,3} , 2));
//		
//		System.out.println(srArr.search1(new int[] {6,7,1,2,3, 4,5} , 1));
//		System.out.println(srArr.search1(new int[] {1} , 0));


	}
	
    static int search1(int[] nums, int target) {
    	
    	int pivot = findRotateIndex1(nums);
    	int n = nums.length-1;
    	if(pivot == -1)
    	{
    		return binarySearch(nums, target, 0, n);
    	}
    	System.out.println("pivot" + pivot);
    	if(nums[pivot] == target)
    	{
    		return pivot;
    	}
    	
    	if(nums[pivot+1] <= target && target <= nums[n])
    	{
    		return binarySearch(nums, target, pivot+1, n);
    	}
    	return binarySearch(nums, target, 0, pivot);
    }
    
    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
	
	static int findRotateIndex1(int nums[])
	{
		int start = 0;
		int end = nums.length -1;
		
		if(nums[start] < nums[end])
		{
			return 0;
		}
		
		while(start <= end)
		{
			int mid = start + (end-start)/2;
//			System.out.println(start + "==" + mid  + "==" + end);
			if(mid < end && nums[mid] > nums[mid+1] )
			{
				return mid;
			}
			if(mid > start && nums[mid] < nums[mid-1])
			{
				return mid-1;
			}
			
			if(nums[mid] < nums[end])
			{
				end = mid-1;
			}else
			{
				start = mid+1;
			}
		}
		return -1;
	}
	
	
	public int search_2ndtry(int[] nums, int target) {
		 if(nums.length == 1 && nums[0] == target)
	        {
	        	return 0;
	        }
		 
		 int index = -1;
		 int l = 0; int r = nums.length-1;
		 
		 
		 while(l <= r)
		 {
			 int mid = l + (r-l)/2;
			 if(nums[mid] == target)
        	 {
        		 return mid;
        	 }
			 if(nums[l] <= nums[mid])
			 {
				 if(nums[l] <= target && target < nums[mid])
				 {
					 r = mid-1;
				 }else
				 {
					 l = mid+1;
				 }
			 }else if(target < nums[mid] || target >= nums[l])
			 {
				 r = mid-1;
			 }else
			 {
				 l = mid + 1;
			 }
		 }
		 return index;
    }
	
	

//	https://leetcode.com/problems/search-in-rotated-sorted-array/
	public int search(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target)
        {
        	return 0;
        }
        
        int start = 0;
         int end = nums.length -1;
         
         while(start <= end)
         {
        	 int mid = start + (end-start)/2;
        	 
        	 if(nums[mid] == target)
        	 {
        		 return mid;
        	 }
        	 if(nums[start] <= nums[mid])
        	 {
        		 if(nums[start] <= target && target <= nums[mid]) end = mid-1;
        		 else start = mid+1;
        	 }
        	 else
        	 {
        		 if(nums[mid] <= target && target <= nums[end]) start = mid+1;
        		 else end = mid-1;
        	 }
         }
		
		return 0;
    }
	
	private int search (int nums[], int start, int end, int target)
	{
		while(start <= end)
		{
			int mid = (start+end)/2;
			
			if(nums[mid] == target)
			{
				return mid;
			}
			else {
		        if (target < nums[mid])
		          end = mid - 1;
		        else
		          start = mid + 1;
		      }
		}
		
		return -1;
	}
	
	public int search_lessopt(int[] nums, int target) {
		int n = nums.length;

	    if (n == 1)
	      return nums[0] == target ? 0 : -1;
	    
	    int rotated_index = findRotateIndex(nums);
	    
	 // if target is the smallest element
	    if (nums[rotated_index] == target)
	      return rotated_index;
	    // if array is not rotated, search in the entire array
	    if (rotated_index == 0)
	      return search(nums, 0, n - 1, target);
	    
	    if(nums[0] >  target)
	    	return search(nums, rotated_index, nums.length-1, target);
	    else
	    {
	    	return search(nums, 0, rotated_index, target);
	    }
	    
	}
	public int findRotateIndex(int nums[])
	{
		int start = 0;
		int end = nums.length -1;
		
		if(nums[start] < nums[end])
		{
			return 0;
		}
		
		while(start < end)
		{
			int mid = start + (end-start)/2;
			if(nums[mid] > nums[mid+1])
			{
				return mid+1;
			}
			if(nums[start] <= nums[mid])
			{
				start = mid+1;
			}
			else
			{
				end = mid-1;
			}
			
		}
		return 0;
	}
}
