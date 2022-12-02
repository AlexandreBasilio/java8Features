package com.example.java8.fetures.predicate;

import java.util.function.Predicate;

public class PredicateFunctionDemo {

    public static void main (String[] args) {
//        PredicateFunctionDemo pfd = new PredicateFunctionDemo();
//        System.out.println("maior que 5 " + pfd.verifyLengthWord("alex"));

        // Predicate is a functional interface that test something and return a booelan
        // Here you are testing a String using the test method
        Predicate<String> checkTamanho = s -> s.length() > 5;
        System.out.println(checkTamanho.test("alex"));

    }

    private boolean verifyLengthWord(String word) {
        return (word.length() > 5) ? true : false;
    }
}
