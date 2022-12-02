package com.example.java8.fetures.StringPackage;

import java.util.HashSet;
import java.util.Set;

/*
We will first take the first character from the String and permute with the remaining chars.
If String = “ABC” First char = A and remaining chars permutations are BC and CB.
 Now we can insert first char in the available positions in the permutations.
 BC -> ABC, BAC, BCA CB -> ACB, CAB, CBA We can write a recursive function to return the permutations and
 then another function to insert the first characters to get the complete list of permutations.
 */
public class StringFindAllPermutations {

    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static void main(String[] args) {
        String s = "AAC";
        String s1 = "ABC";
        String s2 = "ABCD";
        System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
        System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
        System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));
    }
}
