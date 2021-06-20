package com.samples.binarytree;

public class ClosetNum {
	
	public static void main(String[] args) {
		
		
		double target = -15.0;
		int res = (int) Math.round(target);
		System.out.println(res);
		
		int in = 14;
		double diff = (res <  in) ? in  - res : res-in;
		System.out.println(diff);
	}
	public int closestValue(TreeNode root, double target) {
		TreeNode tmp = root;
        int lastClosetNum = Integer.MAX_VALUE;
        double lastCloseDiff = Double.MAX_VALUE;
        int res = (int) Math.round(target);
		while(tmp != null)
		{
			if(tmp.val == res)
			{
				return tmp.val;
			}
			double diff = (res <  tmp.val) ? tmp.val  - res : res-tmp.val;
			if(diff < lastCloseDiff)
			{
				lastCloseDiff = diff;
				lastClosetNum = tmp.val;
			}
			if(tmp.val < res)
			{
				tmp = tmp.right;
			}
			else if(tmp.val > res)
			{
				tmp = tmp.left;
			}
			
		}
		return lastClosetNum;
    }
}


  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
    TreeNode(int x) { val = x; }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return val + "=>" + left + ":" + right;
    }
  }

