package binarysearch;

public class OrderAgnosticBS {
	
	
	public static void main(String[] args) {
//      int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
      int[] arr = {99, 80, 75, 22, 11, 10, 5, 2, -3};
      int target = 22;
      System.out.println(orderAgnosticBS(arr, target));
      
      System.out.println(orderAgnosticBS(new int[] {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89}, target));

  }

	
    static int orderAgnosticBS(int[] arr, int target) {
    	
    	int start = 0;
    	int end = arr.length-1;
    	boolean isAsc = arr[start] < arr[end];
    	
    	while(start <= end)
    	{
    		int mid = start + (end -start )/2;
    		
    		if(arr[mid] == target)
    		{
    			return mid;
    		}
    		
    		if(isAsc)
    		{
    			if(arr[mid] < target)
    			{
    				start = mid+1;
    			}else
    			{
    				end = mid-1;
    			}
    		}
    		else
    		{
    			if(arr[mid] > target)
    			{
    				start = mid+1;
    			}else
    			{
    				end = mid-1;
    			}
    		}
    			
    	}
    	
    	return -1;

    }

}
