package com.example.java8.fetures.optional;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String[] str = new String[10];

        // verify whether the string is null in this application, we utilize the Optional class’s “ofNullable”
        Optional<String> checkNull =  Optional.ofNullable(str[5]);
        if (checkNull.isPresent()) {
            String word = str[5].toLowerCase();
            System.out.print(str);
        } else
            System.out.println("string is null");
    }

}
