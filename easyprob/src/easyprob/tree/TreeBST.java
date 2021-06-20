package easyprob.tree;

public class TreeBST
{
	public TreeNode root;
	
	public TreeBST()
	{
	}
	
	private TreeNode insert(TreeNode root, int key)
	{
		if(root == null)
		{
			root = new TreeNode(key);
			return root;
		}
		
    		if(root.val  > key)
    		{
    			root.left = insert(root.left, key);
    		}else if(root.val < key)
    		{
    			root.right = insert(root.right, key);
    		}
    		else {
    			return root;
    		}
		return root;
	}
	
	public void insert(int key)
	{
		root = insert(this.root, key);
	}
	

	private int rightChild(TreeNode node)
	{
		while(node.left != null)
		{
			node = node.left;
		}
		return node.val;
	}
	
	private int leftChild(TreeNode node)
	{
		while(node.right != null)
		{
			node = node.right;
		}
		return node.val;
	}
	
	public void delete(int key)
	{
		this.root = delete(this.root, key);
	}
	
	private TreeNode delete(TreeNode root, int key)
	{
		if(root == null)
		{
			return root;
		}
		if(root.val  > key)
		{
			root.left = delete(root.left, key);
		}else if(root.val < key)
		{
			root.right = delete(root.right , key);
		}
		else {
			if(root.left == null && root.right == null)
			{
				return null;
			}
			else if(root.right != null)
			{
				root.val = rightChild(root.right);
				root.right = delete(root.right, root.val);
			}
			else {
				root.val = leftChild(root.left);
				root.left = delete(root.left, root.val );
			}
//			return true;
		}
		
		return root;
	}
	private boolean isExists(TreeNode root, int key)
	{
		if(root == null)
		{
			return false;
		}
		if(root.val  > key)
		{
			return isExists(root.left, key);
		}else if(root.val < key)
		{
			return isExists(root.right , key);
		}
		else {
			return true;
		}
	}
	public boolean isExists(int key)
	{
		return isExists(root, key);
	}
	
}
