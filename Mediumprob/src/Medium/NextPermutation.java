package Medium;

public class NextPermutation {
	
//	https://leetcode.com/problems/next-permutation/submissions/
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] myArray = {10, 20, 30, 40};
//		int[] nums = {1,4,2,3,5,1};
		int[] nums= {1,5,1};
		
		
		np.nextPermutation_2ndtry(nums);
		
		for(int i : nums)
		{
			System.out.print(i);
		}
	}
	
	public void nextPermutation_2ndtry(int[] nums) {
		
		int n = nums.length-1;
		
		while(n > 0 && nums[n] <= nums[n-1])
		{
			n--;
		}
		n--;
		if(n >= 0)
		{
		for(int i = nums.length-1; i >= 0 ; i--)
		{
			if(nums[i] > nums[n])
			{
				int tmp = nums[i];
				nums[i] = nums[n];
				nums[n] = tmp;
				break;
			}
		}
		}
		reverse(nums, n+1, nums.length-1);
		
	}
	
	private void reverse(int[] nums, int l , int r)
	{
		while(l < r)
		{
			int tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;
			l++;
			r--;
		}
	}

	public void nextPermutation(int[] nums) {
        
		int i = nums.length - 2;
		
		//find small adj num from last. and make note of that index
		while(i >= 0 && nums[i] >= nums[i+1])
		{
			i--;
		}
		System.out.println(i);
		if(i >= 0)
		{
			int j = nums.length-1;
			//move from last until we find num greater than the index foudn above
			while(nums[j] <= nums[i])
			{
				j--;
			}
//			once found swap it
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
