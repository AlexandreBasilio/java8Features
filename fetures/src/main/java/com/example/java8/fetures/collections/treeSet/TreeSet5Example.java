package com.example.java8.fetures.collections.treeSet;

import java.util.TreeSet;

// Let's see an example to retrieve and remove the highest and lowest Value.
public class TreeSet5Example {

    public static void main(String args[]){
        TreeSet<Integer> set=new TreeSet<Integer>();
        set.add(24);
        set.add(66);
        set.add(12);
        set.add(15);
        System.out.println("Lowest Value: "+set.pollFirst());
        System.out.println("Highest Value: "+set.pollLast());
    }
}
