package com.example.java8.fetures.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {

    public static void main(String[] args) {
        // (.) single caractere.. Voce soh pode 1 caractere ou numero. Cada ponto(.) é um caractere (letra ou numero)
        System.out.println(" regex with . = " + Pattern.matches(".", "a"));
        System.out.println(" regex with . = " + Pattern.matches(".", "A"));
        System.out.println(" regex with . = " + Pattern.matches(".", "Ab"));
        System.out.println(" regex with ... = " + Pattern.matches("...", "7yt"));

        // $ tem que terminar com
        System.out.println(" regex with  $ = " + Pattern.matches("a$", "a"));
        System.out.println(" regex with  $ = " + Pattern.matches("..a$", "f4a"));

        // ^ tem que comecar com para ser true
        System.out.println(" regex with ^ = " + Pattern.matches("^aaa..", "aaabb"));
        System.out.println(" regex with ^ = " + Pattern.matches("^a..", "abc"));
        System.out.println(" regex with ^ = " + Pattern.matches("^a..b$", "abnb"));
        System.out.println(" regex with ^ = " + Pattern.matches("^aaa", "AAA"));

        // [abc] no lugar de um ponto vc colocar que pode ser a,b ou c no ponto
        System.out.println(" regex with [abc]= " + Pattern.matches("^[abc]..", "abb"));
        System.out.println(" regex with [abc]= " + Pattern.matches("^[abc]....[pli]$", "a1234o"));
        System.out.println(" regex with [abc]= " + Pattern.matches("^[abc]....[pli]$", "a1234i"));
        System.out.println(" regex with [abc]= " + Pattern.matches("^[abc]....[pli]$", "a%#@!i"));
        System.out.println(" regex with [abc]= " + Pattern.matches("^[abc]...........[pli]$", "a1^.@$$/[]{}i"));
        System.out.println(" regex with [abc][12]= " + Pattern.matches("[abc][12]", "c1"));
        System.out.println(" regex with [a-c1-2]= " + Pattern.matches("[a-c1-2]", "c"));

        // [^abc] ^ negates the pattern: nao pode ser a,b ou c
        System.out.println(" regex with [^abc] = " + Pattern.matches("[^ab][^12].", "c9^"));
        System.out.println(" regex with [^abc] = " + Pattern.matches("[^ab][^12].", "b9^"));
        System.out.println(" regex with [^abc] = " + Pattern.matches("[^ab]..[^12].", "ch59^"));

        // telefone: (514) 241-7019
        System.out.println(" regex pour phone= " + Pattern.matches("[(][0-9][0-9][0-9][)].[0-9][0-9][0-9][-][0-9][0-9][0-9][0-9]", "(514) 241-7019"));

        // *********************************************************************************************************************
        // Java Regex Metacharacters
        // it’s like SHORT CODES for common matching patterns.
        /*
        There are two ways to use metacharacters as ordinary characters in regular expressions.
             1. Precede the metacharacter with a backslash (\).
             2. Keep metacharcter within \Q (which starts the quote) and \E (which ends it).
         */

        // \d	Any digits, short of [0-9]
        // \D	Any non-digit, short for [^0-9]
        System.out.println(" \\d  Any digits, short of [0-9] regex pour phone= " +
                Pattern.matches("[(]\\d\\d\\d[)].\\d\\d\\d[-]\\d\\d\\d\\d","(514) 241-7019"));

        System.out.println(" \\d  and \\D A- regex for code postale= " +
                Pattern.matches("[A-Z]\\d[A-Z]\\s\\d[A-Z]\\d","H3E 1K9"));
        System.out.println(" \\d  and \\D A- regex for code postale= " +
                Pattern.matches("[A-Z]\\d[A-Z]\\s\\d[A-Z]\\d","h3e 1k9"));
        System.out.println(" \\d  and \\D A- regex for code postale= " +
                Pattern.matches("[A-Za-z]\\d[A-Za-z]\\s\\d[A-Za-z]\\d","h3e 1k9"));

        // \s	Any whitespace character, short for [\t\n\x0B\f\r]
        // \S	Any non-whitespace character, short for [^\s]
        System.out.println(" \\d  Any digits, short of [0-9] regex pour phone= " +
                Pattern.matches("[(]\\d\\d\\d[)]\\s\\d\\d\\d[-]\\d\\d\\d\\d","(514) 241-7019"));

        //  \w	Any word character, short for [a-zA-Z_0-9]
        //  \W	Any non-word character, short for [^\w]

        // \b	A word boundary
        // \B	A non word boundary

        // *********************************************************************************************************************
        // Regular Expression in Java - Quantifiers
        // Java Regex Quantifiers specify the number of occurrence of a character to match against.

        System.out.println(" [abc]+ means - a, b, or c - one or more times= " +
                Pattern.matches("[abc]+","aaccbbbca"));
        System.out.println(" [abc]+ means - a, b, or c - one or more times= " +
                Pattern.matches("[abc]+","ccccc"));
        System.out.println(" [abc]? means - a, b, or c - once or not at all= " +
                Pattern.matches("[abc]?","a"));
        System.out.println(" [abc]? means - a, b, or c - once or not at all= " +
                Pattern.matches("[abc]?",""));
        System.out.println(" [abc]* means - a, b, or c - occurs zero or more times= " +
                Pattern.matches("[abc]*",""));
        System.out.println(" [abc]* means - a, b, or c - occurs zero or more times= " +
                Pattern.matches("[abc]*","aaaaabbbcccaaaccc"));
        System.out.println(" [abc]{5} means - a, b, or c -  occurs exactly n times= " +
                Pattern.matches("[abc]{5}","bbbbb"));
        System.out.println(" [abc]{5,7} means - a, b, or c -  occurs n or more times= " +
                Pattern.matches("[abc]{5,}","bbbbbbbbbbbbbbb"));
        System.out.println(" [abc]{5,7} means - a, b, or c -  occurs at least n times but not more than m times= " +
                Pattern.matches("[abc]{5,7}","bbbbbbb"));

        // group: groups is used to treat multiple characters as a single unit.
        Pattern pattern = Pattern.compile("(abc)+(nmc)+");
        Matcher matcher = pattern.matcher("abcabcabcnmcnmc");
        System.out.println(" GROUP (abc)+(nmc)+   = " +
                matcher.matches() + " number of capturing groups =" + matcher.groupCount());

        // You can use Backreference in the regular expression with a backslash (\)
        // So here, \\1 faz referencia ao primeiro grupo (\w\d)\
        System.out.println("(\\w\\d)\\1  =" + Pattern.matches("(\\w\\d)\\1", "a2a2")); //true
        System.out.println("(\\w\\d)(abc)\\1  =" + Pattern.matches("(\\w\\d)(abc)\\1", "a2abca2")); //true
        // So here, \\2 faz referencia ao segundo grupo (abc)
        System.out.println("(\\w\\d)(abc)\\2  =" + Pattern.matches("(\\w\\d)(abc)\\2", "a2abcabc")); //true
        System.out.println("(\\w\\d)\\1  =" + Pattern.matches("(\\w\\d)\\1", "b2b2")); //false

        System.out.println(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B2AB")); //true
        System.out.println(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B3AB")); //false
    }
}
