package com.samples.random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class NoOfMeetingRoom {

	class Node
	{
		int val;
		int count;
		Node(int v)
		{
			val = v;
		}

		
		@Override
		public String toString() {
			return String.valueOf(val) + "==count==" + count;
		}
	}
	public int minMeetingRooms1(int[][] intervals) {

		Map<Integer, Node> map = new TreeMap<Integer,NoOfMeetingRoom.Node>();
		for(int i =0 ; i < intervals.length ; i++)
		{
			if(!map.containsKey(intervals[i][0]))
			{
				map.put(intervals[i][0],new Node(intervals[i][0]));
			}
			map.get(intervals[i][0]).count++;
			
			if(!map.containsKey(intervals[i][1]))
			{
				map.put(intervals[i][1],new Node(intervals[i][1]));
			}
			 map.get(intervals[i][1]).count--;
		}
		
//		System.out.println(map.values());
		Node maxNode = null;
		int maxCount = 0;
		int totSum = 0;
		
		for(Node node : map.values())
		{
			node.count += totSum;
			totSum = node.count;
			
			if(maxCount < node.count)
			{
				maxCount = node.count;
				maxNode = node;
				
			}
		}
	
		return maxNode == null ?  0 : maxNode.count;
    }
	public static void main(String[] args) {
		NoOfMeetingRoom room = new NoOfMeetingRoom();
//		room.process();
		room.minMeetingRooms(new int[][] {{0, 30},{5,10},{15,20}});
	}
	
	public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0) return 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 1;
        int endIdx = 0;
        for(int i=1; i<intervals.length; i++) {
        	System.out.println(start[i] + "===" + end[endIdx]);
            if(start[i]>=end[endIdx]) {
                endIdx++;
            } else {
                rooms++;
            }
        }
        return rooms;
    }
    
	
	void process()
	{
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		});
		queue.add(new Node(4));
		queue.add(new Node(6));
		queue.add(new Node(2));
		
		System.out.println(queue);
		
		printQueue(queue);
		queue.poll();
		printQueue(queue);
		
		Map<Integer, Node> map = new TreeMap<Integer,NoOfMeetingRoom.Node>();
		map.put(3, new Node(3));
		map.put(37, new Node(3));
		map.put(2, new Node(2));
		System.out.println(map);
		map.put(12, new Node(2));
		printMap(map);
	}
	
	void printQueue(PriorityQueue<Node> queue)
	{
		Iterator<Node> it = queue.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
	void printMap(Map<Integer,Node> queue)
	{
		System.out.println(queue.keySet());
	}
}
