package com.example.java8.fetures.generics.wildcard.lower;

import java.util.ArrayList;
import java.util.List;

/*
Suppose we want to add Integers to a list of integers in a method, we can keep the argument type as List<Integer>
but it will be tied up with Integers whereas List<Number> and List<Object> can also hold integers,
so we can use a lower bound wildcard to achieve this.
 */
public class GenericWildCard {

    private static List<Integer> listInteger  = new ArrayList<Integer>();

    public static void main(String[] args) {
        addInteger(new ArrayList<Integer>());

        addInteger(new ArrayList<Number>());

        addInteger(new ArrayList<Object>());

        listInteger.forEach(x -> System.out.println("listInteger=" + x));

        // Subtyping using Generics Wildcard
        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>
    }

    public static void addInteger(List<? super Integer> list) {
        list.add(50);
        list.forEach(x -> System.out.println(x));

        listInteger.add(50);
    }
}
