package Medium;

public class NonDecreasingArray {
	
	public static void main(String[] args) {
		NonDecreasingArray obj = new NonDecreasingArray();
		System.out.println(obj.checkPossibility(new int [] {4,2,3}));
		System.out.println(obj.checkPossibility(new int [] {4,2,1}));

		System.out.println(obj.checkPossibility(new int [] {3,4,2,3}));
		System.out.println(obj.checkPossibility(new int [] {3,4,3,3}));

	}

	public boolean checkPossibility(int[] nums) {
       
		int numViolations = 0;
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i - 1] > nums[i]) {
                
                if (numViolations == 1) {
                    return false;
                }
                
                numViolations++;
                
                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        
        return true;
    }
}
