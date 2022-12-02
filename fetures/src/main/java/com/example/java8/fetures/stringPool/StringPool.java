package com.example.java8.fetures.stringPool;

/*
When we use double quotes to create a String, it first looks for String with the same value in the String pool,
if found it just returns the reference else it creates a new String in the pool and then returns the reference.
 However using new operator, we force String class to create a new String object in heap space.
 We can use intern() method to put it into the pool or refer to another String object from the string pool having the same value.
 */
public class StringPool {

    /**
     * Java String Pool example
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");

        System.out.println("s1 == s2 :"+(s1==s2));
        System.out.println("s1 == s3 :"+(s1==s3));
    }
}
