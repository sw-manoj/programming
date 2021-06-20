package easyprob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class FindDisappearedNumbers {
	
	public static void main(String[] args) {
		FindDisappearedNumbers obj = new FindDisappearedNumbers();
		System.out.println(obj.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
		System.out.println(obj.findDisappearedNumbers(new int[] {1,1}));

	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++ )
        {
        	int numIndex = Math.abs(nums[i]) - 1;
        	
        	if(nums[numIndex] > 0)
        	{
        		nums[numIndex] *= -1;
        	}
        }
        
        for(int i = 0 ; i < nums.length ;i ++)
        {
        	if(nums[i] > 0)
        	{
        		res.add(i + 1);
        	}
        }
        
        
        return res;
    }
	
public List<Integer> findDisappearedNumbers1(int[] nums) {
        
        // Hash table for keeping track of the numbers in the array
        // Note that we can also use a set here since we are not 
        // really concerned with the frequency of numbers.
        HashMap<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();
        
        // Add each of the numbers to the hash table
        for (int i = 0; i < nums.length; i++) {
            hashTable.put(nums[i], true);
        }
        
        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();
        
        // Iterate over the numbers from 1 to N and add all those
        // that don't appear in the hash table. 
        for (int i = 1; i <= nums.length; i++) {
            if (!hashTable.containsKey(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}
