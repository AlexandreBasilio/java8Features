package com.example.java8.fetures.scannerClass;

import java.util.Scanner;
/*
Java Scanner class is part of the java.util package. It was introduced in Java 1.5 release.
The Scanner is mostly used to receive user input and parse them into primitive data types such as int, double or default String.
 It’s a utility class to parse data using regular expressions by generating tokens.

 */
public class ScannerExamples {

    public static void main(String[] args) {

        // create scanner
        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter(System.getProperty("line.separator"));
        scanner.useDelimiter(",");
        System.out.println("Enter your name");
        while (scanner.hasNext()) {
            System.out.println("hello=" + scanner.next());
        }
        scanner.hasNext();
        System.out.println("hello=" + scanner.next());
        scanner.close();
    }
}
