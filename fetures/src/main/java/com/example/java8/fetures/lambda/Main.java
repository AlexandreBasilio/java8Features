package com.example.java8.fetures.lambda;

public class Main {

    public static void main (String[] args) {
        // lambda expression
        MyInterface fobj = (int x, int y) -> System.out.println((x+y));

        System.out.print("The result is = ");
        fobj.abstract_func(5, 5);
        fobj.default_Fun();
    }
}
