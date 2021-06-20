package com.samples.dfs.medium;

import java.util.Arrays;

public class MaxAreaCakePiece {
	
//	https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
	public static void main(String[] args) {
		MaxAreaCakePiece cakePiece = new MaxAreaCakePiece();
		
		System.out.println(cakePiece.maxArea(5, 4, new int[] {3,1}, new int[] {1}));

	}
	
	public int find_max(int[] cuts, int def)
	{
		int max = 0;
		 if(cuts.length > 0)
        {
			 max = cuts[0];
        }
        else
        {
        	max = def;
        }
	        
	        
        for(int i = 1 ; i < cuts.length ; i++)
        {
        	max = Math.max(max, cuts[i] - cuts[i-1]);
        
        }
        
        return Math.max(max, def- cuts[cuts.length-1]);
	}

	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int h_max = find_max(horizontalCuts, h);
        int v_max = find_max(verticalCuts, w);
       

        int mod = 1000000007;
        //return ((h_max % mod) * (v_max % mod)) % mod;
        
        return (int) ((h_max * v_max) % (mod));    }
}
