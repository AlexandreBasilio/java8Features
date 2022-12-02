package com.example.java8.fetures.collections.hashSet;

import java.util.ArrayList;
import java.util.HashSet;

// HashSet is slower than HashMap.
public class CollectionObjectStorage {
    public static void main(String[] args)
    {
        // Instantiate an object of HashSet
        HashSet<ArrayList> set = new HashSet<>();

        // create ArrayList list1
        ArrayList<Integer> list1 = new ArrayList<>();

        // create ArrayList list2
        ArrayList<Integer> list2 = new ArrayList<>();

        // Add elements using add method
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(5);
        set.add(list1);
        set.add(list2);

        // print the set size to understand the
        // internal storage of ArrayList in Set
        /*
        Before storing an Object, HashSet checks whether there is an existing entry using hashCode() and equals() methods.
        In the above example, two lists are considered equal if they have the same elements in the same order.
         When you invoke the hashCode()  method on the two lists, they both would give the same hash since they are equal.
         */
        System.out.println(set.size());
        set.forEach(arrayList -> System.out.println(arrayList));
        set.forEach(arrayList -> System.out.println(arrayList.hashCode()));


        HashSet<ArrayList> set3 = new HashSet<>();
        set3 = (HashSet<ArrayList>) set.clone();
        set3.forEach(arrayList -> System.out.println("CLONE=" + arrayList));
    }
}
