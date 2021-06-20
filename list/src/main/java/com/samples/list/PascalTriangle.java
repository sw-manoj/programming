package com.samples.list;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		PascalTriangle p = new PascalTriangle();
		p.generates(5);
	}
	public List<List<Integer>> generate(int numRows) {
        int[][] numArr = new int[numRows+1][numRows+1];
        List<List<Integer>> result = new ArrayList();
        for(int i = 1; i <= numRows ;i++)
        {
//        	numArr[i][1] = 1;
//        	numArr[i][i] = 1;
        	List<Integer> colList = new ArrayList<Integer>();
        	for(int j = 1; j <=i ; j++)
        	{
        		if(j ==1 || j ==i)
        		{
        			numArr[i][j] = 1;
        		}
        		else
        		{
        			numArr[i][j] = numArr[i-1][j] + numArr[i-1][j-1];
        		}
        		colList.add(numArr[i][j]);
//        		System.out.print(numArr[i][j] + " ");
        	}
        	result.add(colList);
//        	System.out.println();
        }
        
//        System.out.println(result);
        return result;
    }
	
	 public List<List<Integer>> generates(int N) {
	        List<List<Integer>> l = new ArrayList<List<Integer>>();
	        ArrayList<Integer> temp_l = new ArrayList<Integer>();
	        for(int i=0; i<N; i++){
	            temp_l.add(0, 1);
	            System.out.println(temp_l.size());
	            for(int j=1; j<temp_l.size()-1; j++)
	                temp_l.set(j, temp_l.get(j)+temp_l.get(j+1));
	            l.add(new ArrayList<Integer>(temp_l));
	        }
	        System.out.println(l);
	        return l;
	            
	    }
}
