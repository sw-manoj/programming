package easyprob;

public class SortedRemDup {

	public static void main(String[] args) {
		SortedRemDup duplicates = new SortedRemDup();
		System.out.println(duplicates.removeDuplicates(new int[] {0,0,1,1,2}));
		System.out.println(duplicates.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
		System.out.println(duplicates.removeDuplicates(new int[] {1,1,2}));
		System.out.println(duplicates.removeDuplicates(new int[] {-1,1,1,2}));

	}
	public int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0;
        int lastVal = nums[0];
        int lastPos = 1;
        
        for(int i = 1 ; i < nums.length ; i++)
        {
        	
        	if(lastVal != nums[i])
        	{
        		lastVal = nums[i];
        		nums[lastPos] = nums[i] ;
        		lastPos++;
        		
        	}
        }
        return lastPos;
    }
}
