package com.example.java8.fetures.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample2 {
    public static void main(String[] args) {
        // using pattern with flags
        Pattern pattern = Pattern.compile("ab", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("ABcabdAb");
        // using Matcher find(), group(), start() and end() methods
        System.out.println("ok? =" + matcher.matches());
        while (matcher.find()) {
            System.out.println("Found the text \"" + matcher.group()
                    + "\" starting at " + matcher.start()
                    + " index and ending at index " + matcher.end());
        }

        // using Pattern split() method
        pattern = Pattern.compile("\\W");
        matcher = pattern.matcher("one@two#three:four$five");
        System.out.println("ok? =" + matcher.matches() + " pattern.toString()=" + pattern.toString());
        String[] words = pattern.split("one+two#three:four$five");
        for (String s : words) {
            System.out.println("Split using Pattern.split(): " + s); // split baseado nos caracteres nao word(nao letras nem numeros_
        }

        // using Matcher.replaceFirst() and replaceAll() methods
        pattern = Pattern.compile("1*2");
        matcher = pattern.matcher("1111111234512678");
        System.out.println("ok? =" + matcher.matches());
        System.out.println("Using replaceAll: " + matcher.replaceAll("_"));
        System.out.println("Using replaceFirst: " + matcher.replaceFirst("_"));
    }
}
