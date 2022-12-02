package com.example.java8.fetures.scannerClass.withRegularExpression;

import java.util.Scanner;

/*
Java Scanner is a utility class to read user input or process simple regex-based parsing of file or string source.
But, for real-world applications, it’s better to use CSV parsers to parse CSV data rather than using the Scanner class for better performance.
 */
public class ScannerWithRegex {

    public static void main(String[] args) {

        String data = "1a2b345c67d8,9#10";
        Scanner sc = new Scanner(data);
        sc.useDelimiter("\\D");

        while (sc.hasNext()) {
            System.out.println(sc.nextInt());
        }

        sc.close();
    }
}
