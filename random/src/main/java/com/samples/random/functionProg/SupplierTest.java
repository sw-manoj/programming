package com.samples.random.functionProg;

public class SupplierTest {

	public static void main(String[] args) {
		SupplierTest test = new SupplierTest();
		
		String res = test.doAction(() -> "hello");
		System.out.println(res);
	}
	
	<T> T doAction(Supplier<T> supplier)
	{
		return supplier.get();
	}
}
