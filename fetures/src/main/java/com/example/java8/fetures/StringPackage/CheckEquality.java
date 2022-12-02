package com.example.java8.fetures.StringPackage;

/*
There are two ways to check if two Strings are equal or not - using “==” operator or using equals method.
When we use “==” operator, it checks for the value of String as well as the reference but

in our programming, most of the time we are checking equality of String for value only.
So we should use the equals method to check if two Strings are equal or not.
 There is another function equalsIgnoreCase that we can use to ignore case.
 */
public class CheckEquality {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3= new String("abc");
        System.out.println("s1 == s2 ? "+(s1==s2)); //true
        System.out.println("s1 == s3 ? "+(s1==s3)); //false
        System.out.println("s1 equals s3 ? "+(s1.equals(s3))); //true
    }
}
