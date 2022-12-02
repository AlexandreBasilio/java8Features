package com.example.java8.fetures.StringPackage;

import java.util.Locale;

public class OthersStringFunctions {

    public static void main(String[] args) {

        //replace(char oldChar,  char newChar)
        String s = "Hello World";
        s = s.replace('l', 'm');
        System.out.println("After Replacing l with m :");
        System.out.println(s);

        //replaceAll(String regex, String replacement)
        String s1 = "Hello journaldev, Hello pankaj";
        s1 = s1.replaceAll("Hello", "Hi");
        System.out.println("After Replacing :");
        System.out.println(s1);

        //replaceFirst(String regex, String replacement)
        String s2 = "Hello guys, Hello world";
        s2 = s2.replaceFirst("Hello", "Hi");
        System.out.println("After Replacing :");
        System.out.println(s2);


        s = "journaldev.com";
        // %s is used to append the string
        System.out.println(String.format("This is %s", s));

        //using locale as Locale.US
        System.out.println(String.format(Locale.US, "%f", 3.14));




         s = "This is journaldev.com";
        s = s.substring(8,18);
        System.out.println(s);


         s1 = "Hello";
         s2 = "World";
         String s3 = s1 + s2;
        //using + operator
        System.out.println("Using + operator: ");
        System.out.println(s3);

        //using concat method
        System.out.println("Using concat method: ");
        System.out.println(s1.concat(s2));

    }

}
