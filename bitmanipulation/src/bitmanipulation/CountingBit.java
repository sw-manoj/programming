package bitmanipulation;

public class CountingBit {
	
	
	
//	https://leetcode.com/problems/counting-bits/solution/
	 public int[] countBits(int num) {
	        int[] ans = new int[num + 1];
	        for (int i = 0; i <= num; ++i)
	            ans[i] = popcount(i);
	        return ans;
	    }
	    private int popcount(int x) {
	        int count;
	        for (count = 0; x != 0; ++count)
	          x &= x - 1; //zeroing out the least significant nonzero bit
	        return count;
	    }
	
//	    Last set bit is the rightmost set bit. Setting that bit to zero with the bit trick, x &= x - 1, leads to the following transition function:
//
//	    P(x) = P(x \mathrel{\&} (x - 1)) + 1;P(x)=P(x&(x−1))+1;
	    public int[] countBits1(int num) {
	        int[] ans = new int[num + 1];
	        for (int i = 1; i <= num; ++i)
	            ans[i] = ans[i & (i - 1)] + 1;
	        return ans;
	    }
	
	// count bits in a num subproblem of above

	public int hammingWeight(int n) {
	    int bits = 0;
	    int mask = 1;
	    for (int i = 0; i < 32; i++) {
	        if ((n & mask) != 0) {
	            bits++;
	        }
	        mask <<= 1;
	    }
	    return bits;
	}
	
	
//	In the binary representation, the least significant 11-bit in nn always corresponds to a 00-bit in n - 1n−1. Therefore, anding the two numbers nn and n - 1n−1 always flips the least significant 11-bit in nn to 00, and keeps all other bits the same.
//
//	Using this trick, the code becomes very simple.
	public int hammingWeight1(int n) {
	    int sum = 0;
	    while (n != 0) {
	        sum++;
	        n &= (n - 1);
	    }
	    return sum;
	}
}
