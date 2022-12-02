package com.example.java8.fetures.stream.problema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Problem:
// If you are using parallel stream and lambda expressions are stateful, it can result in random responses.
// using parallelStream()
// Solution: user stream()
public class StatefulParallelStream {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ArrayList<Integer> result = new ArrayList<>();

        List<ArrayList<Integer>> collect = integers.parallelStream().map(integer -> {
            if (result.size() < 5) {
                result.add(integer);
            }
            return result;
        }).collect(Collectors.toList());

        System.out.println("result=" + result);

        result.clear();
        List<ArrayList<Integer>> collect2 = integers.stream().map(integer -> {
            if (result.size() < 5) {
                result.add(integer);
            }
            return result;
        }).collect(Collectors.toList());

        System.out.println("result=" + result);

        //
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        int[] ints = intStream.parallel().map(operand -> operand * 5).toArray();
        System.out.println("list int arrays=" + Arrays.toString(ints));

        // Java IntStream class is a specialization of Stream interface for int primitive

        // CREATING IntStream
        intStream = IntStream.of(1, 2, 3, 4);
        IntStream range = IntStream.range(1, 5);
        IntStream limit = IntStream.iterate(0, value -> value + 1).limit(10);
        limit.forEach(value -> System.out.println(value));

        System.out.println("GENERATE");
        IntStream generate = IntStream.generate(() -> {
            return (int) (Math.random() * 100000);
        }).limit(5);
        generate.forEach(value -> System.out.println(value));


//        intStream.parallel().map(operand -> {
//
//            if (result2.size() < 3) {
//                result2.add(operand);
//            }
//            return result2;
//        });
//        System.out.println("result2=" + result2);
    }
}
