package Medium.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/insert-interval/submissions/
public class InsertInterval {

	
	public static void main(String[] args) {
		execute(new int[][] {{1,3}, {6,9}}, new int[] {2,5});
		execute(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {4,8});
		execute(new int[][] {}, new int[] {5,7});
		execute(new int[][] {{1,5}}, new int[] {2,3});
		execute(new int[][] {{1,5}}, new int[] {2,7});

	}
	
	static void execute(int[][] intervals, int[] newInterval)
	{
		InsertInterval obj = new InsertInterval();

		int[][] res = obj.insert(intervals, newInterval);
		
		for(int[] a : res)
		{
			System.out.print(Arrays.toString(a));
		}
		System.out.println();
		System.out.println("====*****======");
	}
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
        
		int[] prev = new int [2];
		boolean skip = false;
		List<int[]> result = new ArrayList<int[]>();

		int n = intervals.length;
		int index = 0;
		
		int newStart = newInterval[0];
		int newEnd = newInterval[1];
		
		while(index < n && intervals[index][1] <  newInterval[0])
		{
			result.add(intervals[index]);
			index++;
		}
		
		while(index < n && intervals[index][0] <= newEnd)
		{
			newStart = Math.min(intervals[index][0], newStart);
			newEnd = Math.max(intervals[index][1], newEnd);
			index++;

		}
		result.add(new int[] {newStart, newEnd});
//		index++;
		
		while(index < n)
		{
			result.add(intervals[index]);
			index++;

		}
		
		return result.toArray(new int[0][0]);
    }

}
