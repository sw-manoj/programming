package easyprob.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
        
		List<Integer> res = new ArrayList<Integer>();
		preHelper(root, res);
		return res;
    }
	
	private void preHelper(TreeNode node, List<Integer> res)
	{
		if(node == null)
		{
			return;
		}
		
		res.add(node.val);
		preHelper(node.left, res);
		
		preHelper(node.right, res);

	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        
		List<Integer> res = new ArrayList<Integer>();
		traverse(root, res);
		return res;
    }
	
	private void traverse(TreeNode node, List<Integer> res)
	{
		if(node == null)
		{
			return;
		}
		
		traverse(node.left, res);
		
		res.add(node.val);
		traverse(node.right, res);

	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
        
		List<Integer> res = new ArrayList<Integer>();
		postHelper(root, res);
		return res;
    }
	
	private void postHelper(TreeNode node, List<Integer> res)
	{
		if(node == null)
		{
			return;
		}
		
		postHelper(node.left, res);
		
		postHelper(node.right, res);
		res.add(node.val);

	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		
		TreeTraversal inorder = new TreeTraversal();
		
		System.out.println(inorder.preorderTraversal(root));
	}
}
