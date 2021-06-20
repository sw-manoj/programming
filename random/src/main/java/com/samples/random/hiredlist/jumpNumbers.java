package com.samples.random.hiredlist;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.FutureTask;

public class jumpNumbers {

//	You are given a list of non-negative integers and you start at the left-most integer in this list. After that you need to perform the following step:
//
//		Given that the number at the position where you are now is P you need to jump P positions to the right in the list. For example, if you are at position 6 and the number at position 6 has the value 3, you need to jump to position 6 + 3 = 9. Repeat this operation until you reach beyond the right-side border of the list.
//		Your program must return the number of jumps that it needs to perform following this logic. Note that the list may contain the number 0, which mean that you can get stuck at a this position forever. In such cases you must return the number -1.
	public static int jump_over_numbers(List<Integer> list) {

		int pos = 0;
		int total = 0;
		int lastPos = -1;
		while (lastPos != pos && pos < list.size()) {
			lastPos = pos;
			pos = pos + list.get(pos);
			total++;
		}
		return (pos >= list.size()) ? total : -1;
	}

	public static void main(String[] args) {
		System.out.println(jump_over_numbers(Arrays.asList(new Integer[] { 3, 4, 1, 2, 5, 7, 9, 0, 1, 2, 3, 1 })));

		System.out.println(jump_over_numbers(Arrays.asList(new Integer[] { 3, 4, 1, 0, 5, 7, 9, 0, 1, 2, 3, 1 })));
	}
	
	 public static void main1(String [] args) {
	        Thread thread = new TaskThread1();
	        thread.start();        
	    }
	    
	    private static class TaskThread1 extends Thread {
	        @Override
	        public void run(){
	            System.out.println("Hello from new thread");
	        }
	    }
	    
	    public static void main2(String [] args) {
	    	
	    	 Thread thread = new TaskThread1();
		        thread.start();    
		        
	        thread = new Thread(new Task2());
	        thread.start();
	    }
	 
	    private static class Task2 implements Runnable {
	        @Override
	        public void run(){
	            System.out.println("Hello from new thread");
	        }
	    }
}
