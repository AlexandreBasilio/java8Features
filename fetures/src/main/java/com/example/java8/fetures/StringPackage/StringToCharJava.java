package com.example.java8.fetures.StringPackage;

public class StringToCharJava {
    public static void main(String[] args) {
        String str = "journaldev";

        //string to char array
        //  method to convert String to character array.
        char[] chars = str.toCharArray();
        System.out.println(chars.length);

        //char at specific index
        char c = str.charAt(2);
        System.out.println(c);

        //Copy string characters to char array
        char[] chars1 = new char[7];
        /*
        . In getChars example, first 7 characters of str will be copied to chars1 starting from its index 0. T
        hat’s all for converting string to char array and string to char java program. R
         */
        str.getChars(0, 7, chars1, 0);
        System.out.println("chars:" + chars1);
        System.out.println(chars1);

    }
}
