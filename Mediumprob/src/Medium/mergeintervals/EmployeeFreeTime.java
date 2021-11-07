package Medium.mergeintervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;


//Definition for an Interval.
class Interval {
 public int start;
 public int end;

 public Interval() {}

 public Interval(int _start, int _end) {
     start = _start;
     end = _end;
 }
};


//https://leetcode.com/problems/employee-free-time/submissions/
public class EmployeeFreeTime {
	
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> result = new ArrayList<>();
		Queue<Interval> empInt = new PriorityQueue<>( (t1,t2) -> Integer.compare(t1.start, t2.start));
		for(List<Interval> empList : schedule)
		{
			empInt.addAll(empList);
		}

		Interval prev = null;
		
		while(!empInt.isEmpty())
		{
			Interval interval = empInt.poll();

			if(prev == null)
			{
				prev = interval;
				continue;
			}
			
			if(prev.end < interval.start)
			{
				result.add(new Interval(prev.end, interval.start));
				prev = interval;
			}
			else
			{
				prev.end = Math.max(prev.end, interval.end);
			}
		}
		return result;
	}

	public List<Interval> employeeFreeTime1(List<List<Interval>> schedule) {
		List<Interval> result = new ArrayList<>();
		result.add(new Interval(Integer.MIN_VALUE, Integer.MAX_VALUE));
		for(List<Interval> empList : schedule)
		{
			int index = 0;
			for(Interval interval : empList)
			{
				for(Interval resInterval : result)
				{
					if(resInterval.end < interval.start)
					{
						if(result.get(index).end > interval.end )
						{
							int oldEnd = result.get(index).end ;
							result.get(index).end =  interval.start ;
							result.add(new Interval(interval.end, oldEnd ));
						}
						break;
					}
				}
				while(index < result.size())
				{
					if(result.get(index).end > interval.end )
					{
						int oldEnd = result.get(index).end ;
						result.get(index).end =  interval.start ;
						result.add(new Interval(interval.end, oldEnd ));
					}
				}
			}
		}
		return result;
    }
}
