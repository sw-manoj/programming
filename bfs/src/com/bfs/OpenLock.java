package com.bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class OpenLock {
	
//	https://leetcode.com/problems/open-the-lock/

	public int openLock(String[] deadends, String target) {
        int step = 0;
        
        
        List<String> deadList = Arrays.asList(deadends);
        
        if (deadList.contains(target)) return -1;
        Map<String, Boolean> seen = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        
        seen.put(queue.peek(), true);
        
        while(!queue.isEmpty())
        {
        	
        	int size = queue.size();
        	for(int i = 0 ; i < size; i++)
        	{
            	String key = queue.poll();
            	
            	if(deadList.contains(key)) continue;
            	if(key.equals(target)) return step;
            	
        		for (int j = 0 ; j < 4 ; j++)
        		{
        			int c = key.charAt(j) - '0';
        			for(int k = -1; k <= 1 ; k+=2)
        			{
        				int digit = ((c+k) + 10) % 10;
        				String next = key.substring(0, j) + ("" + digit) + key.substring(j+1);
        				
        				if(!seen.containsKey(next))
        				{
        					seen.put(next, true);
        					queue.offer(next);
        				}
        			}
        		}
        	}
        	step++;
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		String [] deadends = {"0201","0101","0102","1212","2002"};
		String target = "0202";
		
		OpenLock lock = new OpenLock();
		
		System.out.println(lock.openLock(deadends, target));
				
	}

}
