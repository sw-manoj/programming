package com.samples.dynamicprog.easy;

public class JumpGame {

	public boolean canJump(int[] nums) {
		if(nums.length == 0)
		{
			return false;
		}
	    boolean[] memo = new boolean[nums.length];
		return helper(nums, 0, memo);
    }
	
	public boolean helper(int[] nums, int pos, boolean[] memo)
	{
		if(pos >= nums.length-1)
		{
			return true;
		}
		if(memo[pos]) return true; 
		
		int nextPost = Math.min(nums.length-1, pos + nums[pos]);
		
		for(int i = pos + 1; i < nextPost ; i++)
		{
			if( helper(nums, i, memo))
			{
				memo[pos] = true;
				return true;
						
			}
		}
		return memo[pos];
	}
	
	public static void main(String[] args) {
		JumpGame game = new JumpGame();
		System.out.println(game.canJump(new int[] {2,3,1,1,4} ));
	}
}
