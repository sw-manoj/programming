package Medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheOpt {

	class Entry {
		int key;
		int value;
		Entry next;
		Entry prev;

		Entry() {
		}

		Entry(int k, int v) {
			key = k;
			value = v;
		}
	}

	Map<Integer, Entry> cache = new HashMap<>();
	int capacity;
	Entry head;
	Entry last;

	public LRUCacheOpt(int capacity) {
		this.capacity = capacity;
		head = new Entry();
		last = new Entry();

		head.next = last;
		last.prev = head;
	}

	private void remove(Entry entry) {
		entry.prev.next = entry.next;
		entry.next.prev = entry.prev;
	}

	private void addToTop(Entry entry) {
		head.next.prev = entry;
		entry.next = head.next;
		head.next = entry;
		entry.prev = head;

	}

	private Entry popTail() {
		Entry res = last.prev; // expect min one element to be present , otherwise prev can point to head which
								// shouldnt be removed at any case.
		remove(res);
		return res;
	}

	public int get(int key) {
		Entry entry = cache.get(key);
		if (entry == null)
			return -1;

		remove(entry);
		addToTop(entry);
		return entry.value;
	}
	
	 public void put(int key, int value) {
		 Entry entry = cache.get(key);
		 
		 if(entry == null)
		 {
			 Entry newEntry = new Entry(key, value);
			 cache.put(key, newEntry);
			 addToTop(newEntry);
			 if(capacity < cache.size())
			 {
				 Entry last = popTail();
				 cache.remove(last.key);
			 }
		 }else
		 {
			 entry.value = value;
			 remove(entry);
			 addToTop(entry);
		 }
	 }

	 public static void main(String[] args) {
		 	LRUCacheOpt obj = new LRUCacheOpt(2);
	    	obj.put(1, 1);
	    	obj.put(2, 2);
	    	System.out.println(obj.get(1));
//	    	System.out.println(obj.get(2));
	
	    	obj.put(3, 3);
//	    	System.out.println(obj.cache);
	
	    	System.out.println(obj.get(2));
	    	obj.put(4, 4);
	    	System.out.println(obj.get(1));
	    	System.out.println(obj.get(3));
	    	System.out.println(obj.get(4));
	    	
//		 	LRUCache2ndTry obj = new LRUCache2ndTry(1);
//	    	obj.put(2, 1);
//	    	System.out.println(obj.get(2));
//	    	obj.put(3, 2);
//	    	System.out.println(obj.get(2));
//	    	System.out.println(obj.get(3));
	//
	    	System.out.println(obj.cache);

	    	System.out.println(obj.head.key);

	    	System.out.println(obj.last.key);

		}
}
