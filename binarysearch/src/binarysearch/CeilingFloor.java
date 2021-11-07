package binarysearch;

public class CeilingFloor {

	int ceilingSearch(int[] arr, int target) {
		int start = 0 ; 
		int end = arr.length-1;
		// but what if the target is greater than the greatest number in the array
        if (target > arr[arr.length - 1]) {
            return -1;
        }
		while(start <= end)
		{
			int mid = start + (end -start)/2;
			if(arr[mid] == target)
			{
				return mid;
			}
			if(arr[mid] < target)
			{
				start = mid + 1;
			}else {
				end = mid-1;
			}
		}
		
		return start;
	}

	int floorSearch(int[] arr, int target) {
		int start = 0 ; 
		int end = arr.length-1;
		
		while(start <= end)
		{
			int mid = start + (end -start)/2;
			if(arr[mid] == target)
			{
				return mid;
			}
			if(arr[mid] < target)
			{
				start = mid + 1;
			}else {
				end = mid-1;
			}
		}
		
		return end;
	}

	public static void main(String[] args) {
		CeilingFloor obj = new CeilingFloor();
		System.out.println(obj.ceilingSearch(new int[] {2,4,5,6,8}, 5));
		System.out.println(obj.ceilingSearch(new int[] {1,2,4,5,6,8}, 7));
		System.out.println(obj.ceilingSearch(new int[] {2,4,5,6,8}, 1));
		System.out.println(obj.ceilingSearch(new int[] {2,4,5,6,8}, 3));
		System.out.println(obj.ceilingSearch(new int[] {1,2,4,5,6,8}, 9));
		
		System.out.println("=====");
		System.out.println(obj.floorSearch(new int[] {2,4,5,6,8}, 5));
		System.out.println(obj.floorSearch(new int[] {1,2,4,5,6,8}, 7));
		System.out.println(obj.floorSearch(new int[] {2,4,5,6,8}, 1));
		System.out.println(obj.floorSearch(new int[] {2,4,5,6,8}, 3));
		System.out.println(obj.floorSearch(new int[] {1,2,4,5,6,8}, 9));


	}
}
