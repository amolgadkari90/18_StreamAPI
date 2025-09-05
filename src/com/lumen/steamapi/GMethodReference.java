package com.lumen.steamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;



public class GMethodReference {
    public static void main(String[] args) {
        Isum isum = new Isum(){
            @Override
            public int sum(int a, int b){
                return a + b;
            }
        };

        int sum = isum.sum(10, 10);
        System.out.println("The sum (using Anoynrmous class Implementation) -> "+ sum);

        System.out.println("********* Option 2: Using labmda funcion *************");
        Isum sumLambdaway = (a, b) -> a+b;
        System.out.println("The sum (using lambda way) -> "+ sumLambdaway.sum(10, 10));
        System.out.println("********* Option 3: Reusing the method present is ur project and referring to the method *************");
        Isum sumMethodRefrence = GMethodReference::addition;
        int sum1 = sumMethodRefrence.sum(1000, 1000);
        System.out.println("The sum (using Method reference) -> "+ sum1);
        System.out.println("********* Option 4: Reusing the method in java Library and referring to the method *************");
        Isum sumInternalLib = Integer::sum;
        int sum2 = sumInternalLib.sum(2000, 2000);
        System.out.println("The sum (using Internal Method reference) -> "+ sum2);

        System.out.println("*********5: Sorting using method reference ***********");
        List<Integer> unsortedList = Arrays.asList(8, 5, 7, 10, 17, 15, 9, 26, 7, 5, 6);
        Isort isort = (list) -> {Collections.sort(unsortedList);};
        isort.sortAList(unsortedList);
        System.out.println("Sorted list -> "+ unsortedList);
        
        System.out.println("*********6: In Method referencing care about passing parameters not return type ***********");
        IPrint iprint = GMethodReference :: print;
        iprint.printData("Amol");
        
        System.out.println("*********7: Use BiFunction -> Inbuilt Functional Interface***********");
        BiFunction<Integer, Integer, Integer> calculation = Integer:: sum;
        Integer result = calculation.apply(20, 20);
        System.out.println("Result -> "+result);
        
        System.out.println("*********9: Use BiPredicate -> Inbuilt Functional Interface***********");
        BiPredicate<String, String> check = Object::equals;
        boolean res = check.test("Amol", "Amol");
        System.out.println("Res -> "+ res);
        
        System.out.println("*********10: Use object reference when method is not static***********");
        BiFunction<String, String , String > concatStr = new GMethodReference()::concatString;
        String res1 = concatStr.apply("Amol", " Gadkari");
        System.out.println("Res1 -> "+ res1);
        
        System.out.println("*********11: Pass object reference and access non static methods -> First arg is the Object***********");
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        BiFunction<ArrayList<Integer>, Integer , Boolean> addList = ArrayList::add; // Passing Object reference of ArrayList<Integer>
        Boolean res3 = addList.apply(arraylist, 10);
        System.out.println("Res3 -> "+ res3);
        System.out.println(arraylist);
        
        System.out.println("*********12: Unbound instance -> Give me an object later.” First SAM arg is that object Automatic Mapping***********");
        String str = "Amol Gadkari";
        Function<String, String> upperCase = String::toUpperCase;
        String res2 = upperCase.apply(str);
        System.out.println("Res2 -> "+ res2);
        
        System.out.println("*********13: Pass object reference and access non static methods ***********");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    }

    static int addition(int n1, int n2){
        return n1+n2;
    }
    
    static String print(String s) {
    	System.out.println("String -> "+s);
    	return s;
    }
    
    //Non static method
    String concatString(String str1, String str2){
		return str1+str2;
    	
    }
}
