package easyprob;

import java.util.Arrays;

public class MajorityNumber {

//	https://leetcode.com/problems/majority-element/solution/
	
public int majorityElement1(int[] nums) {
	Arrays.sort(nums);
    return nums[nums.length/2];
}

public static void main(String[] args) {
	MajorityNumber ob = new MajorityNumber();
	System.out.println(ob.majorityElement(new int[] {2,2,3,1,2,4}));
}

//Boyer-Moore Voting Algorithm
public int majorityElement(int[] nums) {
    int count = 0;
    Integer candidate = null;

    for (int num : nums) {
        if (count == 0) {
            candidate = num;
        }
        count += (num == candidate) ? 1 : -1;
    }

    return candidate;
}
}
