package com.example.demo.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsStringVaidation {
    static String name = "Nirmalkanna";

    public static void main(String[] args) {
        stringValidation();
    }

    static void stringValidation() {
        //System.out.println(nonRepeatVal);
        Map<String, Long> val = Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        val.forEach((k, v) -> System.out.println(k + ":" + v));
        String nonRepeatVal = Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .findFirst().get().getKey();
        System.out.println(nonRepeatVal);
    }


}
