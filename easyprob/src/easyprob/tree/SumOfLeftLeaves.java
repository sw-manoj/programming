package easyprob.tree;


 //https://leetcode.com/problems/sum-of-left-leaves/

public class SumOfLeftLeaves {

	private int sum = 0;
    public int sumOfLeftLeaves1(TreeNode root) {
        helper(root, null);
        return sum;
    }
    
    private void helper(TreeNode root, TreeNode p){
        if(root == null)
            return;
        if(root.left == null && root.right == null && p != null && p.left == root)
            sum += root.val;
        helper(root.left, root);
        helper(root.right, root);
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
    if(root == null)
        return 0;
    
    
    
    return sum(root);
}

private int sum(TreeNode root) {
    if(root == null)
        return 0;
    
    //if its a left leaf
    if(root.left!=null && root.left.left == null && root.left.right == null)
        return root.left.val;
    
    return sum(root.left) + sum(root.right);
}

}
