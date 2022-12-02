package com.example.java8.fetures.generics.wildcard.upperBounded;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcards {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(3); ints.add(5); ints.add(10);
        double sum = sum(ints);
        System.out.println("Sum of ints="+sum);

        List<Double> doubles = new ArrayList<>();
        doubles.add(3d); doubles.add(5d); doubles.add(10d);
        double sumd = sum(doubles);
        System.out.println("Sum of doubles="+sumd);

        List<Float> floats = new ArrayList<>();
        floats.add(3f); floats.add(5f); floats.add(10f);
        double sumf = sum(floats);
        System.out.println("Sum of floats="+sumf);

        List<Number> numbers = new ArrayList<>();
        numbers.add(3f); numbers.add(5f); numbers.add(10f);
        double sumn = sum(numbers);
        System.out.println("Sum of numbers="+sumn);
    }

    /*
        We use generics wildcard with extends keyword and the upper bound class or interface that will
         allow us to pass argument of upper bound or it’s subclasses types.
         posso passar como parametro todas as classes que extendem Number ou a propria Number
     */
    public static double sum(List<? extends Number> list){
        double sum = 0;
        // Note that with upper bounded list, we are not allowed to add any object to the list except null.
        // If we will try to add an element to the list inside the sum method, the program won’t compile.
        //list.add(null);
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }


    public static double sumOld(List<Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }
}
