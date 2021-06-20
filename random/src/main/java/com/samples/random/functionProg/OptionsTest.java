package com.samples.random.functionProg;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionsTest {
	private Optional<String> getEmpty() {
	    return Optional.empty();
	}
	 
	private Optional<String> getHello() {
	    return Optional.of("hello");
	}
	 
	private Optional<String> getBye() {
	    return Optional.of("bye");
	}
	 
	private Optional<String> createOptional(String input) {
	    if (input == null || "".equals(input) || "empty".equals(input)) {
	        return Optional.empty();
	    }
	    return Optional.of(input);
	}
	
	private void streamoption()
	{
		
		Optional<String> found1 = Stream.<Optional<String>>of(getEmpty(), getHello(), getBye())
			      .filter(Optional::isPresent)
			      .map(Optional::get)
			      .findFirst();
		
		Optional<String> found = Stream.<Supplier<Optional<String>>>of(this::getEmpty, this::getHello, this::getBye)
				.map(Supplier::get)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.findFirst();
	}
}
