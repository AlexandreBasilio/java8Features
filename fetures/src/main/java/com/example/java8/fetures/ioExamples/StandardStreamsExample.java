package com.example.java8.fetures.ioExamples;

import java.util.Scanner;

public class StandardStreamsExample {
    public static void main(String[] args)
    {
        try {

            // using System.in class to import the Scanner
            // that helps in taking input from the user
            Scanner s = new Scanner(System.in);

            // using System.out class print the output on
            // the screen using .print() ans .println()
            // methods
            System.out.print("Enter the value of A : ");
            int a = s.nextInt();
            System.out.println("Value of A is : " + a);

            System.out.print("Enter the value of B : ");
            int b = s.nextInt();
            System.out.println("Value of B is : " + b);

            System.out.println("Result of division A/B is : " + (a / b));
        }
        catch (Exception ex) {

            // using System.err class to print the error
            // message
            System.err.print("Exception message...: " + ex.getMessage() + ex.getCause());
            ex.printStackTrace();
        }
    }
}
