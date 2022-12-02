package com.example.java8.fetures.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {

    public static void main(String[] args) {
        // You should use Pattern and Matches classes only when you need :
        // to manipulate the input String or you need to reuse the pattern
        Pattern pattern = Pattern.compile(".xx.");
        Matcher matcher = pattern.matcher("MxxV");

        System.out.println("input string matchs regex? : " + matcher.matches());
        System.out.println("input string matchs regex? : " + Pattern.matches(".xx.", "MxxV"));
        System.out.println("input string matchs regex? : " + "MxxV".matches(".xx."));

        //pattern = Pattern.compile("*xx*"); // bad pattern

        String str = "bbb";
        //java regular expression revolves around String
        //String provide a matches method also ( Internally it uses Pattern and Matcher )
        //if your requirement is just to check if the input String matches with the pattern,
        // you should save time and lines of code by using simple String matches method.
        System.out.println("Using String matches method: "+str.matches(".bb"));
        //Pattern class also contains matches method that takes regex and input String as argument and return boolean result after matching them.
        System.out.println("Using Pattern matches method: "+Pattern.matches(".bb", str));

        // ATTENTION
        /*
          Note that the pattern defined by regex is applied on the String from left to right and
          once a source character is used in a match, it can’t be reused.
          For example, regex “121” will match “31212142121”
          only twice as “_121____121”.
         */
    }
}
