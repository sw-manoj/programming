package Medium.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
	
	public static void main(String[] args) {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		
		MergeIntervals obj = new MergeIntervals();
		System.out.println(Arrays.toString(obj.merge(intervals)));
		System.out.println(Arrays.toString(obj.merge(new int[][] {{1,4},{4,5}})));

	}





	public int[][] merge(int[][] intervals) {
        
		Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
		
		List<int[]> result = new ArrayList<int[]>();
		
		int[] prev = intervals[0];
		
		for(int i = 1; i < intervals.length ; i++)
		{
			if(prev[1] < intervals[i][0])
			{
				result.add(prev);
				prev = intervals[i];
			}
			else
			{
				prev[1] = Math.max(prev[1], intervals[i][1]);
			}
		}
		result.add(prev);
		
//		for(int[] a : result)
//		{
//			System.out.println(Arrays.toString(a));
//		}
		
		int[][] res = new int[result.size()][2];
		int j = 0;
		for(int[] a : result)
		{
			res[j] = a;
			j++;
		}
		
		return res;
    }
}
