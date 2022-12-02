package com.example.java8.fetures.regex;

import java.util.regex.Pattern;

public class GFG {

    // Main driver method
    public static void main(String args[]) {

        // Following line prints "true" because the whole
        // text "geeksforgeeks" matches pattern
        // "geeksforge*ks"
        System.out.println(Pattern.matches("geeksforge*ks", "geeksforgeeks"));

        // Following line prints "false" because the whole
        // text "geeksfor" doesn't match pattern "g*geeks*"
        System.out.println(Pattern.matches("g*geeks*", "geeksfor"));
        System.out.println(Pattern.matches("g*geeks*", "ggeekss"));
        System.out.println(Pattern.matches("g*geeks*", "ggeeksssssssss"));
    }

}
