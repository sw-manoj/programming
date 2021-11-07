package com.samples.dfs.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/word-search-ii/submissions/
class Trie
{
	Map<Character, Trie> children = new HashMap<Character, Trie>();
	String word;
}
public class FindWordsPuzzle {

public List<String> findWords(char[][] board, String[] words) {
	List<String> result = new ArrayList<String>();
	Trie root = new Trie();
	
	//building trie for all words to be found in puzzle board
	for(String s : words)
	{
		Trie node = root;
		for(char ch : s.toCharArray())
		{
			if(!node.children.containsKey(ch))
			{
				node.children.put(ch, new Trie());
			}
			node = node.children.get(ch);

		}
		//denotes end of word
		node.word = s;
	}
	
	// traverse all board to find the words.
	for(int i = 0 ; i < board.length ; i++)
	{
		for(int c = 0 ; c < board[0].length; c++)
		{
			backtrack(board, i, c, root, result);
		}
	}
	return result;
    }

	int[] rowIndex = {-1,0,1,0};
	int[] colIndex = {0,-1,0,1};
	void backtrack(char[][] board , int row, int col , Trie trie, List<String> result)
	{
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
		{
			return;
		}
		char letter = board[row][col];
		
		if(!trie.children.containsKey(letter))
		{
			return;
		}
		
		Trie currTrie = trie.children.get(letter);
		
		if(currTrie.word != null)
		{
			// if word is matched add it to result and make it null so that it is not reference again.
			result.add(currTrie.word);
			currTrie.word = null;
		}
		
		//setting to # so that it not traversed again in recursive call, once all the nodes are traversed we can reassign the letter
		board[row][col] = '#';
	
		for(int i = 0 ; i < 4 ;i ++)
		{
			int newRow = row + rowIndex[i];
			int newCol = col + colIndex[i];
			
			backtrack(board, newRow, newCol, currTrie, result);

		}
		
		board[row][col] = letter;
		
		// if currTrie has no child means word is found and the parent trie can remove this letter. as its already traversed.
		if(currTrie.children.isEmpty())
		{
			trie.children.remove(letter);
		}
	}
	
	public static void main(String[] args) {
		String[][] board = {{"o","a","a","n"},{"e","t","a","e"},{"i","h","k","r"},{"i","f","l","v"}};
		String[] words = {"oath","pea","eat","rain"};
		
		FindWordsPuzzle obj = new FindWordsPuzzle();
		System.out.println(obj.findWords(strToChar(board), words));
	}
	
	static char[][] strToChar(String[][] b)
	{
		char[][] board = new char[b.length][b[0].length];
		
		for(int i = 0 ; i < b.length ;i++)
		{
			for(int j = 0 ; j < b[0].length ;j++)
			{
				board[i][j]= b[i][j].toCharArray()[0];
			}
		}
		
		return board;
	}
}
