package com.lumen.steamapi;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class BSreatmOfExample {

	public static void main(String[] args) {
		Consumer<Integer> consumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
		//Storing the data in Array -> Stream.of
		Stream<Integer> stream = Stream.of(1, 2 ,3 ,4 ,5);
		//Capture each object and forEach processing data one by one 
		stream.forEach(consumer);
		
		
		System.out.println("*********** Option 2 reducing code lines**************");
		//forEach() method is art of stream class
		Stream.of(6,7,8,9,10).forEach(x -> System.out.println(x)); // In Lambda no need to write datatype
		
		System.out.println("*********** Option 3 reducing code lines**************");
		
		
		
		
	}
}
