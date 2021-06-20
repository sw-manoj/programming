package Medium;

public class ProductArrayExceptSelf {
	
//	https://leetcode.com/problems/product-of-array-except-self/
	public static void main(String[] args) {
		int[] nums= {1,2,3,4};
		doaction(new int[]{1,2,3,4});
		doaction(new int[]{4,5,1,8,2});
	}
	
	static void doaction(int[] nums)
	{
		ProductArrayExceptSelf prodArr = new ProductArrayExceptSelf();
		
		int[] output = prodArr.productExceptSelf(nums);
		
		for(int o : output)
		{
			System.out.print(o + " ");
		}
		System.out.println();
	}

	public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        
        for(int i= 1; i < nums.length; i++)
        {
        	output[i] = output[i-1] * nums[i-1];
        }
        
        int rev = 1;
        for(int i = nums.length-1; i >= 0 ; i--)
        {
        	output[i] = output[i] * rev;
        	rev = rev * nums[i];
        }
        
        return output;
    }
}
