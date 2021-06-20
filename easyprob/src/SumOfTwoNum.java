
public class SumOfTwoNum {

	public static void main(String[] args) {
		
	}
	public int[] twoSum(int[] nums, int target) {
        int[] result = {-1,-1};
        for(int i = 0; i < nums.length ; i++)
        {
            int x = nums[i];
            int y = target - x;
            int flag = 0;
            for(int j = i+1 ; j < nums.length ; j++)
            {
                if(nums[j] == y)
                {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        
        }
        return result;
    }
}
