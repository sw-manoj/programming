package com.samples.dynamicprog.easy;

public class PaintHouse {

//	https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3763/
	
	public int minCost(int[][] costs) {
        int max = 0;
        int house_len = costs.length-1;
        if(house_len < 0)
        {
        	return max;
        }
        
        int color_len = costs[0].length;
        
        
        for(int i = 1 ; i <= house_len ; i ++)
        {
        	costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
        	costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
        	costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);

        }
        
        return Math.min(costs[house_len][0], Math.min(costs[house_len][1], costs[house_len][2]));
    }
	
	public static void main(String[] args) {
		
		int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
		PaintHouse ph = new PaintHouse();
		System.out.println(ph.minCost(costs));
		
		System.out.println(ph.minCost(new int [][] {{7,6,2}}));
	}
}
