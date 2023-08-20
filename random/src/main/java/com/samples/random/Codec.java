package com.samples.random;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
    public String serialize1(TreeNode root) {
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


	public String rserialize(TreeNode root, String str) {
		// Recursive serialization.
		if (root == null) {
			str += "null,";
		} else {
			str += str.valueOf(root.val) + ",";
			str = rserialize(root.left, str);
			str = rserialize(root.right, str);
		}
		return str;
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return rserialize(root, "");
	}

    // Decodes your encoded data to tree.
	public TreeNode rdeserialize(List<String> l) {
		// Recursive deserialization.
		if (l.get(0).equals("null")) {
			l.remove(0);
			return null;
		}

		TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
		l.remove(0);
		root.left = rdeserialize(l);
		root.right = rdeserialize(l);

		return root;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] data_array = data.split(",");
		List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
		return rdeserialize(data_list);
	}
    
}
