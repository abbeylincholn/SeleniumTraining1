package com.test.streams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    //Count the number of names starting with alphabet A in the list
    @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Amit");
        names.add("Fon");
        names.add("Rahul");
        names.add("Ankit");
        names.add("Rohit");

        int count = 0;

        /*for(String name : names) {
            if(name.startsWith("A")) {
                System.out.println(name);
                count++;
            }
        }
        System.out.println(count);*/


        for(int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if(actual.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter() {
         /*A lambda expression in Java introduces a new arrow operator (->), where the left side specifies the parameter
         and the right side defines the action to be performed on that parameter. */
        // there is no life for intermediate operators if there is no terminal operator
        // terminal operation will execute only if the intermediate operators (filter) are executed
        // We can create stream
        // how to use filter in Stream API
        // If action is more than one line, we need to use curly braces

        ArrayList<String> names = new ArrayList<>();
        names.add("Amit");
        names.add("Fon");
        names.add("Rahul");
        names.add("Ankit");
        names.add("Rohit");

        //names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
        long count = names.stream().filter(name -> name.startsWith("A")).count();
        System.out.println(count);

        long count1 = Stream.of("Amit", "Fon", "Rahul", "Ankit", "Rohit").filter(name -> {
                             //return  name.startsWith("A");
                             name.startsWith("A");
                             return true;
                        }).count();
        System.out.println(count1);

        // print all the names of ArrayList
        names.stream().filter(name -> name.length() > 4).forEach(System.out::println);
        System.out.println();
        names.stream().filter(name -> name.length() > 4).limit(1).forEach(name -> System.out.println(name));



    }

    @Test
    public void streamMap() {

        ArrayList<String> names = new ArrayList<>();
        names.add("Amit");
        names.add("Fon");
        names.add("Rahul");

        //print names which have last letter as "A" with UpperCase
        Stream.of("Amit", "Fon", "Rahul", "Ankit", "Rohit")
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);          //forEach(name -> System.out.println(name));   // used one is called method reference

        System.out.println();

        // prints names which have first letter as "A" with UpperCase and sorted
        List<String> names1 = Arrays.asList("Azit", "Fon", "Rahul", "Ankit", "Rohit");
        names.stream().filter(name -> name.endsWith("T"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        // concatenate streams 1 and 2
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
        //newStream.sorted().forEach(System.out::println);
        boolean flag = newStream.anyMatch(name -> name.equalsIgnoreCase("rahul"));
        System.out.println(flag);
        Assert.assertTrue(flag);

    }

    @Test
    public void streamCollect() {
        List<String> ls = Stream.of("Amit", "Fon", "Rahul", "Ankit", "Rohit").filter(name -> name.endsWith("t"))
                .collect(Collectors.toList());
        ls.forEach(System.out::println);
        //System.out.println(ls.get(0));

        //print unique numbers from this array, sort the array // avoid duplicates
        List<Integer> numbers = Arrays.asList(3,2,3,27,5,1,9,7);
        numbers.stream().distinct().sorted().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(numbers.get(2));



    }

}
