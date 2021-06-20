package com.samples.random.functionProg;

import java.util.Optional;

public interface Supplier<T> {

	T get();
	
	default void defaultCommon()
	{
		String password = " password ";
	    Optional<String> passOpt = Optional.of(password);
	    boolean correctPassword = passOpt.filter(
	      pass -> pass.equals("password")).isPresent();
	 
	    correctPassword = passOpt
	      .map(String::trim)
	      .filter(pass -> pass.equals("password"))
	      .isPresent();
	}
}
