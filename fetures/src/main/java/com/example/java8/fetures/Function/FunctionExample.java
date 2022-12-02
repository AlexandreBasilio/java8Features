package com.example.java8.fetures.Function;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {

         //@param <T> the type of the input to the function
         //@param <R> the type of the result of the function
        Function<Integer, Integer> soma = i -> i + i;
        System.out.println("soma de 1 = " + soma.apply(1));

        Function<Integer, Integer> square = i -> i * i;
        System.out.println("square de 2 = " + soma.apply(2));
    }
}
