package easyprob;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargestInStream {

	
	 PriorityQueue<Integer> pq = new PriorityQueue<>();
	 int K;
	 public KthLargestInStream(int k, int[] nums) {
	     K = k;
	     for(int i = 0;i<nums.length;i++){
	         pq.add(nums[i]);
	         
	         if(pq.size()>K){
	            System.out.println( pq.poll());
	         }
	     }
	 }

	 public int add(int val) {
	     pq.add(val);
	     
	     if(pq.size()>K){
	    	 System.out.println( pq.poll());
	     }
	     System.out.println(pq);
	     return pq.peek();
	     
	 }
	 
	 public static void main(String[] args) {
		 KthLargestInStream obj = new KthLargestInStream(3, new int[] {4,8,5,6,7});
		 System.out.println(obj.add(1));
		 System.out.println(obj.add(9));

	}
}
