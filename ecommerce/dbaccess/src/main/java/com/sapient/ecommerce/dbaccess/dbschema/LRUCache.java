package com.sapient.ecommerce.dbaccess.dbschema;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class Node
	{
		int val;
		int key;
		Node next;
		Node prev;
		
		Node(int k , int v)
		{
			key = k;
			val = v;
		}
	}
	int maxSize;
	Map<Integer, Node> cache = new HashMap<Integer, LRUCache.Node>();
	Node head;
	Node tail;
	int curSize = 0;
	public LRUCache(int capacity) {
       maxSize = capacity; 
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
        {
        	return -1;
        }
        Node node = cache.get(key);
        
        removeNode(node);
        offerNode(node);
//        if(node != head) //in else part since its already in head no action need
//        {
//	        Node prev = node.prev;
//	        if(prev != head)
//	        {
//	        	if (prev != null) prev.next = node.next;
//	        	if(node.next != null ) node.next.prev = prev;
//	        
//	        }
//	        else// just 2 nodes , swap pointer between head and tail
//	        {
//	        	head.prev = node;
//	        	tail = head;
//	        }
//	        node.next = head;
//	        node.prev = null;
//	        head = node;
//	        }
//	        else
//	        {
//	        	
//	        	node.next = head;
//	 	        node.prev = null;
//	 	        head = node;
//	        }
//        }
        
        return node.val;
    }
    
    private void offerNode(Node node)
    {
    	if(head != null )
        {
        	head.prev = node;
        }
    	node.next = head;
    	node.prev = null;
        head = node;
        
        
        if(tail == null)
        {
        	tail = head;
        }
    }
    
    private void removeNode(Node n){
        if(n.prev!=null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.prev = n.prev;
        }else{
            tail = n.prev;
        }
    }
    
    public void put(int key, int value) {
    	if(maxSize == 0)
    	{
    		return;
    	}
    	Node node = new Node(key, value);
        if(cache.containsKey(key))
        {
        	node = cache.get(key);
        	node.val = value;
        	removeNode(node);
        	offerNode(node);
        }
        else
        {
        if(cache.size() >= maxSize)
        {
        	cache.remove(tail.key);
        	removeNode(tail);
        }
        offerNode(node);
        cache.put(key, node);
        
        
        }
    }
    public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
//		cache.put(2, 1);
//		cache.put(3, 3);
//		System.out.println(cache.tail.key);//2
//		cache.put(2, 2);
//		System.out.println(cache.tail.key);//3
//		cache.put(4, 4);
//		System.out.println(cache.get(2));//2
//		System.out.println(cache.get(3));//-1
//		System.out.println(cache.get(4));//4
		
		
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));//1
		System.out.println("key" + cache.tail.key);
		cache.put(3, 3);
		System.out.println("key" + cache.tail.key);
		System.out.println(cache.get(2));//2
		cache.put(4, 4);
		System.out.println(cache.get(1));//-1
		System.out.println(cache.get(3));//3
		System.out.println(cache.get(4));//4

	}
}
