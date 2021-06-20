package easyprob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersect {
	
	public int[] intersect(int[] nums1, int[] nums2) {
	    Arrays.sort(nums1);
	    Arrays.sort(nums2);
	    int i = 0, j = 0, k = 0;
	    while (i < nums1.length && j < nums2.length) {
	        if (nums1[i] < nums2[j]) {
	            ++i;
	        } else if (nums1[i] > nums2[j]) {
	            ++j;
	        } else {
	            nums1[k++] = nums1[i++];
	            ++j;
	        }
	    }
	    return Arrays.copyOfRange(nums1, 0, k);
	}

public int[] intersect1(int[] nums1, int[] nums2) {
	
		if(nums1.length > nums2.length)
		{
			return intersect(nums2, nums1);
		}
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums1)
        {
        	map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> result = new ArrayList<Integer>();
        int k = 0;
        for (int num : nums2)
        {
        	int cnt = map.getOrDefault(num, 0); 
        	if(cnt > 0)
        	{
        		result.add(num);
            	map.put(num, cnt-1);
            	nums1[k++] = num;

        	}
        }
        
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
