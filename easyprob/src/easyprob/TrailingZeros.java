package easyprob;

public class TrailingZeros {
	
	public static void main(String[] args) {
		TrailingZeros zero = new TrailingZeros();
		System.out.println(zero.trailingZeroes(30));
	}

//	https://leetcode.com/problems/factorial-trailing-zeroes/solution/
	public int trailingZeroes(int n) {
	    int zeroCount = 0;
	    long currentMultiple = 5;
	    while (n > 0) {
	        n /= 5;
	        zeroCount += n;
	    }
	    return zeroCount;
	}
	
	public int trailingZeroes1(int n) {
	    int zeroCount = 0;
	    // We need to use long because currentMultiple can potentially become
	    // larger than an int.
	    long currentMultiple = 5;
	    while (n >= currentMultiple) {
	        zeroCount += (n / currentMultiple);
	        currentMultiple *= 5;
	    }
	    return zeroCount;
	}
}
