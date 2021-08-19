package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//https://leetcode.com/problems/find-the-celebrity/solution/
	
//
//[[1,1,0],[0,1,0],[1,1,1]]
//[[1,1,1],[1,1,0],[0,0,1]]
public class FindCelebrity {

	Map<Integer, Integer> knowMap = new HashMap<>(){{
        put(1, 0);
        put(0, 1);
//        put(2, 1);
//        put(2,0);
    }};
    
    public static void main(String[] args) {
		FindCelebrity obj = new FindCelebrity();
		System.out.println(obj.findCelebrity(2));
	}
    
    
	private int knows(int a , int b)
	{
		if(knowMap.get(a) == null) return 0;
		return knowMap.get(a) == b ? 1 : 0;
	}
	
	class Node{
		List<Integer> list;
		boolean knowsAnyone;
		public Node()
		{
			list = new ArrayList<>();
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[" + knowsAnyone + "==" + list + "]";
		}
	}
	
	public int findCelebrity(int n) {
		if( n == 1)
		{
			return 0;
		}

        Map<Integer, Node> cache = new HashMap<>();
        for (int i = 0; i < n ;i++)
		{
        	for(int j = i +1; j < n ; j++)
        	{
	        	if(knows(j, i) == 1 )
	        	{
	        		addMap(j, i, cache);
	        	}
	        	
	        	if(knows(i, j) == 1 )
	        	{
	        		addMap(i, j, cache);

	        	}
        	}
		}
        System.out.println(cache);
        if(cache.size() == 0)
        {
        	return -1;
        }
        for(Entry<Integer, Node> entry : cache.entrySet())
        {
        	if(!entry.getValue().knowsAnyone && entry.getValue().list.size() == n-1)
        	{
        		return entry.getKey();
        	}
        }
        
        return -1;
    }
	
	private void addMap(int a, int b, Map<Integer, Node> cache)
	{
		Node node = cache.get(b);
		if(node == null)
		{
			node = new Node();
			
			cache.put(b, node);
		}
		
		cache.get(b).list.add(a);
		
		Node knowsNode = cache.getOrDefault(a, new Node());
		knowsNode.knowsAnyone = true;
		cache.put(a, knowsNode);
	}
	
	public int findCelebrity1(int n) {
		
		int cel = 0;
		
		for(int i = 0 ; i < n ; i++)
		{
			if(knows(i, cel) == 0)
			{
				cel = i;
			}
		}
		for(int i = 0 ; i < n ; i++)
		{
			if(i == cel) continue;
			if(knows(cel,i) == 1 || knows(i,cel) == 0)
			{
				return -1;
			}
		}
		
		return cel;
	}
}
