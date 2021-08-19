package com.samples.list.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosetPointToOrigin {

	private Double distance(int[] a)
	{
		return Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
	}
	public int[][] kClosest(int[][] points, int k) {
       
		Queue<int[]> queue = new PriorityQueue<>((o1,o2) -> distance(o2).compareTo( distance(o1)));
		
		int[][] res = new int[k][2];
		
		for( int i = 0; i < points.length ; i++ )
		{
			queue.offer(points[i]);
			if(queue.size() > k)
			{
				queue.poll();
			}
		}
		int i = 0;
		while(!queue.isEmpty())
		{
			res[i] = queue.poll();
			i++;
		}
		
		return res;
    }
	
	private static void print(int[][] arr)
	{
		for(int i = 0 ; i < arr.length; i++)
		{
			System.out.println(arr[i][0] + "==" + arr[i][1]);
		}
	}
	public static void main(String[] args) {
		KClosetPointToOrigin obj = new KClosetPointToOrigin();
		int[][] res = obj.kClosest(new int [][] {{3,3},{5,-1},{-2,4}}, 2);
//		int[][] res = obj.kClosest(new int [][] {{1,3},{-2,2}}, 1);

		print(res);
	}
}
