package easyprob.tree;

public class MergeBinaryTree {

//	https://leetcode.com/problems/merge-two-binary-trees/
	
	public static void main(String[] args) {
		MergeBinaryTree obj = new MergeBinaryTree();
		
		TreeNode s = new TreeNode(3);
		 s.left = new TreeNode(4);
		 s.right = new TreeNode(5);

		 s.left.left = new TreeNode(1);
		 s.left.right = new TreeNode(2);
//		 s.left.right.right = new TreeNode(0);

		 TreeNode t = new TreeNode(4);
		 t.left = new TreeNode(1);
		 t.right = new TreeNode(2);
		 
		 TreeNode res = obj.mergeTrees(s, t);
		 
		 TreeTraversal traverse = new TreeTraversal();
		 System.out.println(traverse.preorderTraversal(res));
	}
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		
		return helper(root1, root2);
        
    }
	
	public TreeNode helper(TreeNode root1, TreeNode root2)
	{
		if(root1 == null)
		{
			return root2;
		}
		
		if(root2 == null)
		{
			return root1;
		}
		
		TreeNode node = new TreeNode(root2.val + root1.val);

		node.left = helper(root1.left, root2.left);
		node.right = helper(root1.right, root2.right);
		
		return node;
	}
}
