package com.samples.binarytree;

public class MedianOfTwoArr {
	
	public static void main(String[] args) {
		int nums1[] = {1,2};
		int nums2[] = {1,2,3};
		
		MedianOfTwoArr m = new MedianOfTwoArr();
		double res = m.findMedianSortedArrays(nums1, nums2);
		System.out.println(res);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2)  {
		 int n = nums1.length;
		 int m = nums2.length;
		  int m1 = -1, m2 = -1;
		   int i =0, j = 0;
		   
		   if(nums1.length == 0)
		   {
			   return findMed(nums2);
		   }
		   if(nums2.length == 0)
		   {
			   return findMed(nums1);
		   }
		   
		  
		 for (int count = 0; count <= (n + m)/2; count++)  
	        {  
	            m2 = m1;  
	            if(i != n && j != m) 
	            {  
	                m1 = (nums1[i] > nums2[j]) ? (nums2[j++]) : nums1[i++];  
//	                if(nums1[i] == nums2[j])
//	                {
//	                	m1 = nums2[j++];
//	                	m2 = m1;
//	                	count++;
//	                }
	            }  
	            else if(i < n) 
	            {  
	                m1 = nums1[i++];  
	            }  
	            // for case when j<m,  
	            else
	            {  
	                m1 = nums2[j++];  
	            }  
	        }  
		 
		 if( ((n + m)) % 2 == 1)
		 {
			 return m1;
		 }
	        return ((double)m1 + (double)m2)/2;  
	   }
	
	private double findMed(int[] arr)
	{
		int n = arr.length;
		 int mid = n/2;
		if(mid ==0  || (n) % 2 ==1 )
		{
			return arr[mid];
		}
		else
		{
			return  ((double)arr[mid] + (double)arr[mid-1])/2 ;
		}
	}
}
