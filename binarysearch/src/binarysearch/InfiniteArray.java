package binarysearch;
//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class InfiniteArray {

	public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 10;
        
        InfiniteArray obj = new InfiniteArray();
        System.out.println(obj.searchInfiniteArray(arr, target));
    }
	
     int searchInfiniteArray(int[] arr, int target) {
    	int start = 0;
    	int end = 1;
    	
    	while(end < arr.length)
    	{
    		if(arr[end] >= target)
    		{
    			return binarySearch(arr, target, start, end);
    		}
    		int tmp = start;
    		start = end + 1;
    		end = start + ((end - tmp ) * 2);
    		end = end < arr.length ? end : arr.length-1;
    	}
    	return -1;
    }
    
    int binarySearch(int[] arr, int target,int start , int end) {
		
		
		while(start <= end)
		{
			int mid = start + (end-start)/2;
			
			if(arr[mid] == target)
			{
				return mid;
			}else if(arr[mid] < target)
			{
				start = mid+1;
			}
			else
			{
				end = mid-1;
			}
		}
		return -1;
	}
	
}
