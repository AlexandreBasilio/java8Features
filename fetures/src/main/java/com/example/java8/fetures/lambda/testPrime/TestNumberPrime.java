package com.example.java8.fetures.lambda.testPrime;

import org.apache.el.stream.Stream;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.lang.module.Configuration;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestNumberPrime {

    public static void main (String[] args) {

        // Verify if number is PRIMO (PRIME)
        for (int i=2; i < 10; i++) {
            System.out.println(i + " eh primo ? ............ Resposta=" + isPrimeDeclarativeBest(i));
            //isPrimeDeclarativeBest(i);
        }

        List<Integer> numeros = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17);
        System.out.println("todos os numeros=" + numeros + " soma=" + somaNumeros(numeros)
                + " square max impar entre 3 e 11=" + findSquareOfMaxOdd(numeros));

        var numerosPares = getNumerosWithPredicate(numeros, num -> num%2==0);
        System.out.println("numeros pares=" + numerosPares + " soma=" + somaNumeros(numerosPares));

        var numerosImpares = getNumerosWithPredicate(numeros, num -> num%2!=0);
        System.out.println("numeros impares=" + numerosImpares + " soma=" + somaNumeros(numerosImpares));




//        // Verify if number is PAIR
//        for (int i=2; i < 10; i++) {
//            System.out.println(i + " eh PAIR ? ............ Resposta=" + isPar(i));
//            //isPrimeDeclarativeBest(i);
//        }
    }

    //Traditional approach
    // The problem with above code is that it’s sequential in nature,
    // if the number is very huge then it will take significant amount of time.
    // Another problem with code is that there are so many exit points and it’s not readable.
    private static boolean isPrime(int number) {
        if(number < 2) return false;
        for(int i=2; i<number; i++){
            if(number % i == 0) return false;
        }
        return true;
    }

    private static boolean isPrimeDeclarativeBest(int number) {
        IntPredicate isDivisible = (inputRangeValue) -> {
              return number % inputRangeValue == 0;
        };

        // Anonymous class
        IntPredicate intPredicate = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return number % value == 0;
            }
        };

        // code only to see that IntStream.range is like a collection of int (it has a ITERATOR)
        // the collection has values for each index.
        // In this example, theses values are passed to predicate isDivisible
//        int x = number;
//        System.out.println("x=" + x);
//        IntStream range2 = IntStream.range(2, number);
//        range2.forEach(value -> System.out.println(" number....=" + x + " value range=" + value));

        // you can create a Predicate, like isDivisible
        // or you can put directly the lambda for IntPredicate
        return (number > 1) && (IntStream.range(2, number).noneMatch(isDivisible));
        //return (number > 1) && (IntStream.range(2, number).noneMatch(value -> number % value == 0));
    }

    private static List<Integer> getNumerosWithPredicate(Collection<Integer> numbers,
                                                         Predicate<Integer> predicate) {

        return numbers.parallelStream().filter(predicate).collect(Collectors.toList());
    }

    private static int somaNumeros(Collection<Integer> numbers) {
        return numbers.parallelStream().mapToInt(value -> value).sum();
    }

    private static int findSquareOfMaxOdd(List<Integer> numbers) {
        return numbers.stream()
                .filter(TestNumberPrime::isOdd)
                .filter(integer -> integer > 3)
                .filter(integer -> integer < 11)
                .max(Comparator.naturalOrder())
                .map(integer -> integer * integer)
                .get();
    }

    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }
}
