package Medium.mergeintervals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {

	public static void main(String[] args) {
		TaskScheduler obj = new TaskScheduler();
		System.out.println(obj.leastInterval(new char[] {'A', 'A', 'A','B','C','D'}, 2));
	}
	public int leastInterval(char[] tasks, int n) {
        
		Map<Character, Integer> taskFreq = new HashMap<>();
		
		for(char c : tasks)
		{
			if(taskFreq.containsKey(c))
			{
				taskFreq.put(c, taskFreq.get(c) + 1);
			}
			else
			{
				taskFreq.put(c, 1);
			}
		}
		
		Queue<Entry<Character, Integer>> pq = new PriorityQueue<>( (t1,t2) -> Integer.compare(t2.getValue(), t1.getValue()));
		pq.addAll(taskFreq.entrySet());
//		System.out.println(pq);
		int result = 0;
		while(!pq.isEmpty())
		{
			int k = n +1;
			List<Entry> buffer = new ArrayList<>();
			while(k > 0 && !pq.isEmpty())
			{
				Entry<Character, Integer> task = pq.poll();
				
				task.setValue(task.getValue()-1);
				buffer.add(task);
				result++;
				k--;
			}
			
			for(Entry<Character, Integer> entry : buffer)
			{
				if(entry.getValue() > 0)
				{
					pq.offer(entry);
				}
			}
			
			while( k > 0)
			{
				if(pq.isEmpty())
				{
					break;
				}
				result++; //adding idle tasks as new tasks are not available to accomodate with n tasks cycle.   
				k--;
			}
		}
		
		return result;
    }
}
