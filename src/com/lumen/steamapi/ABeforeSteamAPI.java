package com.lumen.steamapi;

import java.util.stream.Stream;
public class ABeforeSteamAPI {
	// This is logic behind the stream API 
	//Especially before Jav8 this is how we use to work 

	public static void main(String[] args) {
		// This is supplier method which generate Stream of Hello!!!
		//Java Functional Interface : Supplier 
//		Supplier<String> supplier = new Supplier<String>() {
//			@Override
//			public String get() {
//				return "Hello!!!";
//			}
//		};
		//Java Functional Interface : Consumer 
//		Consumer<String> consumer = new Consumer<String>() {
//			@Override
//			public void accept(String t) {
//				System.out.println("The string -> " + t);
//			}
//		};
		// generate() is working as a Data Source.
		// generate() keeps producing data which are streamed in a data pipe.
//		Stream<String> stream = Stream.generate(supplier);
		//Stream API forEach() -> this is forEach() method not a forEach loop
//		stream.forEach(consumer);
		
		
		System.out.println("*********** Option 2 reducing code lines**************");
		Stream.generate(()->"Hello!!!").forEach(str -> System.out.println(str));
		
	}
}
