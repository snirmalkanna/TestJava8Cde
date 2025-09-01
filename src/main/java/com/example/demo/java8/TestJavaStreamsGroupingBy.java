package com.example.demo.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestJavaStreamsGroupingBy {
    static List<String> test = Arrays.asList("Java", "Spring", "Hibernate", "Sql", "Rest", "Sql");
    static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    static Map<String, String> map = new HashMap<>();
    static String name = "Nirmalkanna";

    public static void main(String[] args) {
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.put("A", "1");
        stringGroupingBy();
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

}
