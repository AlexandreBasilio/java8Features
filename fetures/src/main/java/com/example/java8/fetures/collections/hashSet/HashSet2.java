package com.example.java8.fetures.collections.hashSet;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSet2 {

    public static void main(String args[]){
        ArrayList<String> list=new ArrayList<String>();
        list.add("Ravi");
        list.add("Vijay");
        list.add("Ajay");

        HashSet<String> set=new HashSet();
        set.addAll(list);
        set.add("Gaurav");

        set.forEach(s -> System.out.println(s));
    }
}
