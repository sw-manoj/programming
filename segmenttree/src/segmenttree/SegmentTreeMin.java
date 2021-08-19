package segmenttree;

public class SegmentTreeMin {

	private int[] tree;
    private int maxsize;
    private int height;
    private int[] nums;
    private int[] lazy;
 
    private  final int STARTINDEX = 0; 
    private  final int ENDINDEX;
    private  final int ROOT = 0;
 
    public SegmentTreeMin(int[] num)
    {
    	this.nums = num;
    	int size = nums.length;
        height = (int)(Math.ceil(Math.log(size) /  Math.log(2)));
        maxsize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[maxsize];
        lazy = new int[maxsize];
        ENDINDEX = size - 1; 
        
        buildTree(STARTINDEX, ENDINDEX, ROOT);
		
    }
    
    private int getMid(int start, int end)
    {
    	return start + ((end-start)/2);
    }
    
    public int buildTree(int start, int end, int current)
    {
    	if(start == end)
    	{
//    		System.out.println("start" + start + "===" + current);
    		tree[current] = nums[start];
    		return tree[current];
    	}
    	
    	int mid = getMid(start, end);
    	
    	tree[current] = Math.min(buildTree(start, mid, 2*current + 1), buildTree(mid+1, end, 2*current + 2));
    	
    	return tree[current];
    }
    
    
    public int queryRange(int l, int r, int start, int end, int current)
    {
    	
    	if(lazy[current] != 0)
    	{
    		
    		tree[current] += lazy[current];
    		if(start != end)
    		{
    			lazy[2* current+1] += lazy[current];
    			lazy[2* current+2] += lazy[current];
    		}
    		lazy[current] = 0;
    	}
    	
    	if(l <= start && end <= r)
    	{
    		return tree[current];
    	}
    	
    	if(l > end || r < start)
    	{
    		return Integer.MAX_VALUE;
    	}
    	
//    	if(start == end)
//    	{
//    		return tree[current];
//    	}
    	int mid = getMid(start, end);
    	
//    	tree[current] = Math.min(queryRange(l, r, start, mid, 2*current + 1), queryRange(l, r, mid+1, end, 2*current + 2));
    	
    	return Math.min(queryRange(l, r, start, mid, 2*current + 1), queryRange(l, r, mid+1, end, 2*current + 2));
    }
    
    public int queryRange(int l, int r)
    {
    	return queryRange(l, r, STARTINDEX, ENDINDEX, ROOT);
    }
    
    public int update(int pos, int value, int start, int end, int current)
    {
    	if(start == end && start == pos)
    	{
    		nums[pos] = value;
    		tree[current] = value;
    		return tree[current];
    	}
    	
    	if(pos > end || pos < start)
    	{
    		return tree[current];
    	}
    	
    	int mid = getMid(start, end);
    	
    	tree[current] = Math.min(update(pos, value, start , mid , 2*current + 1), update(pos, value, mid+1, end, 2* current +2));
    	
    	return tree[current];
    }
    
    public void  update(int pos, int value)
    {
    	update(pos, value, STARTINDEX, ENDINDEX, ROOT);
    }
    
    public int updateRange(int l,int r, int value, int start, int end, int current)
    {
    	if(lazy[current] != 0)
    	{
    		
    		tree[current] += lazy[current];
    		if(start != end)
    		{
    			lazy[2* current+1] += lazy[current];
    			lazy[2* current+2] += lazy[current];
    		}
    		lazy[current] = 0;
    	}
    	if(l <= start && end <= r)
    	{
    		tree[current] = tree[current] + value;
    		
    		if(start != end)
    		{
    			lazy[2* current+1] += value;
    			lazy[2* current+2] += value;
    		}
    		return tree[current];
    	}
    	
    	if(l > end || r < start)
    	{
    		return tree[current];
    	}
    	
    	int mid = getMid(start, end);
    	
    	tree[current] = Math.min(updateRange(l, r , value, start , mid , 2*current + 1), updateRange(l, r, value, mid+1, end, 2* current +2));
    	
    	return tree[current];
    }
    
    public void  updateRange(int l, int r, int value)
    {
    	updateRange(l, r, value, STARTINDEX, ENDINDEX, ROOT);
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

		SegmentTreeMin obj = new SegmentTreeMin(nums);
		obj.printTree();
		
		System.out.println(obj.queryRange(2, 5));
		System.out.println(obj.queryRange(0, 3));
		System.out.println(obj.queryRange(3, 4));
		System.out.println(obj.queryRange(1, 4));
		
//		obj.update(2, 1);
//		obj.printTree();
//		System.out.println(obj.queryRange(0, 3));
		
		
		obj.updateRange(4, 5, 1);
		obj.printTree();
		System.out.println(obj.queryRange(0, 3));
		System.out.println(obj.queryRange(3, 5));


	}
}
