package Medium.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {
	
	public static void main(String[] args) {
		execute(new int[][] {{0,2},{5,10},{13,23},{24,25}}, new int[][] {{1,5},{8,12},{15,24},{25,26}} );
		
	}

	static void execute(int[][] intervals, int[][] newInterval)
	{
		IntervalIntersection obj = new IntervalIntersection();

		int[][] res = obj.intervalIntersection(intervals, newInterval);
		
		for(int[] a : res)
		{
			System.out.print(Arrays.toString(a));
		}
		System.out.println();
		System.out.println("====*****======");
	}
	
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        
        int i = 0;
         int j = 0;
         
         while(i < firstList.length && j < secondList.length)
         {
        	 if(firstList[i][1] > secondList[j][0] || firstList[i][0] < secondList[j][1])
        	 {
        		 int start = Math.max(firstList[i][0], secondList[j][0]);
        		 int end = Math.min(firstList[i][1], secondList[j][1]);

        		 if(start <= end)
        		 {
        		 result.add(new int[] {start, end});
        		 }
        	 }
        	 
        	 if(firstList[i][1] > secondList[j][1])
        	 {
        		 j++;
        	 }
        	 else
        	 {
        		 i++;
        	 }
         }
        return result.toArray(new int[0][0]);
    }
}
