package com.samples.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AutocompleteSystem {
	
	class Node 
	{
		String sen;
		int times;
		Node(String s , int t)
		{
			sen = s;
			times =t;
		}
		
		
	}
	
	class Trie
	{
		Trie[] branches = new Trie[27];
		int times;
		
	}
	
	Trie root;


    public AutocompleteSystem(String[] sentences, int[] times) {
    	
    	root = new Trie();
    	for(int i = 0 ; i < sentences.length ; i ++)
    	{
    		insert(sentences[i], times[i], root);
    	}
        
    }
    public int int_(char c) {
        return c == ' ' ? 26 : c - 'a';
    }
    
    Trie currNode;
    String currStr = "";
    boolean readFromRoot = true;
    public List<String> input(char c) {
    	List<String> res = new ArrayList<String>();
    	if(c == '#')
    	{
    		insert(currStr, 1, root);
    		currStr = "";
    		currNode = null;
    		readFromRoot = true;
    	}
    	else
    	{
    		currStr += c;
    		List<Node> list = lookUp(currStr, readFromRoot ? root : currNode,  c);
    		readFromRoot = false;
    		Collections.sort(list, (a, b) -> a.times == b.times ? a.sen.compareTo(b.sen) : b.times - a.times);
            for (int i = 0; i < Math.min(3, list.size()); i++)
                res.add(list.get(i).sen);
    	}
    	return res;
    	
    }
    


    
    public void insert(String s, int times,Trie trie )
    {
    	for(int i = 0 ; i < s.length() ; i++)
    	{
    		if(trie.branches[int_(s.charAt(i))] == null)
    		{
    			trie.branches[int_(s.charAt(i))] = new Trie();
    		}
    		trie = trie.branches[int_(s.charAt(i))];
    	}
    	trie.times += times;
    	
    }
    
    private List<Node> lookUp(String s,Trie trie, char c)
    {
//    	for(int i = 0 ; i < s.length() ; i++)
//    	{
//    		if(trie.branches[int_(s.charAt(i))] == null)
//    		{
//    			return new ArrayList<AutocompleteSystem.Node>();
//    		}
//    		trie = trie.branches[int_(s.charAt(i))];
//    	}
    	if(trie == null )
    	{
    		return new ArrayList<AutocompleteSystem.Node>();
    	}
    	trie = trie.branches[int_(c)];
    	currNode = trie;
    	System.out.println(c + "===" + s);
    	if(trie == null)
    	{
    		System.out.println(c + "=null==" + s);
//    		currNode = null;
    		return new ArrayList<AutocompleteSystem.Node>();
    	}
    	
    	List<Node> list= new ArrayList<Node>();
    	traverse(list, s, trie);
    	return list;
    }
    
    private void traverse(List<Node> list ,String s, Trie trie)
    {
    	if(trie.times > 0)
    	{
    		list.add(new Node(s, trie.times));
    	}
    	for(char i = 'a' ; i <= 'z' ; i++)
    	{
    		if(trie.branches[int_(i)] != null)
    		{
    			traverse(list, s + i, trie.branches[int_(i)]);
    		}
    	}
    	
    	if(trie.branches[26] != null)
    	{
    		traverse(list, s + ' ', trie.branches[26]);
    	}
    }
    
    public static void main(String[] args) {
    	String[] s = {"i love you","island","iroman","i love leetcode"};
    	int[] t = {5,3,2,2};
		AutocompleteSystem system = new AutocompleteSystem(s,t) ;
		System.out.println(system.input('i'));
		System.out.println(system.input('r'));
		System.out.println(system.input('o'));
		System.out.println(system.input('#'));
	}
}
