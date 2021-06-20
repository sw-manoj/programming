package easyprob;

public class HammingDist {

//	https://leetcode.com/problems/hamming-distance/
	 public int hammingDistance(int x, int y) {
		    int xor = x ^ y;
		    int distance = 0;
		    while (xor != 0) {
		      distance += 1;
		      // remove the rightmost bit of '1'
		      xor = xor & (xor - 1);
		    }
		    return distance;
		  }
		    
		     public int hammingDistance1(int x, int y) {
		        return Integer.bitCount(x ^ y); 
		    }
		    
		     public int hammingDistance2(int x, int y) {
		    int xor = x ^ y;
		    int distance = 0;
		    while (xor != 0) {
		      if (xor % 2 == 1)
		        distance += 1;
		      xor = xor >> 1;
		    }
		    return distance;
		  }
}
