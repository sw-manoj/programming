package com.sapient.ecommerce.dbaccess.dbschema;

import java.util.List;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class Category {

	String categoryType;
	String categoryid;
	
	//key is like shoe,pant,jean,shorts etc..
	ConcurrentHashMap<String, List<Product>> productMap = new ConcurrentHashMap<String, List<Product>>();
	public static void main(String[] args) {
		Queue<String> queue;
		Category c = new Category();
		c.test();
		
	}
	ConcurrentHashMap<String, Integer> logMap = new ConcurrentHashMap<String, Integer>();


	 TreeMap<Integer,Integer> set = new TreeMap<Integer,Integer>();

	 
	  public void hit(int timestamp) {
	       
	        if(set.containsKey(timestamp))
	        {
	           set.put(timestamp,((int)set.get(timestamp)) + 1 );
	        }
	        else
	        {
	            set.put(timestamp,1);
	        }
	System.out.println(set);
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public int getHits(int timestamp) {
	        SortedMap<Integer, Integer> sortedMap = set.subMap(timestamp-300,false, timestamp,true);
		System.out.println(set.subMap(timestamp-300,false, timestamp,true));
	    return sortedMap.values().stream().mapToInt(Integer::intValue).sum();
	    }
	    




	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		
	 
	 
	 
	 
	 
	 
	void test()
	{
		String s = null ;
TreeMap<Integer,Integer> set = new TreeMap<Integer,Integer>();
set.put(1, 4);
set.put(11, 4);
set.put(4, 4);
set.put(5, 4);
set.get(1);
SortedMap<Integer, Integer> sortedMap = set.subMap(1, 7);
	System.out.println(set.subMap(2, 7));
sortedMap.values().stream().mapToInt(Integer::intValue).sum();
synchronized (s) {
			
		}
		productMap.compute("key", (k,list) -> null);
		System.out.println(productMap);
		if(productMap.containsKey(""))
		{
			
		}
		
	}
	class Pojo
	{
		int time;
		boolean state = false;
		
		Pojo(int t)
		{
			time = t;
		}
	}
}
