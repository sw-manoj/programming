package segmenttree;

public class SegmentTreeSum {
	
	private int[] tree;
    private int maxsize;
    private int height;
    private int[] nums;
    private int[] lazy;
 
    private  final int STARTINDEX = 0; 
    private  final int ENDINDEX;
    private  final int ROOT = 0;
 
    public SegmentTreeSum(int[] num)
    {
    	this.nums = num;
    	int size = nums.length;
        height = (int)(Math.ceil(Math.log(size) /  Math.log(2)));
        maxsize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[maxsize];
        lazy = new int[maxsize];
        ENDINDEX = size - 1; 
    }
    
    private int getMid(int start, int end)
    {
    	return start + ((end-start)/2);
    }
    public int buildTree(int current, int start, int end, int nums[])
    {
    	if(start == end)
    	{
    		tree[current] = nums[start];
    		return tree[current];
    	}
    	
    	
    	int mid = getMid(start, end);
    	
    	tree[current] = buildTree(2*current+1, start, mid, nums) +  buildTree(2*current+2, mid+1, end, nums);
    	return tree[current];
    }
    
    private int query(int l , int r , int start, int end, int current)
    {
    	
    	if(lazy[current] != 0 )
    	{
    		tree[current] += (end-start + 1) * lazy[current];
    		if(start != end)
    		{
    			
    			lazy[2*current+1] += lazy[current];
    			lazy[2*current+2] += lazy[current];

    		}
    		lazy[current] = 0;
    	}
    	if(l <= start && end <= r)
    	{
    		return tree[current];
    	}
    	if(end < l || start > r)
    	{
    		return 0;
    	}
    	
    	int mid = getMid(start, end);
    	
    	return query(l, r, start, mid, 2 * current +1) + query(l, r, mid +1 , end, 2* current +2);
    			
    }
    
    public int queryRange(int l , int r)
    {
    	return query(l, r, STARTINDEX, ENDINDEX,0);
    }
    
    private void update(int pos, int value, int start, int end, int current)
    {
    	if(pos < start || end < pos)
    	{
    		return;
    	}
    	if ( start == end)
    	{
    		tree[current] = value;
    		nums[pos] = value;

    		return ;
    	}
//    	System.out.println(start + "==" + end + "==" +current);
    	tree[current] +=  value - nums[pos] ;
    	int mid = getMid(start, end);
    			
    	update(pos, value, start, mid, 2 * current +1);
    	update(pos, value, mid+1, end, 2 * current +2);
    	

    }
    public void update(int pos, int value)
    {
    	update(pos, value, STARTINDEX, ENDINDEX, 0);
    }
    
    
    private void rangeUpdate(int l , int r , int value, int start, int end, int current)
    {
    	if(end < l || start > r)
    	{
    		return;
    	}
    	if(lazy[current] != 0 )
    	{
    		tree[current] += (end-start + 1) * lazy[current];
    		if(start != end)
    		{
    			
    			lazy[2*current+1] += lazy[current];
    			lazy[2*current+2] += lazy[current];

    		}
    		lazy[current] = 0;
    	}
    	
    	if(l <= start && end <= r)
    	{
    		tree[current] += (end-start + 1) * value;
    		
    		if(start != end)
    		{
    			
    			lazy[2*current+1] += value;
    			lazy[2*current+2] += value;

    		}
    		return;
    	}
    	int mid = getMid(start, end);
    	rangeUpdate(l ,r , value, start, mid, 2* current + 1);
    	rangeUpdate(l ,r , value, mid+1, end, 2* current + 2);		
    	tree[current] = tree[2 * current+1] + tree[2* current+2];
    }
    public void rangeUpdate(int l , int r , int value)
    {
    	rangeUpdate(l, r, value, STARTINDEX, ENDINDEX, 0);
    }
    
    public void printTree()
    {
    	for(int t : tree)
		{
			System.out.print(t + " ");
			
		}
		System.out.println();
    }
    
    public static void main(String[] args) {
		int nums[] = {6,4,5,3,2,1};

		SegmentTreeSum obj = new SegmentTreeSum(nums);
		obj.buildTree(0, 0, nums.length-1, nums);
		
		obj.printTree();
		
		System.out.println(obj.queryRange(3, 4));
		System.out.println(obj.queryRange(1, 2));
		System.out.println(obj.queryRange(1, 4));
		System.out.println(obj.queryRange(0, 5));		
//		obj.update(0, 7);
//		obj.printTree();
//		obj.update(3, 6);
//		obj.printTree();
		obj.rangeUpdate(0, 3, 2);
		obj.printTree();
		System.out.println(obj.queryRange(3, 4));
		System.out.println(obj.queryRange(1, 2));
		System.out.println(obj.queryRange(1, 4));
		System.out.println(obj.queryRange(0, 5));



	}

}
