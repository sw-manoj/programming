package Medium;

public class NextPermutation {
	
//	https://leetcode.com/problems/next-permutation/submissions/
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] myArray = {10, 20, 30, 40};
		int[] nums = {1,4,2,3,5,1};
		
		np.nextPermutation(nums);
		
		for(int i : nums)
		{
			System.out.print(i);
		}
	}

	public void nextPermutation(int[] nums) {
        
		int i = nums.length - 2;
		
		while(i >= 0 && nums[i] >= nums[i+1])
		{
			i--;
		}
		
		if(i >= 0)
		{
			int j = nums.length-1;
			while(nums[j] <= nums[i])
			{
				j--;
			}
			swap(nums, i ,j );
		}
		reverse(nums, i + 1);
    }
	
	private void reverse(int[] nums, int start)
	{
		int end = nums.length-1;
		
		while(start < end)
		{
			swap(nums,start, end);
			start++;
			end--;
		}
	}
	
	private void swap(int[] nums,int i,int j)
	{
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
