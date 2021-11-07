package topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/sequence-reconstruction/
public class SequenceReconstruction {

	
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		Set<Integer> set = new HashSet<>();
		
		for(List l : seqs)
		{
			set.addAll(l);
		}
		if(org.length != set.size()) return false;
		for(int num  : org)		
		{
			if(!set.contains(num))
			{
				return false;
			}
		}
		Map<Integer, List<Integer>> adjMap = new HashMap<>();
		
		
		
		int[] inDegArr = new int[org.length];
		
		for(int i = 0 ; i  < seqs.size();i++)
		{
			List<Integer> seq = seqs.get(i);
			for(int j = 0; j < seq.size();j++)
			{
				if(j == 0)
				{
					adjMap.computeIfAbsent(seq.get(j), k -> new ArrayList());
					continue;
				}
				adjMap.computeIfAbsent(seq.get(j-1), k -> new ArrayList()).add(seq.get(j));
//				adjMap.computeIfAbsent(key, mappingFunction)
				inDegArr[seq.get(j) -1]++;
			}
		}
//		System.out.println(adjMap);
		Queue<Integer> queue = new LinkedList<>();
		
		for (Integer node : adjMap.keySet()) {
	        if (inDegArr[node-1] == 0) {
	            queue.offer(node);
	            
	        }
	    }
		
//		System.out.println(adjMap);
//		int i = 0;
//		for(int num : inDegArr)
//		{
//			if(num == 0)
//			{
//				queue.offer(i+1);
//			}
//			i++;
//		}
		
		
		if(queue.isEmpty()) return false;
		
		int[] res = new int[org.length];
		int orgSeqCount = 0;
		while(!queue.isEmpty())
		{
			if(queue.size() > 1) return false;
			
			int vertex = queue.poll();
//			System.out.println(vertex);
			if(org[orgSeqCount] != vertex) return false;
			
			res[orgSeqCount] = vertex;
			
			orgSeqCount++;
			if(adjMap.containsKey(vertex))
			{
				for(int adjVer : adjMap.get(vertex))
				{
					inDegArr[adjVer-1]--;
					if(inDegArr[adjVer-1] == 0)
					{
//						System.out.println(adjVer);
						queue.offer(adjVer);
					}
				}
			}
		}
		
		for(int j = 0 ;  j < res.length ; j++)
		{
			if(res[j] != org[j])
			{
				return false;
			}
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		SequenceReconstruction obj = new SequenceReconstruction();
		System.out.println(obj.sequenceReconstruction(new int [] {1,2,3}, Arrays.asList(Arrays.asList(1,2), Arrays.asList(1,3),Arrays.asList(2, 3))));
		System.out.println(obj.sequenceReconstruction(new int [] {1,2,3}, Arrays.asList(Arrays.asList(1,2), Arrays.asList(1,3))));
		System.out.println(obj.sequenceReconstruction(new int [] {4,1,5,2,6,3}, Arrays.asList(Arrays.asList(5,2,6,3), Arrays.asList(4,1,5,2))));
		System.out.println(obj.sequenceReconstruction(new int [] {1,2,3,4}, Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(3,4),Arrays.asList(4,3))));
		System.out.println(obj.sequenceReconstruction(new int [] {1}, Arrays.asList(Arrays.asList(2))));
		System.out.println(obj.sequenceReconstruction(new int [] {1}, Arrays.asList(Arrays.asList(1),Arrays.asList(1))));


	}
}
