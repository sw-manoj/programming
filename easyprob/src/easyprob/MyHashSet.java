package easyprob;

import java.util.LinkedList;
import java.util.List;

import easyprob.tree.TreeBST;
import easyprob.tree.TreeNode;
import easyprob.tree.TreeTraversal;

//https://leetcode.com/problems/design-hashset/submissions/
public class MyHashSet {
	
	
	public static void main(String[] args) {
		MyHashSet myset = new MyHashSet();
		myset.add(4);
		myset.add(5);
		myset.add(1);
		myset.add(5);
		myset.add(6);
		myset.add(7);
		myset.add(769);
		myset.add(770);

		myset.add(771);



		System.out.println(myset);
		System.out.println(myset.contains(4));
		System.out.println(myset.contains(3));
		
		myset.remove(5);
		myset.add(1539);

		System.out.println(myset);
		myset.remove(770);

		System.out.println(myset);
	}
	
	int keyRange = 769;
	BucketBST[] bucketlist;

	public MyHashSet() {
		bucketlist = new BucketBST[keyRange];
		for(int i = 0 ; i < keyRange ; i++)
		{
			bucketlist[i] = new BucketBST();
		}
    }
	
	private int hash(int key)
	{
		return key % keyRange;
	}
    
    public void add(int key) {
        int index = hash(key);
        bucketlist[index].insert(key);
    }
    
    public void remove(int key) {
    	int index = hash(key);
        bucketlist[index].delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	int index = hash(key);
        
    	return bucketlist[index].isExists(key);
    }
    
    @Override
    	public String toString() {
//    	List<Integer> res = new LinkedList<Integer>();
//	    	for(Bucket bucket : bucketlist)
//	    	{
//	    		res.addAll(bucket.list);
//	    	}
//    		return res.toString();
    	List<Integer> res = new LinkedList<Integer>();
    	for(BucketBST bucket : bucketlist)
    	{
    		res.addAll(bucket.traverse.inorderTraversal(bucket.tree.root));
    	}
		return res.toString();
    	}
    
    class Bucket{
    	LinkedList<Integer> list;
    	
    	public Bucket()
    	{
    		list = new LinkedList<>();
    	}
    	
    	public void insert(int key)
    	{
    		int index = this.list.indexOf(key);
    		if(index == -1)
    		{
    			this.list.addFirst(key);
    		}
    	}
    	
    	public void delete(int key)
    	{
    		this.list.remove((Integer)key);
    	}
    	
    	public boolean isExists(int key)
    	{
    		return this.list.indexOf(key) != -1;
    	}
    }
    
    class BucketBST{
    	TreeBST tree;
    	TreeTraversal traverse;

    	public BucketBST()
    	{
    		tree = new TreeBST();
    		traverse = new TreeTraversal();
    	}
    	
    	public void insert(int key)
    	{
    		this.tree.insert(key);
    	}
    	
    	public void delete(int key)
    	{
    		this.tree.delete((Integer)key);
    	}
    	
    	public boolean isExists(int key)
    	{
    		return this.tree.isExists(key);
    	}
    	@Override
    	public String toString() {
    		return tree.toString();
    	}
    }
    
    
    
}
