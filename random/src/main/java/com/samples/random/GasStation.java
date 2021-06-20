package com.samples.random;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
	    int n = gas.length;

	    int total_tank = 0;
	    int curr_tank = 0;
	    int starting_station = 0;
	    for (int i = 0; i < n; ++i) {
	      total_tank += gas[i] - cost[i];
	      curr_tank += gas[i] - cost[i];
	      // If one couldn't get here,
	      if (curr_tank < 0) {
	        // Pick up the next station as the starting one.
	        starting_station = i + 1;
	        // Start with an empty tank.
	        curr_tank = 0;
	      }
	    }
	    return total_tank >= 0 ? starting_station : -1;
	  }
	
	
	public int canCompleteCircuit1(int[] gas, int[] cost) {
	    int n = gas.length;

	    int total_tank = 0;
	    int curr_tank = 0;
	    int starting_station = 0;
	    for(int i = 0 ; i < n ;i++)
	    {
	    	total_tank += gas[i] -cost[i];
	    	curr_tank += gas[i] -cost[i]; //sub cost to move to next stop
	    	
	    	if(curr_tank < 0)
	    	{
	    		curr_tank = 0;
	    		starting_station = i+1;
	    	}
	    }
	    
	    return total_tank >= 0 ? starting_station : -1;
	  }
	
	public static void main(String[] args) {
		int gas[] = {4,1,2,3};
		int cost[] ={3,3,2,2};
		GasStation st = new GasStation();
		System.out.println(st.canCompleteCircuit(gas, cost));
	}
}
