package com.samples.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomizedCollection {
	Map<Integer,LinkedHashSet<Integer>> valTOListPosMap = new HashMap<Integer,LinkedHashSet<Integer>>();
	List<Integer> valList = new ArrayList<Integer>();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    java.util.Random rand = new java.util.Random();
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	if(!valTOListPosMap.containsKey(val))
    	{
    		valTOListPosMap.put(val, new LinkedHashSet<Integer>());
    	}
    	valTOListPosMap.get(val).add(valList.size());
    	valList.add(val);
    	System.out.println(valTOListPosMap);
    	return valTOListPosMap.get(val).size() ==1 ? true : false;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	if(!valTOListPosMap.containsKey(val)|| valTOListPosMap.get(val).size() == 0 )
    	{
    		return false;
    	}
    	LinkedHashSet<Integer> valListIndex = valTOListPosMap.get(val);
        int pos = valListIndex.iterator().next();
        int lastVal = valList.get(valList.size()-1);
        valListIndex.remove(pos);
        LinkedHashSet<Integer> lastValList = valTOListPosMap.get(lastVal);
        System.out.println(valTOListPosMap);
        lastValList.add(pos);
        lastValList.remove(valList.size()-1);
        valList.set(pos, lastVal);
        
        //has to be at last to use the last element in prev steps
        valList.remove(valList.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return valList.get(rand.nextInt(valList.size()));
    }
    
    public static void main(String[] args) {
    	 RandomizedCollection obj = new RandomizedCollection();
    	 obj.insert(1);
//    	 obj.insert(1);
//    	 obj.insert(2);
//    	 obj.getRandom();
    	 obj.remove(1);
    	 obj.insert(1);
//    	 obj.getRandom();
	}
}
