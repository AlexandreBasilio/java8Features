package com.example.java8.fetures.collections.treeSet;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSet2Example {

    // Main driver method
    // Main driver method
    public static void main(String[] args)
    {
        // Creating a NavigableSet object  with
        // reference to TreeSet class
        // with NavigableSet you can navigate: use methods first, last, higher, lower
        NavigableSet<String> ts = new TreeSet<>();

        // Elements are added using add() method
        //In order to add an element to the TreeSet, we can use the add() method. However, the insertion order is not retained in the TreeSet.
        // Internally, for every element, the values are compared and sorted in ascending order.
        ts.add("bGeek");
        ts.add("aFor");
        ts.add("cGeeks");
        //ts.add(null);  // not permitted: java.lang.NullPointerException

        // Printing the elements inside the TreeSet object
        System.out.println("Tree Set is " + ts);

        String check = "Geeks";

        // Check if the above string exists in
        // the treeset or not
        System.out.println("Contains " + check + " " + ts.contains(check));

        // Print the first element in
        // the TreeSet
        System.out.println("First Value is " + ts.first());

        // Print the last element in
        // the TreeSet
        System.out.println("Last Value " + ts.last());

        String val = "Geek";

        // Find the values just greater
        // and smaller than the above string
        System.out.println("Higher " + ts.higher(val));
        System.out.println("Lower " + ts.lower(val));
    }

}
