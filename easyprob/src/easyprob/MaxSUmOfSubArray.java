package easyprob;

public class MaxSUmOfSubArray {

	public static void main(String[] args) {
		MaxSUmOfSubArray subArr = new MaxSUmOfSubArray();
		System.out.println(subArr.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5}));
	}
	
	public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
        {
        	max = Math.max(nums[i], (nums[i] + max));
        	currSum = Math.max(max, currSum);
        }
        
        return currSum;
    }

}
