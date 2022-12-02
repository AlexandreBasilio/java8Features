package com.example.java8.fetures.Function;

import java.util.function.Function;

public class FunctionChanningExample {

    public static void main(String[] args) {

        Function<Integer, Integer> dobro = i -> i*2;
        Function<Integer, Integer> triplo = i -> i*i*i;

        System.out.println("dobro de 2 ="  + dobro.apply(2));
        System.out.println("triplo de 2= " + triplo.apply(2));

        System.out.println("first double and after cube=" + dobro.andThen(triplo).apply(2));

        System.out.println("firts cube using compose= " + dobro.compose(triplo).apply(2));

        System.out.println("first double and double and double=" + dobro.andThen(dobro).andThen(dobro).apply(23));

    }
}
