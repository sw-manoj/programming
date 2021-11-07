package topologicalsort.not;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/course-schedule-iii/submissions
public class CourseScheduleIII {

	// memory limit exceeds
	public int scheduleCourse1(int[][] courses) {
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        int currentTime = 0;
        int numCourse = courses.length-1;
        Integer[][] memo = new Integer[courses.length][courses[numCourse][1]+1];
        return backtrack(courses, 0, currentTime, memo);
    }
	
	public int backtrack(int[][] courses , int index, int currentTime, Integer[][] memo)
	{
		if(index >= courses.length)
		{
			return 0;
		}
		
		if (memo[index][currentTime] != null)
		{
			return memo[index][currentTime];
		}
		int include = 0;
		if(currentTime + courses[index][0] <= courses[index][1])
		{
			include = backtrack(courses, index+1, currentTime + courses[index][0], memo) + 1;
		}
		int exclude = backtrack(courses, index+1, currentTime, memo);
		
		memo[index ][currentTime] = Math.max(include, exclude);
		return memo[index ][currentTime];
	}
	
	public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        int currentTime = 0;
        int n = courses.length;
        int count = 0;
        for(int i = 0 ; i < n; i++)
        {
        	if(currentTime + courses[i][0] <= courses[i][1])
        	{
        		currentTime += courses[i][0];
        		count++;
        	}
        	else
        	{
        		int max_i = i;
        		for (int j = 0 ; j<i;j++)
        		{
        			if(courses[j][0] > courses[max_i][0] )
        			{
        				max_i = j;
        			}
        		}
        		if(max_i != i)
        		{
					currentTime += courses[i][0] - courses[max_i][0];
					courses[max_i][0] = -1;
        		}
        		else
        		{
        			courses[i][0] = -1;
        		}

        	}
        }
        
        return count;
	}
	
	public int scheduleCourse_pq(int[][] courses) {
		Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        int currentTime = 0;
        int n = courses.length;
        int count = 0;
        
        //using priority heap to poll the max duration course staright away instead looping from begining to replace current course.
        // more details on leetcode solution link.
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o2[0]-o1[0]);
        
        for(int i = 0 ; i < n; i++)
        {
        	if(currentTime + courses[i][0] <= courses[i][1])
        	{
        		currentTime += courses[i][0];
        		queue.offer(courses[i]);
        		count++;
        	}else
        	{
        		if( !queue.isEmpty() && queue.peek()[0] > courses[i][0])
        		{
        			currentTime -= queue.poll()[0];
        			queue.offer(courses[i]);
            		currentTime += courses[i][0];

        		}
        	}
        }
        
        return count;
        
        
	}
	public static void main(String[] args) {
		CourseScheduleIII obj = new CourseScheduleIII();
		
		System.out.println(obj.scheduleCourse(new int[][] {{100,2},{32,50}}));
		
		System.out.println(obj.scheduleCourse(new int[][] {{5,5},{4,6},{2,6}}));
		
		System.out.println(obj.scheduleCourse_pq(new int[][] {{100,2},{32,50}}));
		
		System.out.println(obj.scheduleCourse_pq(new int[][] {{5,5},{4,6},{2,6}}));
	}
}
