
package easyprob.tree;

import java.util.List;

public class IsSubTree {
	
//	https://leetcode.com/problems/subtree-of-another-tree/
	
	public static void main(String[] args) {
		TreeNode s = new TreeNode(3);
		 s.left = new TreeNode(4);
		 s.right = new TreeNode(5);

		 s.left.left = new TreeNode(1);
		 s.left.right = new TreeNode(2);
//		 s.left.right.right = new TreeNode(0);

		 TreeNode t = new TreeNode(4);
		 t.left = new TreeNode(1);
		 t.right = new TreeNode(2);
		IsSubTree obj = new IsSubTree();
		
		System.out.println(obj.isSubtree1(s, t));
	}
	
	public boolean isSubtree1(TreeNode s, TreeNode t) {
//        String tree1 = preorder(s, true);
//        String tree2 = preorder(t, true);
//        return tree1.indexOf(tree2) >= 0;
		
		String tree1 = postHelper(s, true);
        String tree2 = postHelper(t, true);
        return tree1.indexOf(tree2) >= 0;
    }
	
	private String postHelper(TreeNode t, boolean left)
	{
		if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
		
        return postHelper(t.left, true) + " " +postHelper(t.right, false) +t.val + "#" ;


	}
	
    public String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
    }

public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

private boolean isEqual(TreeNode s , TreeNode t)
{
	if(s == null && t == null)
	{
		return true;
	}else if(s == null || t == null)
	{
		return false;
	}
	return s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
}

private boolean traverse(TreeNode s , TreeNode t)
{
	return s!=null && (isEqual(s, t) || traverse(s.left, t) || traverse(s.right, t));
}
}
