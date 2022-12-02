package com.example.java8.fetures.StringPackage;

/*
Java switch case is a neat way to code for conditional flow, just like if-else conditions.
Before Java 7, the only means to achieve string based conditional flow was using if-else conditions.
But Java 7 has improved the switch case to support String also.
 */
public class SwitchStringExample {

    public static void main(String[] args) {
        printColorUsingSwitch("red");
        printColorUsingIf("red");
        // switch case string is case sensitive
        printColorUsingSwitch("RED");
        printColorUsingSwitch(null);
    }

    private static void printColorUsingIf(String color) {
        if (color.equals("blue")) {
            System.out.println("BLUE");
        } else if (color.equals("red")) {
            System.out.println("RED");
        } else {
            System.out.println("INVALID COLOR CODE");
        }
    }

    private static void printColorUsingSwitch(String color) {
        switch (color) {
            case "blue":
                System.out.println("BLUE");
                break;
            case "red":
                System.out.println("RED");
                break;
            default:
                System.out.println("INVALID COLOR CODE");
        }
    }
}
