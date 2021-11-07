package easyprob;


final class TreeInfo {
	  public final int height;
	  public final boolean balanced;

	  public TreeInfo(int height, boolean balanced) {
	    this.height = height;
	    this.balanced = balanced;
	  }
	}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BalancedTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
//		root.left.left.right = new TreeNode(5);
		
		
		BalancedTree tree = new BalancedTree();
		System.out.println(tree.isBalanced(root));
	}
	
	TreeInfo helper(TreeNode node)
	{
		if(node == null)
		{
			return new TreeInfo(-1, true);
		}
		
		TreeInfo left = helper(node.left);
		if(!left.balanced)
		{
			return left;
		}
		TreeInfo right = helper(node.right);
		if(!right.balanced)
		{
			return right;
		}
		
		if(Math.abs(left.height - right.height) < 2)
		{
			return new TreeInfo(Math.max(left.height, right.height) + 1, true);
		}
		return new TreeInfo(-1, false);
	}
	public boolean isBalanced1(TreeNode root) {
        
	return helper(root).balanced;
    }
	
	public boolean isBalanced(TreeNode root) {
        return height(root) != -2;
    }
    
    private int height(TreeNode root) {
        if (root == null)
            return -1;
        
        int left = height(root.left);
        int right = height(root.right);
        if (left != -2 && right != -2) {
            if (Math.abs(left-right) <= 1)
                return 1 + Math.max(left, right);
        }
        
        return -2;
    }
}
