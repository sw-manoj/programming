package com.samples.list.twopointers;

public class SquareOfSortedArray {

	public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        
        int start = 0 ;
        int end = nums.length-1;
        int index = nums.length-1;
        while(start <= end)
        {
        	int square;
            if (Math.abs(nums[start]) < Math.abs(nums[end])) {
                square = nums[end];
                end--;
            } else {
                square = nums[start];
                start++;
            }
            res[index] = square * square;
            index--;
        }
        
        return res;
    }
	
	private int pow(int n)
	{
		return (int) Math.pow(n, 2);
	}
	
	public static void main(String[] args) {
		SquareOfSortedArray obj = new SquareOfSortedArray();
		int[] res = obj.sortedSquares(new int[] {-4,-2,0,1,3,6});
		
			for(int n : res)
			{
				System.out.print(n + " ");
			}
			System.out.println();
			
			res = obj.sortedSquares(new int[] {-7,-3,2,3,11});
			
			for(int n : res)
			{
				System.out.print(n + " ");
			}
			System.out.println();
		}
}
