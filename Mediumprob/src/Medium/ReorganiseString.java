package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;


//https://leetcode.com/problems/reorganize-string/submissions/


public class ReorganiseString {

	class Node
	{
		Character ch; 
		int count;
		Node(int co, Character c)
		{
			ch =c;
			count = co;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.valueOf(ch) + "==" + count;
		}
	}
	public String reorganizeString(String s) {
        String res = "";
        
        Map<Character, Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray())
        {
        	countMap.put(c, countMap.getOrDefault(c, 0) +1);
        }
        
        Queue<Node> queue = new PriorityQueue<>((o1,o2) -> o2.count - o1.count);
        for(Entry<Character, Integer> entry : countMap.entrySet())
        {
        	queue.offer(new Node(entry.getValue(), entry.getKey()));
        }

        while(queue.size() > 1)
        {
//        	System.out.println(queue);
        	Node n1 = queue.poll();
        	Node n2 = queue.poll();
        	
        	res += String.valueOf(n1.ch) + String.valueOf(n2.ch);
        	
        	if(n1.count-1 > 0)
        	{
        		queue.offer(new Node(n1.count-1, n1.ch));
        	}
        	if(n2.count -1 > 0)
        	{
        		queue.offer(new Node(n2.count-1, n2.ch));
        	}
        	
        }
        
        if(!queue.isEmpty() && queue.peek().count ==1 )
        {
        	res += queue.poll().ch;
        }
        
        if(res.length() != s.length())
        {
        	res = "";
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		ReorganiseString obj = new ReorganiseString();
		System.out.println(obj.reorganizeString("aab"));
		System.out.println(obj.reorganizeString("aaab"));
		System.out.println(obj.reorganizeString("abccdecae"));

	}
}
