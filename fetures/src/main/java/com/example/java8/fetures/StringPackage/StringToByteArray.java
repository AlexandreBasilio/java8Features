package com.example.java8.fetures.StringPackage;

import java.util.Arrays;

public class StringToByteArray {

    public static void main(String[] args) {
        String str = "PANKAJ";
        byte[] byteArr = str.getBytes();
        // print the byte[] elements
        System.out.println("String to byte array: " + Arrays.toString(byteArr));
    }
}
