package com.samples.random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class MergeIntervals {
	
//	https://leetcode.com/problems/merge-intervals/
		
	class Interval
	{
		int start;
		int end;
		Interval(int s , int e)
		{
			start = s;
			end = e;
		}
	}
	
	
	 public int[][] merge1(int[][] intervals) {
		 if(intervals.length == 0)
		 {
			 return new int[0][0];
		 }
		 List<Interval> set = new ArrayList<Interval>();
		 
	        for(int i = 0; i < intervals.length ; i++)
	        {
	        	set.add(new Interval(intervals[i][0], intervals[i][1]));
	        }
	        
	        Collections.sort(set, new Comparator<Interval>() {

				@Override
				public int compare(Interval o1, Interval o2) {
					// TODO Auto-generated method stub
					return o1.start < o2.start ? -1 : o1.start == o2.start ? 0 : 1;
				}
			});
	        
	        
	        List<Integer[]> res = new ArrayList<Integer[]>();
	        Iterator< Interval> it = set.iterator();
	        Interval in = it.next();
	        Integer[] prevInterval = new Integer[] {in.start,in.end} ;
	        
	        while(it.hasNext())
	        {
	        	Interval interval = it.next();
	        	if((interval.start >= prevInterval[0] && interval.start <= prevInterval[1])
	        			|| (interval.end >= prevInterval[0] && interval.end <= prevInterval[1])
	        			)
	        	{
	        		prevInterval[0] = Math.min(prevInterval[0], interval.start);
	        		prevInterval[1] = Math.max(prevInterval[1], interval.end);
	        	}
	        	else
	        	{
	        		System.out.println(prevInterval[0] + "===" + prevInterval[1]);
	        		res.add(prevInterval);
	        		prevInterval =  new Integer[] {interval.start,interval.end} ;
	        	}
	        	
	        }
	        res.add(prevInterval);
	        System.out.println(prevInterval[0] + "===" + prevInterval[1]);
	        int[][] finalArr = new int[res.size()][2];
	        int counter = 0;
	        for(Integer[] arr : res)
	        {
	        	finalArr[counter] = new int[] {arr[0],arr[1]};
	        	counter++;
	        }
	        return finalArr;
	    }
	 
	 public int[][] merge(int[][] intervals) {
	        int n = intervals.length;
	        int[] starts = new int[n];
	        int[] ends = new int[n];
	        for(int i = 0; i < n; i ++){
	            starts[i] = intervals[i][0];
	            ends[i] = intervals[i][1];                                    
	        }      
	        Arrays.sort(starts);
	        Arrays.sort(ends);
	        
	        int j = 0;
	        List<int[]> res = new ArrayList<>();
	        for(int i = 0; i < n; i ++){
	            if(i == n-1 || starts[i+1] > ends[i]){
	                int[] toadd = new int[2];
	                toadd[0] = starts[j];
	                toadd[1] = ends[i];
	                res.add(toadd);
	                j = i + 1;                
	            }        
	        }
	        
	        return res.toArray(new int[res.size()][2]);
	        
	 }
	 
	 public int[][] merge2(int[][] intervals) {
		 Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
		 LinkedList<int[]> res = new LinkedList<>();
		 
		 for(int i = 0 ; i < intervals.length ; i++)
		 {
			 if(res.isEmpty() || intervals[i][0] > res.getLast()[1])
			 {
				 res.add(intervals[i]);
			 }
			 else
				 
			 {
				 res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
			 }
		 } 
		 return res.toArray(new int[res.size()][]);
	 
	 }
	 

	 public static void main(String[] args) {
		 MergeIntervals merger = new MergeIntervals();
		 merger.merge(new int[][] {{1,4},{1,5}});
//		 merger.print(merger.merge2(new int[][] {{1,3},{3,5},{9,11}}));
//		 merger.print(merger.merge2(new int[][] {{1,10},{3,5},{9,11}}));
		 
		 merger.print(merger.merge_2ntry(new int[][] {{1,10},{3,5},{9,11}}));
		 merger.print(merger.merge_2ntry(new int[][] {{1,3},{3,5},{9,11}}));


	}
	 
	 public int[][] merge_2ntry(int[][] intervals) {
			Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
			 LinkedList<int[]> res = new LinkedList<>();

			int[] prev = intervals[0];
			res.add(intervals[0]);
			for( int i = 1; i < intervals.length ; i++)
			{
				if(res.getLast()[1] < intervals[i][0])
				{
					res.add(intervals[i]);
				}
				else if(res.getLast()[1] < intervals[i][1])
				{
					res.getLast()[1] = intervals[i][1];
				}
			}
			return res.toArray(new int[res.size()][2]);
		}
	 
	 void print( int[][] interval)
	 {
		 for(int i = 0; i < interval.length; i++)
		 {
			 System.out.println(interval[i][0] + "==" + interval[i][1]);
		 }
	 }
}
