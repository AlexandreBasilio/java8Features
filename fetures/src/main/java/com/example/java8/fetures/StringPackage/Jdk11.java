package com.example.java8.fetures.StringPackage;

import java.util.List;
import java.util.stream.Collectors;

/*
isBlank() - returns true if the string is empty or contains only white space codepoints, otherwise false.
lines() - returns a stream of lines extracted from this string, separated by line terminators.
strip(), stripLeading(), stripTrailing() - for stripping leading and trailing white spaces from the string.
repeat() - returns a string whose value is the concatenation of this string repeated given number of times.

 */
public class Jdk11 {

    public static void main(String[] args) {
        // isBlank()
        String s = "abc";
        System.out.println(s.isBlank());
        s = "";
        System.out.println(s.isBlank());

        // lines()
        String s1 = "Hi\nHello\rHowdy";
        System.out.println(s1);
        System.out.println("....");
        List lines = s1.lines().collect(Collectors.toList());
        System.out.println("lines=" + lines);
        System.out.println(s1);


        // strip(), stripLeading(), stripTrailing()
        String s2 = "  Java,  \tPython\t ";
        System.out.println("#" + s2 + "#");
        System.out.println("#" + s2.strip() + "#");
        System.out.println("#" + s2.stripLeading() + "#");
        System.out.println("#" + s2.stripTrailing() + "#");

        // repeat()
        String s3 = "Hello\n";
        System.out.println(s3.repeat(3));
        s3 = "Co";
        System.out.println(s3.repeat(2));

    }

}
