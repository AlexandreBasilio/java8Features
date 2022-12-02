package com.example.java8.fetures.StringPackage;

import java.nio.charset.StandardCharsets;

public class ByteArrayToString {

    public static void main(String[] args) {
        /*
        Did you notice that I am providing char while creating the byte array? It works because of autoboxing and char ‘P’ is being converted to 80 in the byte array.
         */

        byte[] byteArray = { 'P', 'A', 'N', 'K', 'A', 'J' };
        byte[] byteArray1 = { 80, 65, 78, 75, 65, 74 };

        String str = new String(byteArray);
        String str1 = new String(byteArray1);

        System.out.println(str);
        System.out.println(str1);

        //String class also has a method to convert a subset of the byte array to String.
        byte[] byteArray11 = { 80, 65, 78, 75, 65, 74 };
        String str2 = new String(byteArray1, 0, 3, StandardCharsets.UTF_8);
        System.out.println(str2);
    }
}
