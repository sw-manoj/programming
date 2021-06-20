package Medium;

public class SearchInRotatedSortArr {
	
	public static void main(String[] args) {
		SearchInRotatedSortArr srArr = new SearchInRotatedSortArr();
		
		System.out.println(srArr.search(new int[] {4, 5,6,7,1,2,3} , 2));
		
		System.out.println(srArr.search(new int[] {6,7,1,2,3, 4,5} , 1));

		System.out.println(srArr.search_lessopt(new int[] {4, 5,6,7,1,2,3}, 2 ));

		System.out.println(srArr.findRotateIndex(new int[] {6,7,1,2,3, 4,5} ));
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
