package easyprob;


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
 
  

public class SameTree {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
//		p.right.right = new TreeNode(3);
		
		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);
		
		SameTree sameTree = new SameTree();
		System.out.println(sameTree.isSameTree(p, q));
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        
		if( (p == null && q == null))
		{
			return true;
		}
		
		if(p == null || q == null || p.val != q.val)
		{
			return false;
		}
		
		
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
