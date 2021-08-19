package medium.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


//https://leetcode.com/problems/sum-of-subarray-minimums/
//https://www.youtube.com/watch?v=vjxBVzVB-mE

public class SumSubArrayMins {

	// this method is simislar to dp approach taken in LongestPalindromicSubSeq class. 
	//Also memory exceeds for this prob
	public int sumSubarrayMins1(int[] arr) {
        long sum = 0;
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n;i++)
        {
        	dp[i][i] = arr[i];
        	sum += arr[i];
        }
        
        for(int i = n-2; i >= 0; i--)
        {
        	for(int j = i+1; j < n ; j++)
        	{
        		dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]);
        		sum+= dp[i][j];
        	}
        }
        
        
        
        return (int) (sum%(Math.pow(10, 9) + 7));
    }
	
	//time exceed
	public int sumSubarrayMins2(int[] arr) {
		long[] res = new long[1];
		Map<String, Long> map = new HashMap<>();
		
		sumSubDp(0, arr.length-1, arr, map, res);
		
		return (int) (res[0]%(Math.pow(10, 9) + 7));
	}
	long sumSubDp(int s,int e , int[] arr, Map<String, Long> map, long[] res)
	{
		
		if( s > e) return 0;

		String key = s+ ":" + e;
		
		if(map.containsKey(key))
		{
			return map.get(key);
		}
		long min = 0;
		
		if(s == e)
		{
			min = arr[s];
		}
		else {
			min = Math.min(sumSubDp(s+1, e, arr, map, res), sumSubDp(s, e-1, arr, map, res));
		}
		res[0] += min;
		
		map.put(key, min );
		
		return map.get(key);
	}
	
	//doesnt work some last few  cases
	   public int sumSubarrayMins3(int[] arr) {
		   long sum = 0;
		   Stack<Node> stack = new Stack<>();
		   
		   int[] left = new int[arr.length];
		   Arrays.fill(left, 1);
		   stack.push(new Node(arr[0], 1));
		   for(int i = 1 ; i < arr.length ;i++)
		   {

			   while(!stack.isEmpty() && stack.peek().num  >= arr[i])
			   {
				   left[i] += stack.pop().count;
			   }
			   stack.push(new Node(arr[i] ,left[i]));
		   }
		   
		   int[] right = new int[arr.length];
		   Arrays.fill(right, 1);
		   stack = new Stack<>();
		   stack.push(new Node(arr[arr.length-1], 1));

		   for(int i = arr.length-2 ; i >= 0 ;i--)
		   {

			   while(!stack.isEmpty() && stack.peek().num  > arr[i])
			   {
				   right[i] += stack.pop().count;
			   }
			   stack.push(new Node(arr[i] ,right[i]));
		   }
		   
		   for(int i = 0 ; i < arr.length ;i++)
		   {
			   sum += left[i] * right[i] * arr[i];
		   }
		   
		   return (int) (sum % (Math.pow(10, 9) + 7));
	   }
	
	   class Node
	   {
		   int num;int count;
		   Node(int n, int c)
		   {
			   num = n;
			   count = c;
		   }
	   }
	   
	   public int sumSubarrayMins(int[] arr) {
	        MQ mq = new MQ();
	        for(int i = 0; i < arr.length; i++){
	            mq.push(new Bar(arr[i]));
	        }
	        return (int)(mq.total % (Math.pow(10, 9) + 7));
	    }
	    
	    private class MQ{
	        Stack<Bar> mq;
	        int sum;
	        double total;
	        public MQ(){
	            mq = new Stack<>();
	            sum = 0;
	            total = 0;
	        }
	        public void push(Bar bar){
	            while(!mq.isEmpty() && mq.peek().value >= bar.value){
	                Bar kickedBar = mq.pop();
	                sum -= kickedBar.kicked * kickedBar.value;
	                bar.kicked += kickedBar.kicked;
	                System.out.println(bar.value + "==" + kickedBar.value + "==" + sum);
	            }
	            mq.push(bar);
	            sum += bar.value * bar.kicked;
	            total += sum;
	        }
	    }
	    private class Bar{
	        int value;
	        int kicked;
	        public Bar(int val){
	            value = val;
	            kicked = 1;
	        }
	    }
	
	public static void main(String[] args) {
		SumSubArrayMins obj = new SumSubArrayMins();
//		System.out.println(obj.sumSubarrayMins(new int[] {3,1,2,4}));
		
//		System.out.println(obj.sumSubarrayMins(new int[] {11,81,94,43,3}));
		System.out.println(obj.sumSubarrayMins(new int[] {2,8,9,3,4}));

	}
}
