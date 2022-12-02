package com.example.java8.fetures.StringPackage;

public class PalindromeReplaceExamples {


    /*
    A String is said to be Palindrome if it’s value is same when reversed. For example “aba” is a Palindrome String.
    String class doesn’t provide any method to reverse the String but
    StringBuffer and StringBuilder class has reverse method that we can use to check if String is palindrome or not.
     */
    private static boolean isPalindromeString(String str) {
        if (str == null)
            return false;
        int length = str.length();
        System.out.println(length / 2);
        for (int i = 0; i < length / 2; i++) {

            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;
        }
        return true;
    }


    private static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        return strBuilder.toString().equals(str);
    }

    private static String removeChar(String str, char c) {
        if (str == null)
            return null;
        return str.replaceAll(Character.toString(c), "");
    }
}
