package com.example.java8.fetures.StringPackage;

/*
String intern() Method
When we create a string using string literal, it will be created in string pool but
 what if we create a string using new keyword with the same value that exists in string pool?
 Can we move the String from heap memory to string pool?
 For this intern() method is used and it returns a canonical representation of string object.
 When we call intern() method on string object that is created using the new keyword, it checks
  if there is already a String with the same value in the pool? If yes, then it returns the reference of that String object from the pool.
If not, then it creates a new String with the same content in the pool and returns the reference.

 */
public class StringInternExample {

    public static void main(String[] args) {

        String s1 = "pankaj";
        String s2 = "pankaj";
        String s3 = new String("pankaj");

        System.out.println(s1==s2);//true
        System.out.println(s2==s3);//false

        String s4 = s3.intern();
        System.out.println(s1==s4);//true

    }
}
