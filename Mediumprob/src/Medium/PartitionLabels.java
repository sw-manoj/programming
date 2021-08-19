package Medium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


//https://leetcode.com/problems/partition-labels/submissions/
public class PartitionLabels {
	
	public List<Integer> partitionLabels(String s) {
        int[] lastChar = new int[26];
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++ )
        {
        	lastChar[s.charAt(i)- 'a'] = i;
        }
        
        int lastCharIndex = 0;
        int partitionIndex = 0;
        for(int i = 0 ; i < s.length() ; i++ )
        {
        	
        	
        	if(lastCharIndex < lastChar[s.charAt(i)- 'a'])
        	{
        		lastCharIndex = lastChar[s.charAt(i)- 'a'];
        	}
        	
        	if(lastCharIndex == i)
        	{
        		res.add(i - partitionIndex + 1);
        		partitionIndex = i+1;
        	}
        }
        
        return res;
    }
	
	public List<Integer> partitionLabels_mergeinterval(String s) {

        List<Integer> res = new ArrayList<>();

        LinkedHashMap<Character, int[]> intervals = new LinkedHashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++)
        {
        	if(!intervals.containsKey(s.charAt(i)))
        	{
        		intervals.put(s.charAt(i), new int[] {i, i});
        	}else
        	{
        		intervals.get(s.charAt(i))[1] = i;
        	}
        }
        
        
        int prevEnd = 0;
        int prevStart = 0;
        
        for( Entry<Character, int[]> entry : intervals.entrySet())
        {
        	if(prevEnd < entry.getValue()[0] )
        	{
        		res.add(prevEnd - prevStart +1);
        		prevStart = entry.getValue()[0];
        		prevEnd = entry.getValue()[1];
        	}
        	else if(prevEnd < entry.getValue()[1])
        	{
        		prevEnd = entry.getValue()[1];
        	}
        	
        }
        System.out.println(prevEnd + "==" + prevStart) ;
		res.add(prevEnd - prevStart +1);

        return res;
	}
	
	public static void main(String[] args) {
		PartitionLabels obj = new PartitionLabels();
//		System.out.println(obj.partitionLabels("ababcbacadefegdehijhklij"));
//		System.out.println(obj.partitionLabels("eccbbbbdec"));
//		System.out.println(obj.partitionLabels("eaaaabaaec"));
//
//		System.out.println(obj.partitionLabels_mergeinterval("ababcbacadefegdehijhklij"));
//		System.out.println(obj.partitionLabels_mergeinterval("eccbbbbdec"));
		System.out.println(obj.partitionLabels_mergeinterval("eaaaabaaec"));

	}

}
