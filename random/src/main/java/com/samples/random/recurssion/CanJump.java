package com.samples.random.recurssion;

import java.util.HashMap;
import java.util.Map;

public class CanJump {
	
	public static void main(String[] args) {
		CanJump c = new CanJump();
		System.out.println(c.greedyApp(new int[] {2,3,1,1,4}));
		System.out.println(c.greedyApp(new int[] {3,2,1,0,4}));
		System.out.println(c.greedyApp(new int[] {2,1,0,0}));
		System.out.println(c.canJump(new int[] {2,3,1,1,4}));
		System.out.println(c.canJump(new int[] {3,2,1,0,4}));
		System.out.println(c.canJump(new int[] {2,1,0,0}));
	}
	
	private boolean greedyApp(int[] nums)
	{
		int[] memGreedy = new int[nums.length];
		memGreedy[nums.length - 1] = 1;
		int lastSuccPos = nums.length - 1;
		for(int i = nums.length - 2 ; i >= 0; i--)
		{
			int nextPos = Math.min(i + nums[i], lastSuccPos);
			if(memGreedy[nextPos] == 1)
			{
				lastSuccPos = i;
				memGreedy[i] = 1;
				continue;
			}
		}
		return memGreedy[0] == 1;
			
	}
	Map<Integer,Boolean> state = new HashMap<Integer,Boolean>();
public boolean canJump(int[] nums) {
     
	if(nums.length == 0)
	{
		return false;
	}
	return helper(nums, 0);
    }

private boolean helper(int[] num , int pos)
{
	if(pos >= num.length)
	{
		return false;
	}
	else if(pos == num.length - 1)
	{
		return true;
	}
	if(state.containsKey(pos))
	{
		return state.get(pos);
	}

	
	int furthestJump = Math.min(pos + num[pos], num.length - 1);
	for( int i = pos + 1 ; i <= furthestJump;i++ )
	{
		if(helper(num,  i ))
		{
			state.put( i, true);
			return true;
		}
		
	}
	state.put(pos, false);
	return false;
}

}
