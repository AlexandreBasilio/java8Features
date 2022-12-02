package com.example.java8.fetures.StringPackage;

import java.util.Arrays;
import java.util.List;

public class JavaStringnewsJava8And9 {

    public static void main(String[] args) {

        /*
        A new static method join() has been added in String class in Java 8.
        This method returns a new String composed of copies of the CharSequence elements joined together with a copy of the specified delimiter.
         Let’s look at an example to understand it easily.
         */

        List<String> words = Arrays.asList(new String[]{"Hello", "World", "2019"});
        String msg = String.join(" ", words);
        System.out.println(msg);

        /*
         There are two methods added in String class in Java 9 release. They are - codePoints() and chars().
         Both of these methods return IntStream object on which we can perform some operations. Let’s have a quick look at these methods.
         */
        String s = "abc";
        s.codePoints().forEach(x -> System.out.println(x));
        s.chars().forEach(x -> System.out.println(x));

    }
}
