package com.lumen.steamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ibm.icu.text.RuleBasedNumberFormat;

public class DStreamFiltering {

	public static void main(String[] args) {
		//Create a Array of Integer
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		System.out.println("*********Option 1***********");
		//Prepare array for a stream
		Stream<Integer> stream = Arrays.stream(array);
		
		stream.filter(new Predicate <Integer>() {
													@Override
													public boolean test(Integer t) {
														return t > 5;
													}
												})
			.forEach(streamOfArray -> System.out.println(streamOfArray));
		
		System.out.println("*********Option 2 -> reduced code lines***********");
		Stream<Integer> stream1 = Arrays.stream(array);
		stream1.filter(t -> t > 5)
				.forEach(streamOfArray -> System.out.println(streamOfArray));
		
		System.out.println("*********Option 3 -> prove stream API proccesses serially***********");
		Stream<Integer> stream2 = Arrays.stream(array);
		stream2
				.peek(element -> System.out.println("Elelment: "+ element))
				.filter(t -> {
					System.out.println("Element is processing"+ t);
					return t > 5;
					})
				.forEach(streamOfArray -> {
					System.out.println("In forEach: " + streamOfArray);
					System.out.println("Number -> "+streamOfArray);
					});
		
		System.out.println("*********Option 4 -> Use map() method and convert number to words***********");
		RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.US, RuleBasedNumberFormat.SPELLOUT);
		Stream<Integer> stream3 = Arrays.stream(array);
		Stream<Integer> filterStream = stream3.filter(filteredStream -> filteredStream > 5 ); // Stream3 is terminated here
		Stream<String> stringStream = filterStream.map(mappedStream -> nf.format(mappedStream)); // filterStream
		List<String> list = stringStream.collect(Collectors.toList());
		System.out.println(list);

        System.out.println("*********Option 5 -> takeWhile()***********");
        Integer[] array2  = {6, 7, 8, 10, 18, 5, 10 , 20, 2, 1};
        Stream<Integer> stream4 = Arrays.stream(array2);
        stream4
                .takeWhile(tw -> tw > 5)
                .forEach(System.out::println);

        System.out.println("*********Option 6 -> sort() and takeWhile()***********");
        Integer[] array3  = {6, 7, 8, 10, 18, 5, 10 , 20, 2, 1};
        Arrays.stream(array3);
        Arrays.stream(array3)
                .sorted()
                .takeWhile(n -> n < 10)
                .forEach(System.out::println);


    }

}
