package com.example.demo.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestJavaStreams {
    static List<String> test = Arrays.asList("Java", "Spring", "Hibernate", "Sql", "Rest", "Sql");
    static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    static Map<String, String> map = new HashMap<>();
    static String name = "Nirmalkanna";

    public static void main(String[] args) {
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.put("A", "1");
        // printasList();
        // printSort();
        // mapIteration();
        //getNumbersCount();
        //stringValidation();
        //stringGroupingBy();
        //stringSorting();
        duplicates();
    }

    static void duplicates(){
        String input = "programming";
        List<Character> duplicates = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Duplicate characters: " + duplicates); // Output: Duplicate characters: [r, g]


    }
    static void stringSorting(){
        test.stream().sorted().collect(Collectors.toList()).forEach(s-> System.out.println(s));
        test.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(s-> System.out.println(s));

    }
    static void stringValidation() {
        Map<String, Long> val = Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        val.forEach((k, v) -> System.out.println(k + ":" + v));
        String nonRepeatVal = Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .findFirst().get().getKey();
        System.out.println(nonRepeatVal);
    }

    static void stringGroupingBy() {
        test.stream().mapToInt(String::length).forEach(s-> System.out.println(s));
        Map<Integer, List<String>> map = test.stream().collect(Collectors.groupingBy(String::length));
        map.forEach((k, v) -> System.out.println(k + "===" + v));
        Map<String, Long> mapCounting = test.stream().collect(Collectors.groupingBy(s->s,Collectors.counting()));
        mapCounting.forEach((k, v) -> System.out.println(k + "===" + v));
        Optional<String> longest = test.stream().reduce((a, b) -> a.length() > b.length() ? a : b);
		System.out.println(longest.get());
    }

    static void printasList() {
        List<String> result = test.stream().collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    static void printSort() {
        test.sort((s1, s2) -> s1.compareTo(s2));
        test.forEach(System.out::println);
    }

    static void mapIteration() {
        // map.forEach((k, v) -> System.out.println(k + " " + v));
        Map<Object, Long> val = test.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        val.forEach((k, v) -> System.out.println(k + ":" + v));
        Map<Object, List<String>> valList = test.stream().collect(Collectors.groupingBy(String::length));
        valList.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    static void getNumbersCount() {
        int count = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(count);
        long c = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(c);
        int minValue = numbers.stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);
        System.out.println(minValue);
        int maxValue = numbers.stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE);
        System.out.println(maxValue);
        numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        Map<Boolean, List<Integer>> numb = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        numb.forEach((k, v) -> System.out.println(k + ":" + v));
    }

}
