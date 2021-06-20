package com.samples.random.functionProg;

public interface derviedInterface extends Supplier,Runnable 
{
	

	@Override
	default void defaultCommon() {
		// TODO Auto-generated method stub
		Runnable.super.defaultCommon();
	}
}
