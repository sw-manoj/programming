package com.samples.random;

import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Codec {

	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s= new StringBuilder();
    	helper(root, s);
    	return s.toString();
    }
    
    private void helper(TreeNode tree, StringBuilder s)
    {
    	Queue<TreeNode> queue = new LinkedBlockingQueue<Codec.TreeNode>();
    	queue.add(tree);
    	while(!queue.isEmpty())
    	{
    		TreeNode curnode = queue.poll();
    		s.append(String.format("%3s", curnode.val));
    		if(curnode.left != null) queue.add(curnode.left);
    		if(curnode.right != null )queue.add(curnode.right);
    	}
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	System.out.println(Integer.parseUnsignedInt(data));
    	return new TreeNode(4);
    }
    
}
