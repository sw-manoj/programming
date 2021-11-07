package com.samples.list.quick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.samples.list.medium.TopKFrequentElement;

//https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElementQuick extends TopKFrequentElement{

	public static void main(String[] args) {
		TopKFrequentElementQuick obj = new TopKFrequentElementQuick();
//		System.out.println(Arrays.strasList(obj.topKFrequent(new int[] {1,1,1,2,2,3}, 2)));
		System.out.println(Arrays.stream(obj.topKFrequent(new int[] {1,1,1,2,2,3}, 2))
									.boxed().collect(Collectors.<Integer>toList()));
		
		
		System.out.println(Arrays.stream(obj.topKFrequent(new int[] {1,1,4,4,4,1,2,2,3,5,5,4,4}, 2))
				.boxed().collect(Collectors.<Integer>toList()));
	}
	
	
	int[] uniqueEle;
	Map<Integer,Integer> uniqueMap = new HashMap<>();
	public int[] topKFrequent(int[] nums, int k) {
		uniqueMap.clear();
        for(int i = 0 ; i  < nums.length ; i++)
        {
        	int count = uniqueMap.getOrDefault(nums[i], 0);
        	count += 1;
        	uniqueMap.put(nums[i], count);
        }
        
        //total unique elements in input array
        int n = uniqueMap.size();
        // kth top frequent element is (n - k)th less frequent.
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array. 
        // All element on the left are less frequent.
        // All the elements on the right are more frequent. 
        
        
        uniqueEle = new int[n]; 
        int i = 0;
        for (int num: uniqueMap.keySet()) {
            uniqueEle[i] = num;
            i++;
        }        
        
        quickSelect(0, n-1, n-k);
        
        System.out.println(Arrays.toString(uniqueEle));
        int[] res = new int[k];
        int c = n-k;
        for(int j = 0; j <k; j++)
        {
        	res[j] = uniqueEle[c];
//        	System.out.println(uniqueEle[k]);
        	c++;
        }
        
        return res;
	}
	
	public void quickSelect(int left , int right, int KthIndex)
	{
		if(left >= right) return;
		
		int index = right;
		int pivotIndex = partition(left, right, index);
		
		if(pivotIndex == KthIndex) return;
		
		if(pivotIndex < KthIndex)
		{
			quickSelect(pivotIndex+1, right, KthIndex);
		}
		else {
			quickSelect(left, pivotIndex-1, KthIndex);

		}
	}
	
	private int partition(int l , int r , int index)
	{
		int store_index = l;
		for(int i = l ; i <= r ;i++)
		{
			if(uniqueMap.get(uniqueEle[i]) > uniqueMap.get(uniqueEle[index])  )
			{
				swap(i, store_index);
				store_index++;
			}
		}
		swap(r, store_index);
		return store_index;
	}
	
	private void swap(int a, int b)
	{
		int tmp = uniqueEle[a];
		uniqueEle[a] = uniqueEle[b];
		uniqueEle[b] = tmp;
	}
	
	
}
