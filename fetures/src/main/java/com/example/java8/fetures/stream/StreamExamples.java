package com.example.java8.fetures.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main (String[] args) {

        List<Integer> numeros = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        int sum = numeros.stream().filter(integer -> integer < 5).mapToInt(value -> value).sum();
        System.out.println(sum);

        // sequential stream
        numeros.stream()
                .filter(integer -> integer < 5)
                .mapToInt(value -> value)
                .forEach(integer -> System.out.println(integer));

        // parallel stream
        numeros.parallelStream()
                .filter(integer -> integer < 5)
                .mapToInt(value -> value)
                .forEach(integer -> System.out.println(integer));
    }
}
