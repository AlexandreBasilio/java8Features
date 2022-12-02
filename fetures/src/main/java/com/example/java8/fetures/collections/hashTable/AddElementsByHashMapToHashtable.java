package com.example.java8.fetures.collections.hashTable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
the insertion order is not retained in the hashtable. Internally,
 for every element, a separate hash is generated and the elements are indexed based on this hash to make it more efficient.

 After adding the elements if we wish to change the element,
 it can be done by again adding the element with the put() method.
 */
public class AddElementsByHashMapToHashtable {

    public static void main(String args[])
    {
        // No need to mention the
        // Generic type twice
        Map<Integer, String> hm = new HashMap<>();

        // Inserting the Elements
        // using put() method
        hm.put(1, "one");
        hm.put(2, "one");
        hm.put(3, "three");

        // Initialization of a Hashtable
        // using Generics
        Hashtable<Integer, String> ht2
                = new Hashtable<Integer, String>(hm);

        // Print mappings to the console

        System.out.println("Mappings of ht2 : " + ht2);

        hm.forEach((integer, s) -> System.out.println(integer + " " + integer.hashCode() + " " + s));

        hm.put(1, "uno");
        hm.forEach((integer, s) -> System.out.println(integer + " " + integer.hashCode() + " " + s));

        hm.remove(1);
        hm.forEach((integer, s) -> System.out.println(integer + " " + integer.hashCode() + " " + s));
    }
}
