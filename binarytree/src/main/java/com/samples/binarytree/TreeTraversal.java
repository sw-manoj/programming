package com.samples.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

	class NodeState {
		TreeNode node;
		int state;

		public NodeState(TreeNode node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public List<Integer> preorderTraversal_iter(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		Stack<NodeState> stack = new Stack<TreeTraversal.NodeState>();
		stack.push(new NodeState(root, 0));

		while (!stack.isEmpty()) {
			NodeState state = stack.peek();

			if (state.state == 0)
				res.add(state.node.val);

			else if (state.state == 1) {
				if (state.node.left != null) {
					stack.push(new NodeState(state.node.left, 0));
				}
			} else if (state.state == 2) {
				if (state.node.right != null) {
					stack.push(new NodeState(state.node.right, 0));
				}
			} else {
				stack.pop();
			}
			state.state += 1;
		}
		return res;
	}

	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		preHelper(root, res);
		return res;
	}

	private void preHelper(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}

		res.add(node.val);
		preHelper(node.left, res);

		preHelper(node.right, res);

	}

	public List<Integer> inorderTraversal_iter(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		Stack<NodeState> stack = new Stack<TreeTraversal.NodeState>();
		stack.push(new NodeState(root, 0));

		while (!stack.isEmpty()) {
			NodeState state = stack.peek();

			if (state.state == 0) {
				if (state.node.left != null) {
					stack.push(new NodeState(state.node.left, 0));
				}

			}

			else if (state.state == 1) {
				res.add(state.node.val);
			} 
			else if (state.state == 2) {
				if (state.node.right != null) {
					stack.push(new NodeState(state.node.right, 0));
				}
			} else {
				stack.pop();
			}
			state.state += 1;
		}
		return res;
	}

	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		traverse(root, res);
		return res;
	}

	private void traverse(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}

		traverse(node.left, res);

		res.add(node.val);
		traverse(node.right, res);

	}
	
	public List<Integer> postorderTraversal_iter(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		Stack<NodeState> stack = new Stack<TreeTraversal.NodeState>();
		stack.push(new NodeState(root, 0));

		while (!stack.isEmpty()) {
			NodeState state = stack.peek();

			if (state.state == 0) {
				if (state.node.left != null) {
					stack.push(new NodeState(state.node.left, 0));
				}

			}
			else if (state.state == 1) {
				
				if (state.node.right != null) {
					stack.push(new NodeState(state.node.right, 0));
				}
			} 
			else if (state.state == 2) {
				res.add(state.node.val);
			} else {
				stack.pop();
			}
			state.state += 1;
		}
		return res;
	}

	public List<Integer> postorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		postHelper(root, res);
		return res;
	}

	private void postHelper(TreeNode node, List<Integer> res) {
		if (node == null) {
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

//		System.out.println(inorder.preorderTraversal(root));
//
//		System.out.println(inorder.preorderTraversal_iter(root));
//		
//		System.out.println(inorder.inorderTraversal(root));
//
//		System.out.println(inorder.inorderTraversal_iter(root));
//		
//		System.out.println(inorder.postorderTraversal(root));
//
//		System.out.println(inorder.postorderTraversal_iter(root));
		
		TreeNode node = inorder.traverse(new int[] {2,1,0,5,0,0,3,4,0,0,0});
		System.out.println(inorder.preorderTraversal(node));

	}
	
	int index;
	 TreeNode traverse(int[] preArr)
	{
		if(preArr[index] == 0)
		{
		return null;
		}
		TreeNode node = new TreeNode(preArr[index]);
		index++;
		node.left = traverse(preArr);
		index++;
		node.right = traverse(preArr);

		return node;

	}
}
