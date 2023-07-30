package com.samples.dynamicprog.medium;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
public class MinCostCutStick {

	public int minCost(int n, int[] cuts) {
		return 0;
	}

	public int minCostHelper(int n, int[] cuts, int l, int r) {
		if(l > r) {
			return 10000;
		}

		int stickLen = r - l;

		for(int i = 0 ; i < cuts.length ; i++) {
			if(l <= i && i <= r) {

			}
		}
		return 0;
	}
}
