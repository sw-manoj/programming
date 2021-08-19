package com.samples.dfs.medium;

//https://leetcode.com/problems/implement-trie-prefix-tree/solution/
public class TrieTree {

	class Node{
		Node[] letter = new Node[27];

	}
	
	Node root;
	public TrieTree()
	{
		root = new Node();
	}
	
	public void insert(String word)
	{
		Node tmp = root;

		for(char c : word.toCharArray())
		{
			if(tmp.letter[c-'a'] == null)
			{
				tmp.letter[c-'a'] = new Node();
			}
			
			tmp = tmp.letter[c-'a'];
		}
		
		tmp.letter[26] = new Node();
	}
	
	public boolean search(String word) {
        
		Node tmp = root;

		for(char c : word.toCharArray())
		{
			if(tmp.letter[c-'a'] == null)
			{
				return false;
			}
			
			tmp = tmp.letter[c-'a'];
		}
		
		return tmp.letter[26] != null;
    }
	
	public boolean startsWith(String prefix) {
        
		Node tmp = root;

		for(char c : prefix.toCharArray())
		{
			if(tmp.letter[c-'a'] == null)
			{
				return false;
			}
			
			tmp = tmp.letter[c-'a'];
		}
		
		return true;
		
    }

	public static void main(String[] args) {
		char c = 'b';
		int i = c - 'a';
		System.out.println(c - 'a');
		
		TrieTree obj = new TrieTree();
		obj.insert("insert");
		obj.insert("search");
		
		System.out.println(obj.startsWith("inser"));
		System.out.println(obj.search("search"));
		System.out.println(obj.search("inser"));
		System.out.println(obj.startsWith("abc"));


	}
}
