package binarysearch;

public class BinarySearch {

	int binarySearch(int[] arr, int target) {
		
		int start = 0;
		int end = arr.length-1;
		
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
	
	public static void main(String[] args) {
		BinarySearch obj = new BinarySearch();
		System.out.println(obj.binarySearch(new int[] {2,4,5,6,8}, 5));
		System.out.println(obj.binarySearch(new int[] {1,2,4,5,6,8}, 8));
		System.out.println(obj.binarySearch(new int[] {2,4,5,6,8}, 2));


	}
}
