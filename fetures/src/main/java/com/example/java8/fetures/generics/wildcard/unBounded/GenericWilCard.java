package com.example.java8.fetures.generics.wildcard.unBounded;

import java.util.List;

/*
  Sometimes we have a situation where we want our generic method to be working with all types,
   in this case,
    an unbounded wildcard can be used. Its same as using <? extends Object>.
 */
public class GenericWilCard {

    public static void main(String[] args) {
        printData(List.of("fds","fsgggf"));
        printData(List.of(1,2));

        printData2(List.of("fdsfsf","fsgfsdfsdfggf"));
        printData2(List.of(10,20));
    }

    public static void printData(List<?> list){
        for(Object obj : list){
            System.out.println(obj + "::");
        }
    }

    public static void printData2(List<? extends Object> list){
        for(Object obj : list){
            System.out.println(obj + "::");
        }
    }
}
