package Medium.mergeintervals;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class FindMinArrowShots {

	public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

		
		Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
		int start ,end = 0;
		
		int largeEnd = points[0][1];
		// use 1 arrow for 1st ballon 
		int arrow = 1;

		int index = 0;
		
		while(index < points.length)
		{
			start = points[index][0];
			end = points[index][1];
			// if the current balloon starts after the end of another one,
            // one needs one more arrow
			if(largeEnd < start)
			{
				arrow++;
				largeEnd = end;
			}
			index++;
		}
		return arrow;
	}

	public int findMinArrowShots_sortWithStart(int[][] points) {
		if (points.length == 0) return 0;


		Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
		int start ,end = 0;

		int largeEnd = points[0][1];
		// use 1 arrow for 1st ballon
		int arrow = 1;

		int index = 0;

		while(index < points.length)
		{
			start = points[index][0];
			end = points[index][1];
			// if the current balloon starts after the end of another one,
			// one needs one more arrow
			if(largeEnd < start)
			{
				arrow++;
				largeEnd = end;
			}
			else{
				// if sorted by end then no need to take minimun as we would have already started of with minimum,.
				largeEnd = Math.min(largeEnd, end);
			}
			index++;


		}
		return arrow;
	}
}
