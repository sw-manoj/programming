package com.samples.list.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

//https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElement {

	class Node
	{
		int val;
		int occ;
	}
	
	public int[] topKFrequent_quick(int[] nums, int k) {
        final Map<Integer,Integer> countMap = new HashMap<>();
        
        for(int i = 0 ; i  < nums.length ; i++)
        {
        	int count = countMap.getOrDefault(nums[i], 0);
        	count += 1;
        	countMap.put(nums[i], count);
        }
        
        int [] uniqueEle = new int[countMap.size()]; 
        int i = 0;
        int n = uniqueEle.length-1;
        for (int num: countMap.keySet()) {
            uniqueEle[i] = num;
            i++;
        }  
        
        System.out.println(Arrays.stream(uniqueEle)
				.boxed().collect(Collectors.<Integer>toList()));
        
        quickSelect(0, n, uniqueEle, k, countMap);
        
        int[] res = new int[k];
        for(int j = 0 ; j < k; j++)
        {
        	res[j] = uniqueEle[n-j];
        }
        return res;
	}
	
	
	private void quickSelect(int l , int r, int[] nums, int k, Map<Integer,Integer> countMap)
	{
		if(l > r)
		{
			return;
		}
		int index = r;
		int pivotIndex = partition(l, r, index, nums, countMap);
		
		if(pivotIndex == k) return ;
		
		if(pivotIndex < k)
		{
			quickSelect(pivotIndex +1, r, nums, k, countMap);
		}
		else
		{
			quickSelect(l, pivotIndex-1, nums, k, countMap);

		}
	}
	
	private int partition(int l , int r , int index, int[] nums, Map<Integer,Integer> countMap)
	{
		int storeIndex = l;
		for(int i = l ; i <= r ; i++)
		{
			if(countMap.get(nums[i]) < countMap.get(nums[index]))
			{
				swap(storeIndex, i, nums);
				storeIndex++;
			}
		}
		swap(storeIndex, index, nums);
		return storeIndex;
	}
	private void swap(int i , int j, int[] nums)
	{
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	
	public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer,Integer> countMap = new HashMap<>();
        
        for(int i = 0 ; i  < nums.length ; i++)
        {
        	int count = countMap.getOrDefault(nums[i], 0);
        	count += 1;
        	countMap.put(nums[i], count);
        }
        
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return  countMap.get(o1) - countMap.get(o2);
			}
		});
        
        int[] res = new int[k];
        
        for(Entry<Integer, Integer> entry : countMap.entrySet())
        {
        	queue.offer(entry.getKey());
        	if(k < queue.size())
        	{
        		queue.poll();
        	}
        }
        
        int i = 0;
        while(!queue.isEmpty())
        {
        	res[i] = queue.poll();
        	i++;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		TopKFrequentElement obj = new TopKFrequentElement();
//		System.out.println(Arrays.strasList(obj.topKFrequent(new int[] {1,1,1,2,2,3}, 2)));
//		System.out.println(Arrays.stream(obj.topKFrequent_quick(new int[] {1,1,1,2,2,3}, 2))
//									.boxed().collect(Collectors.<Integer>toList()));
//		
//		System.out.println(Arrays.stream(obj.topKFrequent(new int[] {1,2}, 2))
//				.boxed().collect(Collectors.<Integer>toList()));
//
//
//		System.out.println(Arrays.stream(obj.topKFrequent(new int[] {1,1,4,4,1,2,2,3,5,5,4}, 2))
//		.boxed().collect(Collectors.<Integer>toList()));
		
		System.out.println(Arrays.stream(obj.topKFrequent_quick(new int[] {1,2}, 2))
				.boxed().collect(Collectors.<Integer>toList()));


//			System.out.println(Arrays.stream(obj.topKFrequent_quick(new int[] {1,1,4,4,1,2,2,3,5,5,4}, 2))
//						.boxed().collect(Collectors.<Integer>toList()));
	}
}
