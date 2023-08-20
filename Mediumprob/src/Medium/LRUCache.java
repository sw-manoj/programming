package Medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ache {
	
	class Entry
	{
		int key;
		int value;
		Entry next;
		Entry prev;
		Entry(int k, int v)
		{
			key = k;
			value = v;
		}
	}
	
	Map<Integer, Entry> cache = new HashMap<>();
	int capacity;
	Entry head;
	Entry last;
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
    }
	
	private void remove(Entry entry)
	{
		if(entry.prev != null)
		{
        	entry.prev.next =  entry.next;
		}
		if(entry.next != null)
		{
        	entry.next.prev = entry.prev;
		}
		
		if(entry == head)
		{
			head = entry.next;
		}
		if(entry == last)
		{
			last = last.prev;
		}
		

	}
	
	private void updateHead(Entry entry)
	{
		entry.next = head;
		if(head != null)
		{
			head.prev = entry;
		}
		head = entry;
		head.prev = null;
		
		if(last == null)
		{
			last = head;
		}
	}
    
    public int get(int key) {
        Entry entry = cache.get(key);
        if(entry == null) return -1;
    	
        remove(entry);
        updateHead(entry);
        return entry.value;
    }
    
    public void put(int key, int value) {
    	
        if(cache.containsKey(key))
        {
        	Entry entry = cache.get(key);
        	entry.value = value;
        	remove(entry);
        	updateHead(entry);
        }
        else
        {
        	Entry entry = new Entry(key, value);
        	cache.put(key, entry);
        	if(head == null)
        	{
        		head = entry;
        		last = entry;
        	}else {
        	updateHead(entry);
        	}
        	if(cache.size() > capacity)
        	{
        		cache.remove(last.key);
//        		last = last.prev;
//        		last.next = null;
        		remove(last);
        		
        	}
        }
    }
	
    
    
    
    public static void main(String[] args) {
//    	LRUCache obj = new LRUCache(2);
//    	obj.put(1, 1);
//    	obj.put(2, 2);
//    	System.out.println(obj.get(1));
////    	System.out.println(obj.get(2));
//
//    	obj.put(3, 3);
////    	System.out.println(obj.cache);
//
//    	System.out.println(obj.get(2));
//    	obj.put(4, 4);
//    	System.out.println(obj.get(1));
//    	System.out.println(obj.get(3));
//    	System.out.println(obj.get(4));
    	
    	LRUCache obj = new LRUCache(1);
    	obj.put(2, 1);
    	System.out.println(obj.get(2));
    	obj.put(3, 2);
    	System.out.println(obj.get(2));
    	System.out.println(obj.get(3));
//
    	System.out.println(obj.cache);

    	System.out.println(obj.head.key);

    	System.out.println(obj.last.key);

	}
    private void main() {
    	

    	
    	
	}
}
