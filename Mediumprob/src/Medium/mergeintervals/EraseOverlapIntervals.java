package Medium.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/non-overlapping-intervals/submissions/
public class EraseOverlapIntervals {
	public static void main(String[] args) {
		EraseOverlapIntervals obj = new EraseOverlapIntervals();
		System.out.println(obj.eraseOverlapIntervals(new int [][] {{1,2}, {2,3}, {3,4}, {1,3}}));
		System.out.println(obj.eraseOverlapIntervals(new int [][] {{1,2}, {1,2}, {1,2}}));
		System.out.println(obj.eraseOverlapIntervals(new int [][] {{1,2}, {2,3}}));
		System.out.println(obj.eraseOverlapIntervals(new int [][] {{1,100},{11,22},{1,11},{2,12}}));

	}

	public int eraseOverlapIntervals(int[][] intervals) {
      
		//since minimun of interval have to be removed as per the problem statement, 
//		sort by end so that interval with smaller end will come begining, thus removing the larger overlappping interval like last exmaple.
		Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
		
		int res = 0;
		int[] prev = intervals[0];
		
		for(int i = 1; i < intervals.length ; i++)
		{
			if(prev[1] > intervals[i][0])
			{
				res++;
			}
			else
			{
				prev = intervals[i];
			}
		}
		return res;
    }
}
