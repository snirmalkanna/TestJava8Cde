package com.example.demo.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsDupicates {

    public static void main(String[] args) {
        duplicates();
    }

    static void duplicates() {
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

}
