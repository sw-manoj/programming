package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

//	https://leetcode.com/problems/sort-characters-by-frequency/
public class FrequencySort {

	class  Node
	{
		Character ch;
		int count;
		
	}
	public String frequencySort(String s) {
         Map<Character,Integer> countMap = new HashMap<>();
         for(char ch : s.toCharArray())
         {
        	 countMap.put(ch, countMap.getOrDefault(ch, 0)+1);
         }
		
         Queue<Character> queue = new PriorityQueue<>( (o1,o2) -> countMap.get(o2) - countMap.get(o1));
         
         for(Character ch : countMap.keySet())
         {
        	 queue.offer(ch);
         }
         
         String res = "";
         while(!queue.isEmpty())
         {
        	 char c = queue.poll();
        	 int i = 0;
        	 while(i < countMap.get(c) )
        	 {
        		 res += String.valueOf(c); 
        		 i++;
        	 }
         }
         
         return res;
    }
	
	public String frequencySort1(String s) {
        Map<Character,Integer> countMap = new HashMap<>();
        for(char ch : s.toCharArray())
        {
       	 countMap.put(ch, countMap.getOrDefault(ch, 0)+1);
        }
		
        List<Character>[] bucketSort = new ArrayList[s.length()];
        
        for(Entry<Character, Integer> entry : countMap.entrySet())
        {
        	if(bucketSort[entry.getValue()] == null)
        		bucketSort[entry.getValue()] = new ArrayList<>();
        	
        	bucketSort[entry.getValue()].add(entry.getKey());
        }
        String res = "";
        for(int i = bucketSort.length-1; i >=0 ; i--)
        {
        	if(bucketSort[i] == null) continue;
        	for(Character c : bucketSort[i])
        	{
        	for(int j = 0 ; j < i; j++)
        	{
        		res += String.valueOf(c);
        	}
        	}
        }
        
        return res;
   }
	
	public static void main(String[] args) {
		FrequencySort obj = new FrequencySort();
		System.out.println(obj.frequencySort("abcabcc"));
		System.out.println(obj.frequencySort("aaaccc"));
		System.out.println(obj.frequencySort("cacA"));
		
		
		System.out.println(obj.frequencySort1("abcabcc"));
		System.out.println(obj.frequencySort1("aaaccc"));
		System.out.println(obj.frequencySort1("cacA"));


	}

}
