package com.example.java8.fetures.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class AnotherStreamExamples {

    public static void main(String[] args) {

        // ******************************************** CREATING STREAMS
        // ********************************************
        // (Stream.of)
        Stream<Integer> integerStream = Stream.of(1,2,3,4);
        Stream<String> stringStream = Stream.of("alex","Bianca", "Isabela", "Lara");
        Stream<Double> doubleStream = Stream.of(10.20, 30.45, 40d );
        Stream<Integer> integerStream1 = Stream.of(new Integer[]{1,2,3,4});

        // .stream() and .parallelStream()
        List<Integer> listNumbers = List.of(1, 2, 3, 4);
        var listNames = List.of("eu", "tu", "eles");

        Stream<Integer> stream = listNumbers.stream();
        Stream<String> stringStream1 = listNames.parallelStream();

        LongStream longStrem = Arrays.stream(new long[]{1,2,3,4});
        IntStream intStream = "abc".chars();

        // ******************************************** Converting stream to Collection or Array
        // ********************************************

        List<Integer> collect = integerStream.collect(Collectors.toList());
        System.out.println("converting to collection " + collect);

        integerStream = Stream.of(1,2,3,4); // crio de novo senao tenho erro: java.lang.IllegalStateException: stream has already been operated upon or closed
        Set<Integer> set1 = integerStream.collect(Collectors.toSet());
        System.out.println("converting to set " + set1);
        // Object[] array = integerStream.toArray();
       // System.out.println("converting to array " + array);

        integerStream = Stream.of(1,2,3,4);
        Map<Integer, Integer> collectMapped = integerStream.collect(Collectors.toMap(o -> o, integer -> integer * 2));
        System.out.println("converting to collection and mapping value * 2 " + collectMapped);

        integerStream = Stream.of(1,2,3,4);
        Integer[] integerArray = integerStream.toArray(Integer[]::new);
        System.out.println("converting to array integer " + Arrays.toString(integerArray));

        // ******************************************** Intermediaite operations (filter, map, sorted, flatMap)
        // ********************************************

        // FOREACH, MAP, FILTER
        List<String> a = stringStream.filter(s -> isNameContains(s)).collect(Collectors.toList());
        System.out.println("filter name that have letter a " + a);

        integerStream = Stream.of(1,2,3,4);
        integerStream.filter(integer -> integer > 2)
                .map(integer -> integer+10)
  //              .collect(Collectors.toList())
                .forEach(integer -> System.out.println("filter integer > 2 " + integer));
        //System.out.println("filter integer > 2 " + collect1);

        // SORTED
        stringStream = Stream.of("Alex","Bianca", "Isabela", "Lara");
        List<String> orderedCollection = stringStream.sorted().collect(Collectors.toList());
        System.out.println("em ordem alfabetica=" + orderedCollection);

        stringStream = Stream.of("Alex","Bianca", "Isabela", "Lara");
        List<String> reversedOrderedCollection = stringStream
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("em ordem alfabetica reversed =" + reversedOrderedCollection);

        stringStream = Stream.of("Alex","Bianca", "Isabela", "Lara");
        List<String> naturalOrderCollection = stringStream
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println("em ordem alfabetica natural order =" + naturalOrderCollection);

        // FLATMAP - create a stream from the stream of list.
        Stream<List<String>> namesOriginalList = Stream.of(
                Arrays.asList("Pankaj"),
                Arrays.asList("David", "Lisa"),
                Arrays.asList("Amit"));
        //flat the stream from List<String> to String stream
//        Stream<String> flatStream = namesOriginalList
//                .flatMap(strList -> strList.stream());
        List<String> collect1 = namesOriginalList
                .flatMap(strList -> strList.stream()).sorted().collect(Collectors.toList());

       // flatStream.forEach(System.out::println);
        System.out.println("- result flat map=" + collect1);


        // ******************************************** Terminal Operations
        // ********************************************
        Stream<Integer> numbers = Stream.of(1,2,3,4,5);
        // REDUCE
        // perform a reduction on the elements of the stream,
        //  using associative accumulation function (integer + integer2), and return an Optional
        Optional<Integer> reduce = numbers.reduce((integer, integer2) -> integer + integer2);
        System.out.println("reduce example with integer=" + reduce.get());

        // COUNT -  count the number of items in the stream.
        numbers = Stream.of(1,2,3,4,5);
        System.out.println("count example with integer=" + numbers.count());

        // FOREACH -  count the number of items in the stream.
        numbers = Stream.of(5,2,3,4,1);
        numbers.forEach(integer -> System.out.println("forEach example: " + integer));

        // FOREACH ordered-  count the number of items in the stream.
//        numbers = Stream.of(5,2,3,4,1);
//        numbers.forEachOrdered(integer -> System.out.println("forEach ordered example: " + integer));

        // MATCH (anyMatch, allMatch, noneMatch)
        Stream<Integer> numbers3 = Stream.of(1,2,3,4,5);
        System.out.println("Stream contains 4? "+numbers3.anyMatch(i -> i==4));
        //Stream contains 4? true

        numbers3 = Stream.of(1,2,3,4,5);
        if (numbers3.anyMatch(integer -> integer ==4)) {
            numbers3 = Stream.of(1,2,3,4,5);
            System.out.println("tem 4 em " + numbers3.collect(Collectors.toList()));
        }

        Stream<Integer> numbers4 = Stream.of(1,2,3,4,5);
        System.out.println("Stream contains all elements less than 10? "+numbers4.allMatch(i -> i<10));
        //Stream contains all elements less than 10? true

        Stream<Integer> numbers5 = Stream.of(1,2,3,4,5);
        System.out.println("Stream doesn't contain 10? "+numbers5.noneMatch(i -> i==10));
        //Stream doesn't contain 10? true

        numbers5 = Stream.of(1,2,3,4,5);
        System.out.println("Find first="+numbers5.findFirst().get());

        numbers5 = Stream.of(1,2,3,4,5);
        System.out.println("find Any= "+numbers5.findAny().get());

        Stream<String> names4 = Stream.of("Pankaj","Amit","David", "Lisa");
        Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();
        if(firstNameWithD.isPresent()){
            System.out.println("First Name starting with D="+firstNameWithD.get()); //David
        }
    }

    private static boolean isNameContains(String s) {
        if (s.indexOf("b") != -1) {
            return true;
        }
        return false;
    }


}
