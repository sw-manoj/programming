package Medium.mergelist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

class Node{
	int sum,i,j,a,b;
	Node(int s , int i , int j , int a, int b)
	{
		this.sum = s;
		this.i=i;
		this.j=j;
		this.a=a;
		this.b=b;
	}
}
public class FindKSmallestPair {

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<>();
		
		PriorityQueue<Node> queue = new PriorityQueue<>( (n1,n2) -> n1.sum - n2.sum);
		int i = 0, j = 0;
		
		while(i< nums1.length)
		{
			queue.add(new Node(nums1[i] + nums2[j] ,i , j , nums1[i], nums2[j]));
			i++;
		}
		
		while(!queue.isEmpty())
		{
			Node node = queue.poll();
			result.add(Arrays.asList(node.a, node.b));
			
			if(result.size() == k)
			{
				break;
			}
			if(node.j+1 < nums2.length)
			{
				node.j++;
				queue.add(new Node(nums1[node.i] + nums2[node.j] ,node.i , node.j , nums1[node.i], nums2[node.j]));

			}
			
		}
		return result;
    }
	
	public static void main(String[] args) {
		FindKSmallestPair obj = new FindKSmallestPair();
		System.out.println(obj.kSmallestPairs(new int[] {1,7,11}, new int[] {2,4,6}, 3));
		
		System.out.println(obj.kSmallestPairs(new int[] {1,1,2}, new int[] {1,2,3}, 10));
		System.out.println(obj.kSmallestPairs(new int[] {1,2}, new int[] {3}, 3));


	}
}
