package com.example.demo.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsSorting {
    static List<String> test = Arrays.asList("Java", "Spring", "Hibernate", "Sql", "Rest", "Sql");

    public static void main(String[] args) {
        printSort();
        stringSorting();
    }

    static void stringSorting(){
        //test.stream().sorted().collect(Collectors.toList()).forEach(s-> System.out.println(s));
        //test.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(s-> System.out.println(s));
        Set<String> val = test.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
                .stream().filter(x->x.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toSet());
        System.out.println("===="+val);

    }

    static void printSort() {
        test.sort((s1, s2) -> s1.compareTo(s2));
        test.forEach(System.out::println);
    }

}
