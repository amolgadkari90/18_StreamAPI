package com.lumen.steamapi;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.stream.Stream;

public class FStreamSorting {

	public static void main(String[] args) {
		
		Stream.of("Zoran", "Sham", "Ram", "Om","Kiran", "John", "Rakesh", "Viraj", "Amol")
		.filter(fst ->  {
			System.out.println("Filtering -> " + fst);
			return fst.length() > 2; })
		.sorted()
		.peek(pst ->  System.out.println("Sorting done ->" + pst))
		.forEach(result -> System.out.println(result) );
        System.out.println("****** skip() method ******");
        Stream.of("Zoran", "Sham", "Ram", "Om","Kiran", "John", "Rakesh", "Viraj", "Amol")
                .skip(3) // Skips first 3 elements from stream
                .forEach(result -> System.out.println(result) );
        System.out.println("****** skip() method ******");
        Stream.of("Zoran", "Sham", "Ram", "Om", "Om", "Kiran", "Kiran", "John", "rakesh", "Rakesh", "Viraj", "Amol")
                .distinct() // he selection of distinct elements
                .forEach(result -> System.out.println(result) );
		
		
		

	}

}
