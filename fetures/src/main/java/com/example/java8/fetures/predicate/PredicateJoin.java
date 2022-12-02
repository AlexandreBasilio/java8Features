package com.example.java8.fetures.predicate;

import java.util.function.Predicate;

public class PredicateJoin {

    private static final String TEXTO = "code decode";

    public static void main(String[] args) {
        Predicate<String> checkLength = s -> s.length() > 5;

        Predicate<String> checkLengthPar = s -> s.length()%2==0;

        System.out.println(" maior que 5 " + checkLength.test(TEXTO));
        System.out.println("tamnaho par " + checkLengthPar.test(TEXTO));

        System.out.println("join tamanho e se par " + checkLength.and(checkLengthPar).test(TEXTO));
        System.out.println("join tamanho e se par " + checkLength.and(checkLengthPar.negate()).test(TEXTO));
        System.out.println("join tamanho e se par " + checkLength.or(checkLengthPar).test(TEXTO));
    }
}
