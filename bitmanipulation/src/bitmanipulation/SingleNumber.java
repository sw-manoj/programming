package bitmanipulation;

public class SingleNumber {
	
//	https://leetcode.com/problems/single-number-ii/solution/

	public int singleNumber(int[] nums) {
	    int seenOnce = 0, seenTwice = 0;

	    for (int num : nums) {
	      // first appearence: 
	      // add num to seen_once 
	      // don't add to seen_twice because of presence in seen_once

	      // second appearance: 
	      // remove num from seen_once 
	      // add num to seen_twice

	      // third appearance: 
	      // don't add to seen_once because of presence in seen_twice
	      // remove num from seen_twice
	      seenOnce = ~seenTwice & (seenOnce ^ num);
	      seenTwice = ~seenOnce & (seenTwice ^ num);
	      
	      
	      System.out.println(num + "===" + seenOnce + "===" + seenTwice);
	    }

	    return seenOnce;
	  }
	
	public static void main(String[] args) {
		SingleNumber obj = new SingleNumber();
		System.out.println(obj.singleNumber(new int[] {2,3,2,2}));
	}
}
