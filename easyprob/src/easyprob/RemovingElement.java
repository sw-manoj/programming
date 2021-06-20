package easyprob;

public class RemovingElement {

	public static void main(String[] args) {
		RemovingElement rem = new RemovingElement();
		System.out.println(rem.removeElement(new int[] {0, 1,2,2,3,3, 2}, 2));
		System.out.println(rem.removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
	}
	public int removeElement(int[] nums, int val) {
        int pos = 0;
        
        for(int i = 0 ; i < nums.length ;i++)
        {
        	if(nums[i] != val)
        	{
        		nums[pos] = nums[i];
        		pos++;
        	}
        }
        return pos;
    }

}
