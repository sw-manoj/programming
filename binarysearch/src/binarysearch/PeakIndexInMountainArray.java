package binarysearch;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/
//https://leetcode.com/problems/find-peak-element/
public class PeakIndexInMountainArray {
	
	public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                // you are in dec part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
        return start; // or return end as both are =
    }

	public int peakIndexInMountainArray1(int[] arr)
	{
		
		int start = 0 ; 
		int end = arr.length-1;
		
		while(start <= end)
		{
			
			int mid = start + (end - start)/2;
//			System.out.println(start + "==" + mid + "==" + end);
			if(mid-1 >= 0 &&  arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1] && mid+1 < arr.length)
			{
				return mid;
			}
			else if(arr[mid] > arr[mid+1])
			{
				end = mid-1;
			}else
			{
				start = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		PeakIndexInMountainArray obj = new PeakIndexInMountainArray();
		System.out.println(obj.peakIndexInMountainArray(new int [] {3,5,3,2,0}));
		System.out.println(obj.peakIndexInMountainArray(new int [] {3,5,6,7,1}));

		System.out.println(obj.peakIndexInMountainArray(new int [] {1,2,1,3,5,6,4}));

		System.out.println(obj.peakIndexInMountainArray(new int [] {0,2,1,0}));
		System.out.println(obj.peakIndexInMountainArray(new int [] {0,10,5,2}));
		System.out.println(obj.peakIndexInMountainArray(new int [] {3,4,5,1}));

		System.out.println(obj.peakIndexInMountainArray(new int [] {12,24,69,100,99,79,78,67,36,26,19}));


	}
}
