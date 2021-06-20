package easyprob;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/submissions/
public class MergeSortedArray {

	public static void main(String[] args) {
		MergeSortedArray mergeSorArr = new MergeSortedArray();
		int[] nums1 = {1,1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		
		mergeSorArr.merge(nums1, 4, nums2, 3);
		System.out.println(Arrays.toString(nums1));
		
		mergeSorArr.merge1(nums1, 4, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}
	
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1;
		int j = n-1;
		int p = m+n-1;
		while(i >= 0 && j >= 0 )
		{
			if(nums1[i] < nums2[j])
			{
				nums1[p] = nums2[j];
				j--;
			}
			else
			{
				nums1[p] = nums1[i];
				i--;
			}
			p--;
		}
		
		while(i >= 0)
		{
			nums1[p] = nums1[i];
			i--;
			p--;
		}
		
		while(j >= 0)
		{
			nums1[p] = nums2[j];
			j--;
			p--;
		}
	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m -1;
		int p2 = n-1;
		
		for(int p = m+n-1; p >= 0 ; p--)
		{
			if(p2 < 0)
			{
				break;
			}
			if(p1>= 0 && nums1[p1] > nums2[p2])
			{
				nums1[p] = nums1[p1];
				p1--;
			}
			else
			{
				nums1[p] = nums2[p2];
				p2--;
			}
		}
    }
}
