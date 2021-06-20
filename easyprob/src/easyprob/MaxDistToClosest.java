package easyprob;

//https://leetcode.com/problems/maximize-distance-to-closest-person/
public class MaxDistToClosest {

	public int maxDistToClosest(int[] seats) {
        int maxDist = 0;
        int prevIndex = -1;
        
        for(int i = 0 ; i < seats.length ; i++)
        {
        	if(seats[i] == 1)
        	{
        		if(prevIndex == -1)
        		{
        			maxDist = Math.max(maxDist, i);

        		}else {
        			
        			maxDist = Math.max(maxDist, (i-prevIndex)/2);
        		}
        		prevIndex = i;
        	}
        }
        
        maxDist = Math.max(maxDist, seats.length-1-prevIndex);

        return maxDist;
    }
	
	public static void main(String[] args) {
		MaxDistToClosest obj = new MaxDistToClosest();
		
		System.out.println(obj.maxDistToClosest(new int[] {1,0,0,0,1,0,1}));
		System.out.println(obj.maxDistToClosest(new int[] {1,0,0,1,0,1}));
		System.out.println(obj.maxDistToClosest(new int[] {1,0,0,0}));

		System.out.println(obj.maxDistToClosest(new int[] {0,0,0,1}));

	}
}
