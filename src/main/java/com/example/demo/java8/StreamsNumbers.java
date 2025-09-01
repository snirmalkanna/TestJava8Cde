package com.example.demo.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsNumbers {
    static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    public static void main(String[] args) {
        getNumbersCount();
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
