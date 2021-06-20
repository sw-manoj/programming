package com.samples.list;

public class KthSymbol {

	
	//flip varient first half flipped is second half
	// no of elements in N is 2 
	// https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1793/
//	public int kthGrammar(int N, int K) {
//        if (N == 1) return 0;
//        System.out.println(K +"=="+(N) + "==" + (1 << N-2));
//        if (K <= 1 << N-2)
//            return kthGrammar(N-1, K);
//        System.out.println(K +"=="+((K - (1 << N-2))) +"==="+N);
//        return kthGrammar(N-1, K - (1 << N-2)) ^ 1;
//    }
	
	public int kthGrammar1(int N, int K) {
		System.out.println(Integer.bitCount(K - 1));
        return Integer.bitCount(K - 1) % 2;
    }
	 
	 public int kthGrammar2(int N, int K) {
	        if(N == 1 && K == 1)
	        {
	            return 0;
	        }
	        int n = (K+1)/ 2;
	        int num = kthGrammar1(N-1,n);
	        if(K%2 == 0)
	        {
	            return num == 1 ? 0 : 1;
	        }
	        else
	        {
	            return num == 1 ? 1 : 0;
	        }
	    }
	    
	     public int kthGrammar(int N, int K) {
	        if (K == 1) return 0;
	        
	        int pre = 1 << (N - 2);
	         System.out.println(pre + "---" + N);
	        if (K <= pre) return kthGrammar(N - 1, K);
	        
	        return kthGrammar(N - 1, K - pre) ^ 1;
	    }
	     
	     public static void main(String[] args) {
	 		KthSymbol kth = new KthSymbol();
	 		int res = kth.kthGrammar(3, 2);
	 		System.out.println(res);
	 	}
	 	
}
